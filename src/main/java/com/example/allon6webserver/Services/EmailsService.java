package com.example.allon6webserver.Services;

import com.example.allon6webserver.DTO.EmailDTO;
import com.example.allon6webserver.Interfaces.IEmails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import java.util.Properties;

@Service
public class EmailsService implements IEmails {

    @Autowired
    private JavaMailSenderImpl mailSender;

    public EmailsService(JavaMailSenderImpl _javaMailSender){
        this.mailSender = _javaMailSender;
    }

    @Override
    public JavaMailSender getJavaMailSender() {
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("rnnyaz5162@gmail.com");
        mailSender.setPassword("R123456789@");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }
    @Override
    public String SendContactInformation(EmailDTO emailInformation) {

     try{
         SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom("rnnyaz5162@gmail.com");
         message.setTo("rnnyaz5162@gmail.com");
         message.setSubject("Information Request From: "+emailInformation.getName());
         message.setText("Hi there: our system was receive a new message from: "+emailInformation.getName()+"\n"+"" +
                 "This are the details about this client: "+"\n"+"_____________________________________________________________"+"\n" +
                 "Client Name: "+emailInformation.getName()+"\n"+
                 "Client Email Address: "+emailInformation.getEmail()+"\n"+
                 "Client Phone Number: "+emailInformation.getPhone()+"\n"+
                 "CLient Message: " +emailInformation.getMessage()+
                 "----------------------------------------- ------------------------------------------");

         mailSender.send(message);

         return "Thank you! "+emailInformation.getName()+ " Your information has sended";
     }catch (Exception errorEmailSender){

         return errorEmailSender.getMessage();
     }
    }
}
