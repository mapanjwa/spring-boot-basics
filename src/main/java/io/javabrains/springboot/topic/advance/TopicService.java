package io.javabrains.springboot.topic.advance;

import io.javabrains.springboot.topic.basic.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

//In Spring Business services are singleton - controllers inject dependencies to get the service
@Service
public class TopicService {

	private List<Topic> topics = 
		new ArrayList<>(Arrays.asList(
				new Topic("Spring", "Spring framework", "Spring framework description"),
				new Topic("Java", "Core Java", "Java description"),
				new Topic("JavaScript", "JavaScript", "JavaScript description")
		));
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(topic -> topic.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String pathid) {
		Collections.replaceAll(topics, 
				topics.stream().filter(t -> t.getId().equalsIgnoreCase(pathid)).findFirst().get(),
				topic);
	}

	public void deleteTopic(String pathid) {
		topics.removeIf(t -> t.getId().equalsIgnoreCase(pathid));
		
	}
	
}
