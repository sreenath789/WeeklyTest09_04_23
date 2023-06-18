package org.example.SendEmail;

import org.example.MyObjects.Student;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    public static void sendMail(Student student,String receiverMail){


        Properties properties = System.getProperties();//this will gives an hashmap/hashtable

        System.out.println(properties);

        properties.put("mail.smtp.host",MailMetaData.hostServer);
        properties.put("mail.smtp.port",MailMetaData.port);
        properties.put(MailMetaData.sslProperty,"true");
        properties.put(MailMetaData.authPermission,"true");

        //authentication object
        Authenticator authenticator = new CustomizedMailAuthentication();

        //create a session for sender-mail & password

        Session session = Session.getInstance(properties,authenticator);

        //mime message build
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(MailMetaData.userMail);
            mimeMessage.setSubject("Student Details");
            mimeMessage.setText(student.toString());

            //set the recipients
            Address address = new InternetAddress(receiverMail);
            mimeMessage.setRecipients(Message.RecipientType.TO, String.valueOf(address));

            Transport.send(mimeMessage);
        }catch (Exception mailException){
            System.out.println(mailException.toString());
        }
    }
}
