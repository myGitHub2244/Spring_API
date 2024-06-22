package co.pragra.learning.springRESTAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity     //  JPA will automatically create a Database Table for this Class
@Data       //  Lombok: It will provide all default getter-setter-toString-default/para Constructors-equal/hashcode methods override
@NoArgsConstructor
@AllArgsConstructor
@Builder    // To allow us to provide individual attributes values at time of Object creation in Spring Application class
public class Student {

    @Id //it ensures the studentID is unique
//    @GeneratedValue   --> Use this if we want the ID to be incremented automatically
    private Long studentID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
