package dev.imranshah.progressreportservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Long id;

    private String courseCode;

    private String name;

    private Instructor instructor;
}
