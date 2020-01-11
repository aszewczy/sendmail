package pl.szewczyk.aop.sendmail;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Address;

@RestController
public class EmailController {

    @Value("${gmail.username}")
    private String username;
    @Value("${gmail.password}")
    private String password;

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String sendEmail(@RequestBody EmailMessage emailMessage) throws MessagingException {

        sendmail(emailMessage);

        return"Email sent succesfully";
    }


    private void sendmail(EmailMessage emailMessage) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props, new Authenticator() {
            // Set the account information session，transport will send mail
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username,false));

        msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailMessage.getTo_address()));
        msg.setSubject(emailMessage.getSubject());
        msg.setContent(emailMessage.getBody(),"text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);



    }

}
