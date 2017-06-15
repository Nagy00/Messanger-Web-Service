package com.rest.api.Messanger.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.rest.api.Messanger.Model.ErrorMessage;

//@Provider // Register this class to be avaliable  to jax-rs
public class ExceptionMapperHandler implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage error = new ErrorMessage(ex.getMessage(),500,"www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(error).build();
	}

}
