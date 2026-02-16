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
- **Book**: 6 campos cuando solo necesitamos 3 (id, title, author)
- **User**: 4 campos cuando solo necesitamos 2 (id, name)
- Campos "por si acaso": isbn, createdAt, status, email, userType

### 4. Capas Innecesarias
```
domain/
├── model/
├── policy/
└── service/
application/
├── dto/
└── mapper/
presentation/
└── controller/
```

3 capas cuando solo necesitamos 2

### 5. DTOs Innecesarios
- BookResponseDTO, LoanRequestDTO, LoanResponseDTO
- Conversiones triviales que no agregan valor
- BookMapper para conversiones simples

### 6. Logging Excesivo
- Logger en cada clase
- Logs en cada método
- Información redundante que dificulta el debugging

## Estructura del Proyecto

```
src/main/java/com/biblioteca/
├── BibliotecaBadApplication.java
├── domain/
│   ├── model/
│   │   ├── Book.java (con campos innecesarios)
│   │   └── User.java (con campos innecesarios)
│   ├── policy/
│   │   ├── LoanPolicy.java (interface)
│   │   ├── DefaultLoanPolicy.java (siempre retorna true)
│   │   ├── FinePolicy.java (interface)
│   │   └── NoFinePolicy.java (siempre retorna 0)
│   └── service/
│       ├── NotificationService.java (nunca usado)
│       ├── AbstractLibraryManager.java (jerarquía innecesaria)
│       └── LibraryManager.java
├── application/
│   ├── dto/
│   │   ├── BookResponseDTO.java
│   │   ├── LoanRequestDTO.java
│   │   └── LoanResponseDTO.java
│   └── mapper/
│       └── BookMapper.java (conversiones triviales)
└── presentation/
    └── controller/
        └── LibraryController.java (REST API con DTOs)
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
