package co.pragra.learning.springRESTAPI.service;

import co.pragra.learning.springRESTAPI.entities.Student;
import co.pragra.learning.springRESTAPI.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public Optional<Student> getStudentByFirstName(String firstName) {
        return studentRepo.findStudentByFirstName(firstName);
    }

    public List<Student> getStudentsByLastName(String lastName,int pageNumber, int pageSize) {
        return studentRepo.findAllByLastName(lastName, PageRequest.of(pageNumber,pageSize));
    }


}
