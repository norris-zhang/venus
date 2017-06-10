/**
 * 
 */
package com.xinxilanr.venus.common;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author norris
 *
 */
public class FileUtilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.xinxilanr.venus.common.FileUtil#getExtensionFromFileName(java.lang.String)}.
	 */
	@Test
	public void testGetExtensionFromFileName() {
		String fileExt = FileUtil.getExtensionFromFileName("abc.png");
		assertThat(fileExt, equalTo("png"));
		fileExt = FileUtil.getExtensionFromFileName("abcde.bak.jpg");
		assertThat(fileExt, equalTo("jpg"));
		fileExt = FileUtil.getExtensionFromFileName("abcc");
		assertThat(fileExt, is(nullValue()));
	}

}
