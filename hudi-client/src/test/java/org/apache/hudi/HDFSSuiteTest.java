package org.apache.hudi;

import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.apache.hudi.common.minicluster.HdfsTestService;
import org.apache.hudi.io.HDFSSuiteTestHoodieCommitArchiveLog;
import org.apache.hudi.table.HDFSSuiteTestMergeOnReadTable;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.io.IOException;

@RunWith(Suite.class)
@SuiteClasses({HDFSSuiteTestMultiFS.class, HDFSSuiteTestMergeOnReadTable.class, HDFSSuiteTestHoodieCommitArchiveLog.class})
public class HDFSSuiteTest {
  protected static HdfsTestService hdfsTestService;
  protected static MiniDFSCluster dfsCluster;

  @BeforeClass
  public static void setUp() throws IOException {
    hdfsTestService = new HdfsTestService();
    dfsCluster = hdfsTestService.start(true);
  }

  @AfterClass
  public static void tearDown() throws IOException {
    if (hdfsTestService != null) {
      hdfsTestService.stop();
      dfsCluster.shutdown();
    }
  }
}
