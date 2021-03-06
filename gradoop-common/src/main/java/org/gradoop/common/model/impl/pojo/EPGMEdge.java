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
package org.gradoop.common.model.impl.pojo;

import org.gradoop.common.model.api.entities.Edge;
import org.gradoop.common.model.impl.id.GradoopId;
import org.gradoop.common.model.impl.id.GradoopIdSet;
import org.gradoop.common.model.impl.properties.Properties;

/**
 * POJO Implementation of an EPGM edge.
 */
public class EPGMEdge extends EPGMGraphElement implements Edge {

  /**
   * Vertex identifier of the source vertex.
   */
  private GradoopId sourceId;

  /**
   * Vertex identifier of the target vertex.
   */
  private GradoopId targetId;

  /**
   * Default constructor is necessary to apply to POJO rules.
   */
  public EPGMEdge() {
  }

  /**
   * Creates an edge instance based on the given parameters.
   *
   * @param id          edge identifier
   * @param label       edge label
   * @param sourceId    source vertex id
   * @param targetId    target vertex id
   * @param properties  edge properties
   * @param graphIds    graphs that edge is contained in
   */
  public EPGMEdge(final GradoopId id, final String label, final GradoopId sourceId,
    final GradoopId targetId, final Properties properties,
    GradoopIdSet graphIds) {
    super(id, label, properties, graphIds);
    this.sourceId = sourceId;
    this.targetId = targetId;
  }

  @Override
  public GradoopId getSourceId() {
    return sourceId;
  }

  @Override
  public void setSourceId(GradoopId sourceId) {
    this.sourceId = sourceId;
  }

  @Override
  public GradoopId getTargetId() {
    return targetId;
  }

  @Override
  public void setTargetId(GradoopId targetId) {
    this.targetId = targetId;
  }

  @Override
  public String toString() {
    return String.format("(%s)-[%s]->(%s)",
      sourceId, super.toString(), targetId);
  }
}
