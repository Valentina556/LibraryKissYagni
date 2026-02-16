package com.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad User con campos innecesarios - MALA PRÁCTICA
 * Solo necesitamos: id, name
 * Pero agregamos campos "por si acaso"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // Campos necesarios
    private String id;
    private String name;
    
    // Campos innecesarios - nadie los pidió
    private String email; // ❌ Nadie lo pidió
    private UserType userType; // ❌ Complicación innecesaria

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.userType = UserType.REGULAR;
    }

    // Método que nunca se usa
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
