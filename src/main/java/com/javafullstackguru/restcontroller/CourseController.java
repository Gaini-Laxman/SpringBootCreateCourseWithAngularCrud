// CourseController.java

package com.javafullstackguru.restcontroller;

import com.javafullstackguru.entity.Course;
import com.javafullstackguru.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourse();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        try {
            Course updatedCourse = courseService.updateCourse(id, course);
            if (updatedCourse != null) {
                return ResponseEntity.ok(updatedCourse); // Return 200 if the course is updated successfully
            } else {
                return ResponseEntity.notFound().build(); // Return 404 if the course with the given ID is not found
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // Return 400 for any other exception
        }
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteById(id);
    }
}
