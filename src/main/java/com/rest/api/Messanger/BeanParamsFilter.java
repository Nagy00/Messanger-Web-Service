package com.rest.api.Messanger;

import javax.ws.rs.QueryParam;

public class BeanParamsFilter {

	private @QueryParam("year") int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
