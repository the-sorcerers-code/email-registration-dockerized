package com.sorcererscode.notifications.emails;

public interface EmailService {
    boolean sendEmail(EmailData input) throws Exception;
}
