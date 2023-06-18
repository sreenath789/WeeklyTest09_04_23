package org.example.SendEmail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizedMailAuthentication extends Authenticator {

    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(MailMetaData.userMail,MailMetaData.userPassword);
    }
}
