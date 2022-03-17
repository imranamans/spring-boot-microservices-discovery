package dev.imranshah.courseservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Course {

    private Long id;

    private String courseCode;

    private String name;

    private Instructor instructor;
}
