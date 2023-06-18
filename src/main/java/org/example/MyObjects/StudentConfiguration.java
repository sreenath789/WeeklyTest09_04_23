package org.example.MyObjects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {

    @Bean
    public Student getStudentObject(){
        System.out.println("student object initialized by spring");
        return new Student(1,"Sreenath",24);
    }
}
