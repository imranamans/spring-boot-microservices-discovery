package dev.imranshah.courseservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.imranshah.courseservice.model.Course;
import dev.imranshah.courseservice.model.Instructor;

@RestController
@RequestMapping("data/v1/courses")
public class CourseRestController {

    private final List<Course> courseList = Arrays.asList(new Course(1L, "tt", "Table Tennis", new Instructor(1L, "Mustafa Ali Khan")));

    @GetMapping
    public List<Course> findAll() {
        return courseList;
    }
}
