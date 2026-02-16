package com.biblioteca.domain.service;

import com.biblioteca.domain.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio que nunca se usa - nadie pidió notificaciones
 */
@Service
public class NotificationService {
    
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void sendEmail(User user, String message) {
        // Nadie pidió notificaciones por email
        logger.debug("Enviando email a {}: {}", user.getEmail(), message);
        // Implementación que nunca se ejecuta
    }

    public void sendSMS(User user, String message) {
        // Tampoco esto
        logger.debug("Enviando SMS a {}: {}", user.getPhone(), message);
        // Implementación que nunca se ejecuta
    }

    public void sendPushNotification(User user, String message) {
        // Menos esto
        logger.debug("Enviando push notification a {}: {}", user.getId(), message);
        // Implementación que nunca se ejecuta
    }

    // Método genérico que tampoco se usa
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
