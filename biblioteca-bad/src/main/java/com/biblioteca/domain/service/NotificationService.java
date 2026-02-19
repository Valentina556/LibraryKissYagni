package com.biblioteca.domain.service;

import com.biblioteca.domain.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio que nunca se usa 
 */
@Service
public class NotificationService {
    
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void sendEmail(User user, String message) {
        logger.debug("Enviando email a {}: {}", user.getEmail(), message);
    }

    public void sendSMS(User user, String message) {
        logger.debug("Enviando SMS a {}: {}", user.getPhone(), message);
    }

    public void sendPushNotification(User user, String message) {
        logger.debug("Enviando push notification a {}: {}", user.getId(), message);
    }

    public void notify(User user, String message, NotificationType type) {
        switch (type) {
            case EMAIL -> sendEmail(user, message);
            case SMS -> sendSMS(user, message);
            case PUSH -> sendPushNotification(user, message);
        }
    }

    public enum NotificationType {
        EMAIL,
        SMS,
        PUSH
    }
}
