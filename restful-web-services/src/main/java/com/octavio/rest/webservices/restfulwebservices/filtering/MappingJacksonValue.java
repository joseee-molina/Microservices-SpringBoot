package com.octavio.rest.webservices.restfulwebservices.filtering;

import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;

public class MappingJacksonValue {
	

	List<SomeBean> someBean;
	public MappingJacksonValue(List<SomeBean> list) {
		// TODO Auto-generated constructor stub
		this.someBean=list;
	}
	public void setFilters(FilterProvider filters) {
		// TODO Auto-generated method stub
		
	}
	
	

}
