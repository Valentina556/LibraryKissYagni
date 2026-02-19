package com.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // Campos necesarios
    private String id;
    private String name;
    private String email;
    private UserType userType;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.userType = UserType.REGULAR;
    }

    public boolean canBorrow() {
        return userType != UserType.SUSPENDED;
    }

    // Enum innecesario - solo usamos REGULAR
    public enum UserType {
        REGULAR,
        PREMIUM,
        SUSPENDED
    }
}
