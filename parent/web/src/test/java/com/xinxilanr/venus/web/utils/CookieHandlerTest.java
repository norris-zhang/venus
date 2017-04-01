/**
 * 
 */
package com.xinxilanr.venus.web.utils;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.xinxilanr.venus.common.CodeUtil;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

/**
 * @author norris
 *
 */
@RunWith(JMockit.class)
public class CookieHandlerTest {

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
	 * Test method for {@link com.xinxilanr.venus.web.utils.CookieHandler#getClusteredSessionId()}.
	 */
	@Test
	public void getClusteredSessionIdShouldReturnANewIdForTheFirstTime(@Mocked final HttpServletRequest request,
																	   @Mocked final HttpServletResponse response,
																	   @Mocked CodeUtil codeUtil) {
		new Expectations() {{
			request.getCookies(); result = new Cookie[0];
			CodeUtil.generateToken(); result = "newGeneratedToken";
		}};
		CookieHandler cookieHandler = new CookieHandler(request, response);
		String sessionId = cookieHandler.getClusteredSessionId();
		assertThat(sessionId, equalTo("newGeneratedToken"));
		new Verifications() {{response.addCookie(withAny(new Cookie("cookiename", "cookievalue")));}};
	}

	@Test
	public void getClusteredSessionIdShouldReturnFromCookieFromTheSecondTime(@Mocked HttpServletRequest request,
																			 @Mocked HttpServletResponse response) {
		new Expectations() {{
			request.getCookies(); result = new Cookie[]{new Cookie("jsessiontoken", "tokenvalue")};
		}};
		CookieHandler cookieHandler = new CookieHandler(request, response);
		String sessionId = cookieHandler.getClusteredSessionId();
		assertThat(sessionId, equalTo("tokenvalue"));
	}

	/**
	 * Test method for {@link com.xinxilanr.venus.web.utils.CookieHandler#getCookie(java.lang.String)}.
	 */
	@Test
	public void getCookieShouldReturnTheCookieWithProvidedNameInRequest(@Mocked final HttpServletRequest request,
																		@Mocked final HttpServletResponse response) {
		CookieHandler cookieHandler = new CookieHandler(request, response);
		new Expectations() {{
			request.getCookies(); result = new Cookie[]{new Cookie("cookiename", "cookievalue")};
		}};
		String cookieValue = cookieHandler.getCookie("cookiename").get();
		assertThat(cookieValue, equalTo("cookievalue"));
	}

	/**
	 * Test method for
	 * {@link com.xinxilanr.venus.web.utils.CookieHandler#setCookie(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void setCookieShouldInvokeResponseAddCookie(@Mocked final HttpServletResponse response) {
		CookieHandler cookieHandler = new CookieHandler(null, response);
		cookieHandler.setCookie("cookieName", "cookieValue");
		new Verifications() {{response.addCookie(withAny(new Cookie("user", "Norris")));}};
	}

}
