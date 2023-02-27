package ro.ubb.catalog.core.service;

import lombok.extern.slf4j.Slf4j;
import ro.ubb.catalog.core.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements  StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
//        log.debug("### Entering create student method");
        Student savedStudent = studentRepository.save(student);
//        log.debug("### Exiting create student method");

        return savedStudent;
    }

    @Override
    public Student readOne(Long id) {

//        log.debug("### Entering read student method");
        Optional<Student> optional = studentRepository.findById(id);

        if(optional.isEmpty()) {
            throw new RuntimeException();
        }

        Student student = optional.get();
//        log.debug("### Exiting read student method");
        return student;
    }

    @Override
    public List<Student> readAll() {
//        log.debug("### Entering read students method");
        List<Student> students = studentRepository.findAll();
//        log.debug("### Exiting read students method");

        return students;
    }

    @Override
    @Transactional
    public Student update(Long id, Student student) {
//        log.debug("### Entering update student method");

        Optional<Student> optional = studentRepository.findById(id);

        Student studentToBeUpdated = optional.orElseThrow();

        studentToBeUpdated.setFirstName(student.getFirstName());
        studentToBeUpdated.setLastName(student.getLastName());
        studentToBeUpdated.setGrade(student.getGrade());


//        log.debug("### Exiting update artist method.");
        return studentToBeUpdated;
    }

    @Override
    public Student delete(Long id) {
//        log.debug("### Entering delete student method.");
        Optional<Student> optional = studentRepository.findById(id);

        Student studentToBeDeleted = optional.orElseThrow();

        studentRepository.deleteById(studentToBeDeleted.getId());
//        log.debug("### Exiting delete student method.");

        return studentToBeDeleted;
    }
}
