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

package org.apache.hudi.utilities.sources;

import org.apache.hadoop.fs.Path;
import org.apache.hudi.common.model.HoodieRecord;
import org.apache.hudi.common.util.TypedProperties;
import org.apache.hudi.utilities.UtilitiesTestBase;
import org.junit.Before;

import java.io.IOException;
import java.util.List;

/**
 * Basic tests for {@link JsonDFSSource}.
 */
public class TestJsonDFSSource extends AbstractDFSSourceTestBase {

  @Before
  public void beforeTest() throws Exception {
    this.dfsRoot = dfsBasePath + "/jsonFiles";
    this.fileSuffix = ".json";
  }

  @Override
  Source prepareDFSSource() {
    TypedProperties props = new TypedProperties();
    props.setProperty("hoodie.deltastreamer.source.dfs.root", dfsRoot);
    return new JsonDFSSource(props, jsc, sparkSession, schemaProvider);
  }

  @Override
  void writeNewDataToFile(List<HoodieRecord> records, Path path) throws IOException {
    UtilitiesTestBase.Helpers.saveStringsToDFS(
        Helpers.jsonifyRecords(records), dfs, path.toString());
  }
}
