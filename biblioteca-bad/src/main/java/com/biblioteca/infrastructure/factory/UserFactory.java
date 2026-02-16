package com.biblioteca.infrastructure.factory;

import com.biblioteca.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Otro factory innecesario
 */
@Component
public class UserFactory {
    
    public User createUser(String name) {
        String id = UUID.randomUUID().toString();
        return new User(id, name);
    }

    public User createUserWithId(String id, String name) {
        return new User(id, name);
    }

    // Método que nunca se usa
    public User createPremiumUser(String name, String email) {
        User user = createUser(name);
        user.setEmail(email);
        user.setUserType(User.UserType.PREMIUM);
        user.setMaxLoans(5);
        return user;
    }
}
