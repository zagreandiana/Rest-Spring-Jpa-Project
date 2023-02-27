package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.web.dto.StudentDto;


@Component
public class StudentConverter extends BaseConverter<Student, StudentDto> {

    @Override
    public Student convertDtoToModel(StudentDto dto) {
        Student student =  new Student();
                student.setFirstName(dto.getFirstName());
                student.setLastName(dto.getLastName());
                student.setGrade(dto.getGrade());
                student.setID(dto.getId());

        return student;
    }

    @Override
    public StudentDto convertModelToDto(Student student) {
        StudentDto dto = new StudentDto();
                dto.setFirstName(student.getFirstName());
                dto.setLastName(student.getLastName());
                dto.setGrade(student.getGrade());
                dto.setId(student.getId());

        return dto;
    }
}
