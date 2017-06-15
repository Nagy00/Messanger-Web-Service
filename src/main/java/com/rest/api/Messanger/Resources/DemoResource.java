package com.rest.api.Messanger.Resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/demo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class DemoResource {

	@GET
	@Path("annotations1")
	public String demo(@MatrixParam("param") String matrixParam
					   ,@HeaderParam("header") String header){
		return "matrix param is " + matrixParam + "header param is " + header;
	}
	
	@GET
	@Path("annotations2")
	public String getParamsUsingCntext(@Context UriInfo uri) {
		return uri.getAbsolutePath().toString();
	}
}
