package co.pragra.learning.springjpa;

import co.pragra.learning.springjpa.entities.Student;
import co.pragra.learning.springjpa.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
        StudentService studentService = context.getBean(StudentService.class);

        System.out.println();

        studentService.addStudent(Student.builder()
                .studentID(1L)
                .firstName("Amit")
                .lastName("Kumar")
                .phoneNumber("123456678")
                .build());

        studentService.addStudent(Student.builder()
                .studentID(2L)
                .firstName("Sumit")
                .lastName("Kumar")
                .phoneNumber("23232323")
                .build());

        studentService.addStudent(Student.builder()
                .studentID(3L)
                .firstName("Sujit")
                .lastName("Kumar")
                .phoneNumber("56565656")
                .build());

        studentService.addStudent(Student.builder()
                .studentID(4L)
                .firstName("Rajiv")
                .lastName("Gupta")
                .phoneNumber("44444444")
                .build());

        studentService.addStudent(Student.builder()
                .studentID(5L)
                .firstName("Sanjiv")
                .lastName("Verma")
                .phoneNumber("22222222")
                .build());


        List<Student> allStudents = studentService.getAllStudents();
        allStudents.forEach(System.out::println);

        System.out.println();

        Optional<Student> student1 = studentService.getStudentById(2L);
        System.out.println("Student #1 found: " + student1);

        System.out.println();

        Optional<Student> student2 = studentService.getStudentByFirstName("Sujit");
        System.out.println("Student #2 found: " + student2);

        System.out.println();
        System.out.println("Pagination Example: Get 2 Students only matching Lastname");

        List<Student> allStudents3 = studentService.getStudentsByLastName("Kumar",0,2);
        allStudents3.forEach(System.out::println);

    }

}
