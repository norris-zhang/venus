/**
 * 
 */
package com.xinxilanr.venus.manager.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.xinxilanr.venus.manager.ClusteredSession;

/**
 * @author norris
 *
 */
@Component
public class ClusteredSessionMemoryImpl implements ClusteredSession {
	private int cacheCapacity;
	private int expiryMinutes;
	private Map<String, SessionObject> sessionMap;
	
	public ClusteredSessionMemoryImpl(@Value("${session.cache.capacity}") int cacheCapacity,
									  @Value("${session.expiry}") int expiryMinutes) {
		this.cacheCapacity = cacheCapacity;
		this.expiryMinutes = expiryMinutes;
		sessionMap = new HashMap<>((int)(cacheCapacity / 0.75 + 1));
	}
	/* (non-Javadoc)
	 * @see com.xinxilanr.venus.manager.ClusteredSession#setSession(java.lang.String, java.util.Map)
	 */
	@Override
	public void setSession(String sessionId, Map<String, Object> session) {
		sessionMap.put(sessionId, new SessionObject(expiryMinutes, session, Instant.now()));
		if (sessionMap.size() >= cacheCapacity) {
			clearExpired();
		}
	}

	/* (non-Javadoc)
	 * @see com.xinxilanr.venus.manager.ClusteredSession#getSession(java.lang.String)
	 */
	@Override
	public Map<String, Object> getSession(String sessionId) {
		Map<String, Object> session = Optional.ofNullable(sessionMap.get(sessionId))
											  .orElse(new SessionObject(expiryMinutes))
											  .getSession();
		return session;
	}

	private void clearExpired() {
		Set<Entry<String, SessionObject>> entrySet = sessionMap.entrySet();
		
		for (Iterator<Entry<String, SessionObject>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<String, SessionObject> next = iterator.next();
			if (next.getValue().isExpired()) {
				iterator.remove();
			}
		}
	}

	public void setExpired(String sessionId) {
		Optional.ofNullable(sessionMap.get(sessionId)).ifPresent(so -> so.setExpired());
	}

	public int size() {
		return sessionMap.size();
	}

	private static class SessionObject {
		private int expiryMinutes;
		private Instant createdAt;
		private Map<String, Object> session;
		public SessionObject(int expiryMinutes) {
			this.expiryMinutes = expiryMinutes;
			this.createdAt = Instant.now();
			this.session = new HashMap<>();
		}
		public void setExpired() {
			this.createdAt = Instant.now().minus(expiryMinutes + 1, ChronoUnit.MINUTES);
		}
		public SessionObject(int expiryMinutes, Map<String, Object> session, Instant createdAt) {
			this.expiryMinutes = expiryMinutes;
			this.createdAt = createdAt;
			this.session = session;
		}
		public Map<String, Object> getSession() {
			if (isExpired()) {
				return new HashMap<>();
			}
			return this.session;
		}

		public boolean isExpired() {
			return Instant.now().minus(expiryMinutes, ChronoUnit.MINUTES).isAfter(createdAt);
		}
	}
}
