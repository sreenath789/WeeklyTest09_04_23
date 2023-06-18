package org.example.Controller;

import org.example.MyObjects.Student;
import org.example.SendEmail.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired//spring will check for the beans(@Bean)by using @Configuration annotated class
    Student student;

    @GetMapping("getStudent/{receiverMail}")
    public String getDetails(@PathVariable String receiverMail){
        MailHandler.sendMail(student,receiverMail);
        return student.toString();
    }
}
