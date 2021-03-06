/**
 * 
 */
package org.rest.api.messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.rest.api.messenger.model.Message;
import org.rest.api.messenger.service.MessageService;

/**
 * @author sharm073
 *
 */
@Path ("messages")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public class MessageResource {
	
	private MessageService service = new MessageService();
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size){
		if(year > 0){
			return service.getAllMessagesForYear(year);
		}
		if(start >=0 && size >0){
			return service.getAllMessagesPaginated(start, size);
		}
		return service.getAllMessages();
	}
	
	@GET
	@Path("{messageId}")
	public Message getMessage(@PathParam("messageId") final long messageId){
		return service.getMessage(messageId);
	}

	@POST
	public Message addMessage(final Message message){
		return service.addMessage(message); 
	}
	
	@PUT
	@Path("{messageId}")
	public Message updateMessage(@PathParam("messageId") final long messageId, final Message message){
		message.setId(messageId);
		return service.updateMessage(message); 
	}
	
	@DELETE
	@Path("{messageId}")
	public void deleteMessage(@PathParam("messageId") final long id){
		service.deleteMessage(id);
	}
	
}