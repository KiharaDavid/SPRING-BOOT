package com.example.demo.david.com.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private com.example.demo.david.com.courses.CourseRepository CourseRepository;


    public List<Course> getAllCourses(String topicId) {
        List<Course> Courses = new ArrayList<>();
        CourseRepository.findByTopicId(topicId).
                forEach(Courses::add);
        return Courses;
    }

    public Course getCourse(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return CourseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        this.CourseRepository.save(course);
    }


    public void updateCourse(String id, Course course) {
        // for(int i =0;i<topics.size();i++){
        //  Topic t=topics.get(i);
        // if(t.getId().equals(id)){
        //  topics.set(i,topic);
        //  return;
        CourseRepository.save(course);
    }


    public void deleteCourse(String id) {
        CourseRepository.deleteById(id);

    }
}
