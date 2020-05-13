package io.javabrains.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//find a way to tell spring, this is a spring boot application. Use below annotation
@SpringBootApplication
public class CourseApiApp {

	//Create a java class with public static void main() method
	public static void main(String[] args) {
	
		//In order to create and start the servlet container and host this application to run on a servlet container, 
		//call below static method run() in a main method
		
		SpringApplication.run(CourseApiApp.class,args);
	}
}


/*
Run java application
Check console, you will find 2 things at the end
•	Tomcat started at localhost 8080
•	CourseApp application started in 2.523 seconds

Open browser-> localhost:8080

Meaning Tomcat servlet container has started and web application is running using spring boot static method run()

•	Things happened in background with ***SpringApplication.run(CourseApp.class, args);***

1.	Sets up default configuration
2.	Starts Spring application context
a.	Creates  the container i.e. applicationContext.xml file
3.	Performs class path scan
a.	Look for annotations in classes. Example: @Service treated as service, @Controller treated as controller
4.	Starts Tomcat server

if you want to change the server port

change it to server.port=8083 in application.properties

*/