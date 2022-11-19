package com.example.demo.david.com.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicservice;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicservice.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicservice.getTopic(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicservice.addTopic(topic);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
        topicservice.updateTopic(id, topic);

    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics")
    public void deleteTopic(@PathVariable String id) {
        topicservice.deleteTopic(id);
    }
        }