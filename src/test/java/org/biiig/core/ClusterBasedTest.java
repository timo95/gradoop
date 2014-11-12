package org.biiig.core;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseTestingUtility;
import org.biiig.core.storage.GraphStore;
import org.biiig.core.storage.hbase.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created by martin on 12.11.14.
 */
public abstract class ClusterBasedTest extends BIIIGTest {

  protected static HBaseTestingUtility utility;

  protected GraphStore createEmptyGraphStore() {
    Configuration config = utility.getConfiguration();
    VertexHandler verticesHandler = new InOutEdgesGraphsVertexHandler();
    GraphHandler graphsHandler = new BasicGraphHandler();

    HBaseGraphStoreFactory.deleteGraphStore(config);
    return HBaseGraphStoreFactory.createGraphStore(config, verticesHandler, graphsHandler);
  }

  protected GraphStore openBasicGraphStore() {
    Configuration config = utility.getConfiguration();
    VertexHandler verticesHandler = new InOutEdgesGraphsVertexHandler();
    GraphHandler graphsHandler = new BasicGraphHandler();
    return HBaseGraphStoreFactory.createGraphStore(config, verticesHandler, graphsHandler);
  }

  @BeforeClass
  public static void setup() throws Exception {
    utility = new HBaseTestingUtility();
    utility.startMiniCluster();
  }

  @AfterClass
  public static void tearDown() throws Exception {
    utility.shutdownMiniCluster();
  }
}
