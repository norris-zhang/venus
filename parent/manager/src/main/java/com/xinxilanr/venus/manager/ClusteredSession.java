/**
 * 
 */
package com.xinxilanr.venus.manager;

import java.util.Map;

/**
 * @author norris
 *
 */
public interface ClusteredSession {
	void setSession(String sessionId, Map<String, Object> session);
	Map<String, Object> getSession(String sessionId);
}
