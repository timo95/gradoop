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
package org.gradoop.flink.model.api.operators;

import org.gradoop.flink.model.api.epgm.BaseGraphCollection;

/**
 * A marker interface for instances of {@link UnaryBaseGraphCollectionToBaseGraphCollectionOperator}
 * that support the application on each element in a graph collection.
 *
 * @param <GC> type of the graph collection
 */
public interface ApplicableUnaryBaseGraphToBaseGraphOperator<GC extends BaseGraphCollection>
  extends UnaryBaseGraphCollectionToBaseGraphCollectionOperator<GC> {

  @Override
  default GC execute(GC collection) {
    return (collection.isTransactionalLayout()) ?
      executeForTxLayout(collection) :
      executeForGVELayout(collection);
  }

  /**
   * Executes the operator for collections based on
   * {@link org.gradoop.flink.model.impl.layouts.gve.GVELayout}
   *
   * @param collection graph collection
   * @return result graph collection
   */
  GC executeForGVELayout(GC collection);

  /**
   * Executes the operator for collections based on
   * {@link org.gradoop.flink.model.impl.layouts.transactional.TxCollectionLayout}
   *
   * @param collection graph collection
   * @return result graph collection
   */
  GC executeForTxLayout(GC collection);
}
