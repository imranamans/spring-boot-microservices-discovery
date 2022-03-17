package dev.imranshah.progressreportservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProgressReport {

    private Student student;
    private Course course;
}
