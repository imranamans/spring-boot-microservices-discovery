package dev.imranshah.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    private Long id;

    private String name;

    private Parent parent;

    private Long courseId;
}
