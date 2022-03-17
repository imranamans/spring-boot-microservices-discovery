package dev.imranshah.progressreportservice;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import dev.imranshah.progressreportservice.model.Course;
import dev.imranshah.progressreportservice.model.ProgressReport;
import dev.imranshah.progressreportservice.model.Student;

@RestController
@RequestMapping("data/v1/reports")
public class ProgressReportRestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{studentId}")
    public ProgressReport getReport(@PathVariable Long studentId) {


//        final RestTemplate restTemplate = new RestTemplate();

        final Optional<Student> student = Optional.ofNullable(restTemplate.getForObject(
            "http://student-service/data/v1/students/" + studentId,
            Student.class
        ));

//        final Optional<Student> student = Optional.ofNullable(
//            webClientBuilder.build()
//                .get()
//                .uri("http://student-service/data/v1/students/" + studentId)
//                .retrieve()
//                .bodyToMono(Student.class)
//                .block()
//        );

//        final List<Course> courses = restTemplate.getForObject("http://localhost:8082/data/v1/courses", List.class);

        ResponseEntity<List<Course>> responseEntity =
            restTemplate.exchange(
                "http://course-service/data/v1/courses",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Course>>() {
                }
            );
        List<Course> courses = responseEntity.getBody();

        final Optional<Course> studentCourse = courses
            .stream()
            .filter(course -> Objects.equals(course.getId(), student.get().getCourseId()))
            .findFirst();

        return new ProgressReport(student.get(), studentCourse.get());
    }
}
