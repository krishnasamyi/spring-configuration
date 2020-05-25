package org.ponkarthika.springconfigurationservice.controller;

import java.util.List;
import java.util.Map;

import org.ponkarthika.springconfigurationservice.configuration.ServerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/configuration")
public class ConfigurationCheckingController {
	
	@Value("${greetings.name}")
	private String greetingName;
	
	@Value("${greetings.names}")
	private List<String> names;
	
	@Value("#{${greetings.map}}")
	private Map<String, String> greetingsMap;
	
	@Autowired
	private ServerConfiguration serverConfiguration;

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello " + greetingName;
	}
	
	@RequestMapping(value="/helloAll", method = RequestMethod.GET)
	public String helloAll() {
		return "Hello " + names;
	}
	
	@RequestMapping(value="/helloMap", method = RequestMethod.GET)
	public String helloMap() {
		return "Hello " + greetingsMap;
	}
	
	@RequestMapping(value="/server", method = RequestMethod.GET)
	public String helloServer() {
		return "Hello " + serverConfiguration;
	}
}
