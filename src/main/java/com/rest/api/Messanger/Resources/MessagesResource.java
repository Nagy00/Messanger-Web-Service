package com.rest.api.Messanger.Resources;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rest.api.Messanger.BeanParamsFilter;
import com.rest.api.Messanger.Model.ErrorMessage;
import com.rest.api.Messanger.Model.Message;
import com.rest.api.Messanger.Services.MessageService;

@Path("/messages")
@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"admin","admin1"})
public class MessagesResource {

	MessageService service = new MessageService();

	//get all messages
	@GET
	@RolesAllowed("admin")
	public List<Message> getMessage(@BeanParam BeanParamsFilter beanParam) { // default value form query param is zero
		if(beanParam.getYear() > 0){
			return service.getAllMessagesFromYear(beanParam.getYear());
		}
		return service.getAllMessages();
	}

	//get message by id
	@GET
	@Path("/{messageId}") // {} donates that is apart from the url
	public Message test(@PathParam("messageId") int messageId) {
		// jersey do the conversion from string from url to int for the param.
		Message message =  service.getMessage(messageId);
		ErrorMessage error = new ErrorMessage("Not Found",500,"www.google.com");
		Response response =  Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(error).build();
		if(message == null){
			throw new WebApplicationException(response);
		}
		return message;
	}

	//add message
	@POST
	public Message addMessage(Message message) {
		return service.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") int messageId, Message message) {
		System.out.println(messageId);
		message.setId(messageId);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void removeMessage(@PathParam ("messageId") int id){
		service.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentsResource getCommentResource(){
		return new CommentsResource();
	}
}
