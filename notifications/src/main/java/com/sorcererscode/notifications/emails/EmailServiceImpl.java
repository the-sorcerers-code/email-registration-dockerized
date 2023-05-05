package com.sorcererscode.notifications.emails;

import com.sorcererscode.notifications.templates.NotificationTemplateService;
import com.sorcererscode.notifications.templates.TemplateResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private NotificationTemplateService templateService;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmailAddr;

    @Override
    public boolean sendEmail(EmailData input) throws Exception {

        TemplateResponseDto template = templateService.getTemplateByIdentifier(input.getTemplateId());

        String emailBody = template.getBody();

        for (Map.Entry<String, Object> entry: input.getTemplateInfo().entrySet()) {
            emailBody = emailBody.replace("${" + entry.getKey() + "}", entry.getValue().toString());
        }

        SimpleMailMessage mailMessage
                = new SimpleMailMessage();
        mailMessage.setFrom(senderEmailAddr);
        mailMessage.setTo(input.getRecipient());
        mailMessage.setSubject(template.getSubject());
        mailMessage.setText(emailBody);

        mailSender.send(mailMessage);

        return true;
    }
}
