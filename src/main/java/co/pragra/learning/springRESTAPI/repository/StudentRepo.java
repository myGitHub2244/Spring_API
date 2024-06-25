package co.pragra.learning.springRESTAPI.repository;

import co.pragra.learning.springRESTAPI.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    //HERE WE LIST METHODS THAT MAY NOT HAVE BEEN AUTOMATICALLY AVAILABLE TO USE IN STUDENTSERVICE.
    // ONCE WE LIST IT HERE JPA-HIBERNATE WILL AUTOMATICALLY PROVIDE THE IMPLEMENTATION !

    //Use Optional class when searching 1 Student. If that student is not found then the Null needs to be handled gracefull by Optional
    Optional<Student> findStudentByFirstName(String firstName); //Custom Search method. Hibernate will provide the implementation automatically !

    @Query(value = "SELECT * FROM Student S WHERE S.first_Name=?1 and S.studentID=?2", nativeQuery = true)
        //Default Query to be used if the JPA generated/provided query in below method is not matching !
        //nativeQuery = true    means it uses SQL ->  uses camel case names of Object attribute names for query
        //TO test this "http://localhost:8083/student/findByFirstNameAndLastName?firstName=Sumit&studentID=2" i.e. pass studentID in lastName param in Postman
    Optional<Student> findStudentByFirstNameAndStudentID(String firstName, Long studentID); //Custom Search method. Hibernate will provide the implementation automatically !


    @Query("SELECT S FROM Student S WHERE S.firstName=?1 and S.studentID=?2")
        //Default Query to be used if the JPA generated/provided query in below method is not matching !
        //HQL -> Hibernate Query Language: uses actual Object attribute names for query. It is used as default query if JPA is unable to build query as part of below method !
        //Here we purposely  wrote S.studentID=? so that our provided Query is executed to showcase HQL
        //TO test this "http://localhost:8083/student/findByFirstNameAndLastName?firstName=Sumit&lastName=2" i.e. pass studentID in lastName param in Postman
    Optional<Student> findStudentByFirstNameAndLastName(String firstName, String lastName); //Custom Search method. Hibernate will provide the implementation automatically !

    //Use List when fetching more than one i.e. List of Students. In this List will handle the No records as Zero!
    List<Student> findAllByLastName(String lastName, Pageable pageable);
    List<Student> findAllByFirstName(String firstName);

}
