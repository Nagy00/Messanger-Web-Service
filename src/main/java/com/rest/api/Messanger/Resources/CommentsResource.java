package com.rest.api.Messanger.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentsResource {

	@GET
	public String test(){
		return "new Sub Resource";
	}
}
