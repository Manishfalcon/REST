/**
 * 
 */
package org.rest.api.messenger;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rest.api.messenger.model.Message;
import org.rest.api.messenger.service.MessageService;

/**
 * @author sharm073
 *
 */
@Path ("messages")
public class MessageResource {
	
	private MessageService service = new MessageService();
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return service.getAllMessages();
	}
	
	@GET
	@Path("{messageId}")
	@Produces (MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") final long messageId){
		return service.getMessage(messageId);
	}

}
