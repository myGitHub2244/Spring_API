package co.pragra.learning.springRESTAPI.repository;

import co.pragra.learning.springRESTAPI.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByFirstName(String firstName); //Custom Search method. Hibernate will provide the implementation automatically !

    List<Student> findAllByLastName(String lastName, Pageable pageable);

}
