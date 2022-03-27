package com.octavio.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 personV1() {
		return new PersonV1("Tavin Molina");
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 personV2() {
		
		return new PersonV2(new Name("Tavin","Molina"));
	}
	
	
	
	//The above worked out fine, but not very complex for enterprise solutions
	//ADD params in URI
	
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Tavin Molina");
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Tavin","Molina"));
	}
	
	//Note: To call this, don't include the X-API-VERSION 2 in the params of the call, instead in the headers section (e.g. headers in postman)
	
	//Moving on to produces
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Tavin Molina");
	}
	
	
	@GetMapping(value="/person/produces",  produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Tavino","Molina"));
	}	
	//the above is also called mine type versioning
	//Same as headers, add the Accept key and the produces value in the header
	
	/*
	 * Note: the headers cannot be added using the browser without advanced knowledge
	 * in the postman is easy
	 * However, think about your users!
	 * 
	 */
}
