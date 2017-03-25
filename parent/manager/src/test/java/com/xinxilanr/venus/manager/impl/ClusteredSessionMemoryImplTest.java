package com.xinxilanr.venus.manager.impl;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClusteredSessionMemoryImplTest {
	private ClusteredSessionMemoryImpl sessionRepo;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.sessionRepo = new ClusteredSessionMemoryImpl(2, 30);
	}

	@After
	public void tearDown() throws Exception {
		this.sessionRepo = null;
	}

	@Test
	public void setASessionMapThenGetSessionShouldGetTheMapWithContent() {
		Map<String, Object> session = new HashMap<>();
		session.put("userId", 1);
		this.sessionRepo.setSession("sessionId", session);
		Integer userId = (Integer)this.sessionRepo.getSession("sessionId").get("userId");
		assertThat(userId, equalTo(1));
	}
	
	@Test
	public void getSessionWithNewSessionIdShouldGetEmptyMap() {
		Map<String, Object> session = this.sessionRepo.getSession("aNewSessionId");
		assertThat(session, is(notNullValue()));
		assertThat(session.size(), equalTo(0));
	}

	@Test
	public void setSessionTriggersClearExpired() {
		Map<String, Object> session1 = new HashMap<>();
		session1.put("1", 1);
		sessionRepo.setSession("s1", session1);
		
		assertThat(sessionRepo.size(), equalTo(1));
		sessionRepo.setExpired("s1");
		assertThat(sessionRepo.size(), equalTo(1));
		assertThat(sessionRepo.getSession("s1").get("1"), is(nullValue()));
		
		Map<String, Object> session2 = new HashMap<>();
		session2.put("2", 2);
		sessionRepo.setSession("s2", session2);
		
		assertThat(sessionRepo.size(), equalTo(1));
		assertThat(sessionRepo.getSession("s1").get("1"), is(nullValue()));
	}

}
