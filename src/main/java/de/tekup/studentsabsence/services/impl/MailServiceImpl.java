package de.tekup.studentsabsence.services.impl;

import de.tekup.studentsabsence.entities.Student;
import de.tekup.studentsabsence.entities.Subject;
import de.tekup.studentsabsence.services.MailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private JavaMailSender javaMailSender;

    @Override
    public void sendEliminatedEmail(Student student, Subject subject) {

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("nabilkhmissi10@gmail.com");
        mailMessage.setTo(student.getEmail());
        mailMessage.setText("Hello Mr " + student.getFirstName() + " " + student.getLastName() + " " +
                "nous vous informos que vous etes eliminé de la matiere : " + subject.getName()+ " " +
                "a cause de vos abscences successives ...");
        mailMessage.setSubject("[elimination de la matiere: " + subject.getName() + " ]");
        javaMailSender.send(mailMessage);
    }
}

