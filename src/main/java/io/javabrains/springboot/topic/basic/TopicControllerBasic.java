package io.javabrains.springboot.topic.basic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Returns the object from the controller

@RestController
public class TopicControllerBasic {

	@RequestMapping("/gettopicsbasic")
	public List<Topic> getAllTopics() {
		return Arrays.asList(
				new Topic("Spring", "Spring framework", "Spring framework description"),
				new Topic("Java", "Core Java", "Java description"),
				new Topic("JavaScript", "JavaScript", "JavaScript description")
				);
	}
}
	
/*
 http://localhost:8083/topics
  (default port overrided in application.properties)
 The generated JSON has key names corresponding to property names of the Topic class.
 The JSON values are the values of those properties.  
 
*/


/*

 How Spring MVC works:
 
User -> request (GET or POST) -> Spring MVC application

For example: http://localhost:8080/topics

Spring MVC application has a controller

A controller is a java class which has URI, HTTP method which has functionality
When a user request comes in, 
Spring MVC will look at the URI mentioned in the bunch of controllers which are in the class path and the HTTP method.
If any of the controller have the URI and HTTP method that maps the request that comes in.
If there is a match Spring MVC executes the method and converts it to a proper response and sends it back.

*/
 