/**
 * 
 */
package org.rest.api.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rest.api.messenger.database.DatabaseClass;
import org.rest.api.messenger.model.Message;

/**
 * @author sharm073
 *
 */
public class MessageService {
	
	Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Good Morning", "Vivek"));
		messages.put(2L, new Message(2L, "Good Evening", "Vinayak"));
		messages.put(3L, new Message(3L, "Good Noon", "Manish"));
		messages.put(4L, new Message(4L, "Hello", "Deeplika"));  
		messages.put(5L, new Message(5L, "Hey, what's ups", "Manali"));
	}

	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(long id){
		return messages.remove(id);
	}
}
