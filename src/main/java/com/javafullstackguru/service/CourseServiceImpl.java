package com.javafullstackguru.service;

import com.javafullstackguru.entity.Course;
import com.javafullstackguru.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepo;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }
    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }
    @Override
    public Optional<Course> getCourseById(Integer id) {
        return courseRepo.findById(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }
    @Override
    public Course updateCourse(Integer id, Course course) {
        Optional<Course> existingCourseOptional = courseRepo.findById(course.getId());
        if (existingCourseOptional.isPresent()) {
            return courseRepo.save(course);
        } else {
            return null;
        }
    }
    @Override
    public void deleteById(Integer id) {
        courseRepo.deleteById(id);
    }
}
