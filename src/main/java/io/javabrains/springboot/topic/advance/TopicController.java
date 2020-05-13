package io.javabrains.springboot.topic.advance;

import io.javabrains.springboot.topic.basic.Topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//refer restapi-contracts.txt
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	//GET REQUEST : default request
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	//see the difference between path variable and request param
	//path variable needs a curly braces in the request
	//whereas request param doesn't need anything in the curly bracket. just ensure the parameter and argument name is same
	
	//GET REQUEST : default request
	//In order to pass a variable portion in the path 
	//1. use curly braces {anyname} in the @RequestMapping
	//2. use annotation @PathVariable in the argument to indicate that the argument is a variable in the path
	//3. Ensure path variable name and the argument name of the method should match. {pathid} in this case
	//Example: http://localhost:8090/topics/Spring
	@RequestMapping("/topics/{pathid}")
	public Topic getTopic(@PathVariable String pathid) {
		return topicService.getTopic(pathid);
	}
	
	//Example: http://localhost:8090/topicsWithRequestParam?pathId=Spring
	@RequestMapping(method=RequestMethod.GET, value="/topicsWithRequestParam" )
	public Topic getRequestParamTopic(@RequestParam String pathid) {
		return topicService.getTopic(pathid);
	}

	//use postman to run this
	//POST REQUEST : needs to be specified
	//maps the request with value topics and of type POST
	//The request payload contains the JSON representation of Topic instance and convert the JSON to this object instance
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	//use postman to run this
	//PUT REQUEST : needs to be specified
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{pathid}")
	public void addTopic(@RequestBody Topic topic,@PathVariable String pathid) {
		topicService.updateTopic(topic,pathid);
	}
	
	//use postman to run this
	//DELETE REQUEST : needs to be specified
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{pathid}")
	public void deleteTopic(@PathVariable String pathid) {
		topicService.deleteTopic(pathid);
	}
}