package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student);

    Student readOne(Long id);

    List<Student> readAll();

    Student update(Long id, Student stundent);

    Student delete(Long id);

}
