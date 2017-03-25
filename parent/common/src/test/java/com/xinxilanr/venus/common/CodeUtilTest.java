package com.xinxilanr.venus.common;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.core.IsEqual.equalTo;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
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

	@Test(expected = UnsupportedEncodingException.class)
	public void sha256WithUnsupportedCharsetNameShouldThrowException() throws UnsupportedEncodingException {
		CodeUtil.sha256("123321", "IAmNotSupported");
	}
	
	@Test
	public void randomStringShouldReturnAsLength() {
		String randomString = CodeUtil.randomString(8);
		assertThat(randomString.length(), equalTo(8));
	}
	
	@Test
	public void randomStringShouldReturnOnlyLetterAndNumber() {
		String checkString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String randomString = CodeUtil.randomString(8);
		for (int i = 0; i < randomString.length(); i++) {
			assertThat(randomString.charAt(i), isContainedIn(checkString));
		}
	}

	private Matcher<Character> isContainedIn(String checkString) {
		return new TypeSafeDiagnosingMatcher<Character>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("the character should in check string.");
			}

			@Override
			protected boolean matchesSafely(Character item, Description mismatchDescription) {
				mismatchDescription.appendText(" was ").appendValue(item);
				return checkString.contains(item.toString());
			}
		};
	}
}
