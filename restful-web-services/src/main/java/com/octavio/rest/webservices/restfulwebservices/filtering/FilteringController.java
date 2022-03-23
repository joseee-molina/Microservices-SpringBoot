package com.octavio.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		/*
		 * LEt's say, field3 is private, should not be returned in request.
		 * That is why, I included @JsonIgnoreProperties(value={"field3"}) 
		 * in the declaration of the class so that field3 is
		 * ignored in the request response
		 * */
		
		
		
		return someBean;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"),new SomeBean("value12", "value22", "value32"));
		/*
		 * Returns the list of beans, all of them don0t contain field3
		 * Like this:
		 * [
    {
        "field1": "value1",
        "field2": "value2"
    },
    {
        "field1": "value12",
        "field2": "value22"
    }
]
		 * */
	}
	

}
