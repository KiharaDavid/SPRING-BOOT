package com.example.demo.david.com.courses;

import com.example.demo.david.com.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseservice;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseservice.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{Id}")
    public Course getCourse(@PathVariable String id) {
        return courseservice.getCourse(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseservice.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{Id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String Id, @PathVariable String id) {
        course.setTopic(new Topic(id, "", ""));
        courseservice.updateCourse(id,course);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{Id}")
    public void deleteTopic(@PathVariable String id) {
        courseservice.deleteCourse(id);
    }
}

