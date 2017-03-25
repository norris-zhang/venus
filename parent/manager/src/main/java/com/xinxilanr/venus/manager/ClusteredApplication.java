/**
 * 
 */
package com.xinxilanr.venus.manager;

import java.util.Map;

/**
 * @author norris
 *
 */
public interface ClusteredApplication {
	void setApplication(String applicationId, Map<String, Object> application);
	Map<String, Object> getApplication(String applicationId);
}
