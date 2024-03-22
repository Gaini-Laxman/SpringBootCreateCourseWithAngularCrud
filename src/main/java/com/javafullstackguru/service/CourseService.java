package com.javafullstackguru.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.javafullstackguru.entity.Course;
@Service
public interface CourseService{
    List<Course> getAllCourse();
    Optional<Course> getCourseById(Integer id);
    Course saveCourse(Course course);
    Course updateCourse(Integer id, Course course);
    void deleteById(Integer id);



}
