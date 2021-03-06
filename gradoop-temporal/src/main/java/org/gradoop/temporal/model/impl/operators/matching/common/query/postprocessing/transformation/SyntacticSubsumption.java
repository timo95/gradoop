/*
 * Copyright © 2014 - 2021 Leipzig University (Database Research Group)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradoop.temporal.model.impl.operators.matching.common.query.postprocessing.transformation;

import org.gradoop.flink.model.impl.operators.matching.common.query.predicates.expressions.ComparisonExpression;

/**
 * Simplifies a CNF by subsuming clauses syntactically.
 * The transformation does not consider semantic information, but only syntax
 * !!! This class assumes input CNFs to be normalized, i.e. not to contain < or <= !!!
 */
public class SyntacticSubsumption extends Subsumption {

  @Override
  public boolean subsumes(ComparisonExpression c1, ComparisonExpression c2) {
    return c1.equals(c2);
  }
}
