package com.xinxilanr.venus.common;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodeUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sha256ShouldReturnSha256CodeInLowercase() {
		String sha256 = CodeUtil.sha256("123321");
		assertThat(sha256, equalTo("a320480f534776bddb5cdb54b1e93d210a3c7d199e80a23c1b2178497b184c76"));
	}

}
