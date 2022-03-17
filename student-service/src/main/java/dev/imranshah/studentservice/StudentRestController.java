package dev.imranshah.studentservice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import dev.imranshah.studentservice.model.Parent;
import dev.imranshah.studentservice.model.Student;

@RestController
@RequestMapping("data/v1/students")
public class StudentRestController {

    @Value("${spring.application.name}")
    private String appName;

    @Lazy
    private final EurekaClient eurekaClient;

    public StudentRestController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    private final List<Student> studentList = Arrays.asList(
        new Student(1L, "Safwan Shah", new Parent(1L, "Imran Shah"), 1L),
        new Student(2L, "Mariam Shah", new Parent(1L, "Imran Shah"), 1L)
    );

    @GetMapping
    public List<Student> findAll() {
        return studentList;
    }

    @GetMapping("{studentId}")
    public Optional<Student> findById(@PathVariable Long studentId) {
        return studentList.stream()
            .filter(student -> Objects.equals(student.getId(), studentId))
            .findFirst();
    }

}
