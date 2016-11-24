/**
 * 
 */
package org.rest.api.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.rest.api.messenger.model.Message;
import org.rest.api.messenger.model.Profile;

/**
 * @author sharm073
 *
 */
public class DatabaseClass {

	public static Map<Long, Message> messages = new HashMap<>();
	
	public static Map<Long, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	} 

	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}
}
