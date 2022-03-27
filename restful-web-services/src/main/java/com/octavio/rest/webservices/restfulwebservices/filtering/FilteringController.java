package com.octavio.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		
		List <SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),new SomeBean("value12", "value22", "value32"));
		SomeBean someBean = new SomeBean("value1","value2","value3");
		/*
		 * LEt's say, field3 is private, should not be returned in request.
		 * That is why, I included @JsonIgnoreProperties(value={"field3"}) 
		 * in the declaration of the class so that field3 is
		 * ignored in the request response
		 * */
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		/*
		 * For dynamic filtering, in each method we choose which fields to send here
		 */
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		
		mapping.setFilters(filters);
		//returning mapping
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBean> list =  Arrays.asList(new SomeBean("value1", "value2", "value3"),new SomeBean("value12", "value22", "value32"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		/*
		 * For dynamic filtering, in each method we choose which fields to send here
		 */
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		
		mapping.setFilters(filters);
		//returning mapping
		return mapping;
	}
	

}
