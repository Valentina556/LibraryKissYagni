# 🔴 Biblioteca Bad Practices - Versión Sobreingeniería

## ⚠️ Advertencia
Este proyecto es un **ejemplo de MALAS PRÁCTICAS** con fines educativos. Muestra cómo NO se debe desarrollar software.

## Problemas de Sobreingeniería

### 1. Abstracciones Prematuras
- **LoanPolicy** y **FinePolicy**: Interfaces que siempre retornan valores fijos
- **AbstractLibraryManager**: Clase abstracta con una sola implementación
- Justificación típica: "Por si cambian las políticas en el futuro"
- Realidad: YAGNI - No lo necesitas ahora

### 2. Servicios No Utilizados
- **NotificationService**: Nadie pidió notificaciones
- Métodos para email, SMS, push notifications que nunca se ejecutan
- Código muerto que aumenta complejidad

### 3. Entidades Sobrecargadas
- **Book**: 10 campos cuando solo necesitamos 3
- **User**: 8 campos cuando solo necesitamos 2
- **Loan**: Entidad completa cuando un Map es suficiente
- Validaciones complejas innecesarias

### 4. Capas Innecesarias
```
domain/
├── model/
├── policy/
└── service/
application/
├── dto/
└── mapper/
infrastructure/
├── factory/
└── repository/
presentation/
└── controller/
```

### 5. DTOs para Todo
- BookRequestDTO, BookResponseDTO
- LoanRequestDTO, LoanResponseDTO
- Conversiones triviales que no agregan valor

### 6. Factories Innecesarios
- BookFactory, UserFactory
- Para crear objetos simples que no lo necesitan

### 7. Repository Genérico
- Interface GenericRepository con métodos que nunca se usan
- Métodos findByAuthor, findByTitle sin uso real

### 8. Logging Excesivo
- Logger en cada clase
- Logs en cada método
- Información redundante

## Estructura del Proyecto

```
src/main/java/com/biblioteca/
├── BibliotecaBadApplication.java
├── domain/
│   ├── model/
│   │   ├── Book.java (sobrecargado)
│   │   ├── User.java (sobrecargado)
│   │   └── Loan.java (innecesario)
│   ├── policy/
│   │   ├── LoanPolicy.java
│   │   ├── DefaultLoanPolicy.java
│   │   ├── FinePolicy.java
│   │   └── NoFinePolicy.java
│   └── service/
│       ├── NotificationService.java (no usado)
│       ├── AbstractLibraryManager.java
│       └── LibraryManager.java
├── application/
│   ├── dto/
│   │   ├── BookRequestDTO.java
│   │   ├── BookResponseDTO.java
│   │   ├── LoanRequestDTO.java
│   │   └── LoanResponseDTO.java
│   └── mapper/
│       └── BookMapper.java
├── infrastructure/
│   ├── factory/
│   │   ├── BookFactory.java
│   │   └── UserFactory.java
│   └── repository/
│       ├── GenericRepository.java
│       └── InMemoryBookRepository.java
└── presentation/
    └── controller/
        └── LibraryController.java
```

## Cómo Ejecutar

```bash
cd biblioteca-bad
mvn spring-boot:run
```

El servidor inicia en: http://localhost:8080

## Endpoints

### Prestar Libro
```bash
curl -X POST http://localhost:8080/api/books/borrow \
  -H "Content-Type: application/json" \
  -d '{"bookId":"1","userId":"user1"}'
```

### Devolver Libro
```bash
curl -X POST http://localhost:8080/api/books/return \
  -H "Content-Type: application/json" \
  -d '{"bookId":"1","userId":"user1"}'
```

### Consultar Disponibilidad
```bash
curl http://localhost:8080/api/books/1/available
```

## Lecciones Aprendidas

❌ **No hagas esto:**
- Crear abstracciones "por si acaso"
- Agregar funcionalidad que nadie pidió
- Crear capas innecesarias
- DTOs para todo
- Factories para objetos simples
- Logging excesivo

✅ **Mejor:**
- Ver la versión `biblioteca-good` para buenas prácticas
- Aplicar KISS (Keep It Simple, Stupid)
- Aplicar YAGNI (You Aren't Gonna Need It)
