/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
