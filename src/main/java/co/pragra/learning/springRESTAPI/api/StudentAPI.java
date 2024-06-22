package co.pragra.learning.springRESTAPI.api;

import co.pragra.learning.springRESTAPI.entities.Student;
import co.pragra.learning.springRESTAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentAPI {
    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET,value = "/hello1")
    public String helloWorld1(){
        return "Hello World #1";
    }

    @PostMapping("/hello2")         //POST method mapping
    public String helloWorld2(){
        return "Hello World #2";
    }

    @GetMapping("/all")     //Fetch all Students from h2 database using StudentService. Students were added via SpringRESTAPIApp
    public List<Student> getAllStudents(){

        System.out.println("GET method to fetch All Students");
        List<Student> allStudents = studentService.getAllStudents();
        allStudents.forEach(System.out::println);

        return allStudents;
    }

}
