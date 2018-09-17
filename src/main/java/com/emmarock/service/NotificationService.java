package com.emmarock.service;

import com.emmarock.Utils;
import com.emmarock.model.Notifications;
import com.emmarock.repository.NotificationRepository;
import  com.twilio.sdk.resource.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final Environment environment;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, Environment environment) {
        this.notificationRepository = notificationRepository;
        this.environment = environment;
    }

    public Notifications notifyUser(String phoneNumber, String message, String notificationType) throws Exception {
        String username = environment.getRequiredProperty("twillo.account.accountSid");
        String password = environment.getRequiredProperty("twillo.account.authToken");
        Utils utils = new Utils(username,password);
        Message sms = utils.sendSMS(phoneNumber, message);
        Notifications notifications = new Notifications();
        notifications.setContent(message);
        notifications.setToUser(phoneNumber);
        notifications.setNotificationStatus(sms.getStatus().toString());
        notifications.setNotificationType(notificationType);
        return notificationRepository.save(notifications);
    }

}
