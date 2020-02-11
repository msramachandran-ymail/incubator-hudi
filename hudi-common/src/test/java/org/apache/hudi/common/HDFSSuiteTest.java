package org.apache.hudi.common;

import org.apache.hudi.common.table.log.HDFSSuiteTestHoodieLogFormat;
import org.apache.hudi.common.util.HDFSSuiteTestDFSPropertiesConfiguration;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({HDFSSuiteTestHoodieLogFormat.class, HDFSSuiteTestDFSPropertiesConfiguration.class})
public class HDFSSuiteTest {
}

