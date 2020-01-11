package pl.szewczyk.aop.sendmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class SendmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendmailApplication.class, args);
    }




}
