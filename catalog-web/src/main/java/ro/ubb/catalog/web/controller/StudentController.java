package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.core.service.StudentService;
import ro.ubb.catalog.web.converter.StudentConverter;
import ro.ubb.catalog.web.dto.StudentDto;
import ro.ubb.catalog.web.dto.StudentResponse;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentConverter studentConverter;


    @GetMapping()
    ResponseEntity<StudentResponse> getStudents() {
        List<Student> students = studentService.readAll();
        Set<StudentDto> dtoSet = studentConverter.convertModelsToDtos(students);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudents(dtoSet);

        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<StudentResponse> deleteStudentById(@PathVariable Long id) {
        try {
            Student deletedStudent = studentService.delete(id);
            StudentDto deletedDto = studentConverter.convertModelToDto(deletedStudent);

            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setStudents(Set.of(deletedDto));

            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        } catch (RuntimeException e) {
            StudentResponse studentResponse = new StudentResponse();

            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }
    }
}
