package com.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad User con campos y validaciones innecesarias
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private String email; // Nadie lo pidió
    private String phone; // Nadie lo pidió
    private LocalDateTime registeredAt; // Nadie lo pidió
    private UserType userType; // Complicación innecesaria
    private Integer maxLoans; // Nadie lo pidió
    private Boolean active; // Nadie lo pidió

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredAt = LocalDateTime.now();
        this.userType = UserType.REGULAR;
        this.maxLoans = 3;
        this.active = true;
    }

    // Validación compleja innecesaria
    public boolean isValid() {
        return Objects.nonNull(id) && 
               !id.isEmpty() && 
               Objects.nonNull(name) && 
               !name.isEmpty() &&
               name.length() >= 3 &&
               active;
    }

    // Método que nunca se usa
    public boolean canBorrow() {
        return active && userType != UserType.SUSPENDED;
    }

    // Enum innecesario
    public enum UserType {
        REGULAR,
        PREMIUM,
        STUDENT,
        SUSPENDED
    }
}
