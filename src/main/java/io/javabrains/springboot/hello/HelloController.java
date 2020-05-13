package io.javabrains.springboot.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 •	Adding a Rest Controller
		A java Class
		Marked with annotations
		Has information about:
			1. What URL access triggers it?
			2.What method to run when accessed?

https://javarevisited.blogspot.com/2017/08/difference-between-restcontroller-and-controller-annotations-spring-mvc-rest.html
*/

/*

 Below annotation indicates, 
 the methods inside the class will be executed when makes a request to a URL.
  You need to provide annotation @RequestMapping ("/****") maps only to GET method by default
*/

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello () {
		return "Hello";
	}

/*
 NOTE:
	This class is already in a class-path, which spring boot is already scanning. 
	Spring boot will find the special annotation and call the method accordingly 
	when the request with URL mentioned above is passes
 
 */
}
