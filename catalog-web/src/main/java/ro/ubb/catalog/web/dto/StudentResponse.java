package ro.ubb.catalog.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentResponse {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<StudentDto> students;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    public void setStudents(Set<StudentDto> students) {
        this.students = students;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Set<StudentDto> getStudents() {
        return students;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
