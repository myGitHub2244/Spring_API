package co.pragra.learning.springRESTAPI.api;

import co.pragra.learning.springRESTAPI.entities.Student;
import co.pragra.learning.springRESTAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isNotBlank;


@RestController
@RequestMapping("/student")
public class StudentAPI {
    @Autowired
    StudentService studentService;

    @GetMapping("/hello1/{firstName}")
    public String helloWorld1(@PathVariable String firstName,
                              @RequestParam String lastName,
                              @RequestParam(value="email",required=false)String email){
        //http://localhost:8083/student/hello1/Pankaj?lastName=Jayswal&email=jaip22@yahoo.com

        if(null!=email && Objects.nonNull(email)){
            return "Valid parameters";
        }
        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()){
            return "Invalid parameters";
        }
        if(isNotBlank(firstName)||isNotBlank(lastName)){
            return "Valid parameters";
        }
        return "Hello World #1"+" " +firstName+" "+lastName+" "+email;
    }

    //http://localhost:8083/student/hello1/Pankaj?lastName=Jayswal
    // And provide JSON data in Body

    @PostMapping("/hello1a/{firstName}")
    public String helloWorld1a(@PathVariable String firstName,
                               @RequestParam String lastName,
                               @RequestParam(value="email",required=false) String email,
                               @RequestBody String message){
        return "Hello World #1a"+" " +firstName+" "+lastName+" "+message;
    }


    @PostMapping("/add")         //http://localhost:8083/student/add
    /*
    Add below in Postman Body
        {
        "studentID": 6,
        "firstName": "Rishabh",
        "lastName": "Pant",
        "phoneNumber": "33322211"
        }
     */
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "Student added"+student;
    }

    @GetMapping("/all")     //Fetch all Students from h2 database using StudentService. Students were added via SpringRESTAPIApp
    public List<Student> getAllStudents(){
        System.out.println("GET method to fetch All Students");
        List<Student> allStudents = studentService.getAllStudents();
        allStudents.forEach(System.out::println);
        return allStudents;
    }

    //Additional methods
    @RequestMapping(method = RequestMethod.GET,value = "/hello11")
    public String helloWorld11(){
        return "Hello World #11";
    }

    @PostMapping("/hello2")         //POST method mapping
    public String helloWorld2(){
        return "Hello World #2";
    }

}
