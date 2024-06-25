package co.pragra.learning.springRESTAPI.api;

import co.pragra.learning.springRESTAPI.entities.Student;
import co.pragra.learning.springRESTAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isNotBlank;


@RestController
@RequestMapping("/student")
public class StudentAPI {
    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")         //http://localhost:8083/student/addStudent
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
        return "Student added "+student;
    }

    //http://localhost:8083/student/allStudents
    @GetMapping("/allStudents")     //Fetch all Students from h2 database using StudentService
    public List<Student> getAllStudents(){
        System.out.println("GET method to fetch All Students");
        return studentService.getAllStudents();
    }

    //http://localhost:8083/student/allByFirstName
    @GetMapping("/allByFirstName")     //Fetch all Students from h2 database using StudentService
    public List<Student> getAllStudentsByFirstName(@RequestParam String firstName){
        System.out.println("GET method to fetch All Students by First Name: "+firstName);
        return studentService.getAllStudentsByFirstName(firstName);
    }

    @GetMapping("/findByFirstNameAndStudentID")          //http://localhost:8083/student/findByFirstNameAndStudentID and Query Params
    public Optional<Student> getStudentByFirstNameAndStudentID(@RequestParam String firstName, @RequestParam Long studentID){
        System.out.println("GET method to fetch Student by First Name: "+firstName + " and Student ID: "+studentID);
        return studentService.getStudentByFirstNameAndStudentID(firstName,studentID);
    }

    @GetMapping("/findByFirstNameAndLastName")          //http://localhost:8083/student/findByFirstNameAndLastName and Query Params
    public Optional<Student> getStudentByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName){
        System.out.println("GET method to fetch Student by First Name: "+firstName + " and Last Name: "+lastName);
        return studentService.getStudentByFirstNameAndLastName(firstName,lastName);
    }

    //Additional methods for learning @PathVariable, RequestParam, RequestBody!
    @GetMapping("/hello1/{firstName}")
    public String helloWorld1(@PathVariable String firstName,       //Pathvariable is part of URL. It is used as data to process
                              @RequestParam String lastName,        //RequestParam/Query parms is provided as Params (key:value i.e. ?lastName=Jayswal) in Postman. It is used as data to process the Request
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
                               @RequestBody String message){        //RequestBody is provided in Body of Postman
        return "Hello World #1a"+" " +firstName+" "+lastName+" "+message;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/hello11")
    public String helloWorld11(){
        return "Hello World #11";
    }

    @PostMapping("/hello2")         //POST method mapping
    public String helloWorld2(){
        return "Hello World #2";
    }

}
