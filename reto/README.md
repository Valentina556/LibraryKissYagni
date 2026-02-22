# Reto de Refactorización: Review Management
 
¡Bienvenido al reto! Tienes frente a ti un componente de "Gestión de Reseñas" que acaba de ser entregado. Aunque funciona, es un claro ejemplo de **sobreingeniería**.
 
## El Estado Actual
El código en esta carpeta (reto) sufre de varios errores arquitectónicos:
 
1.  **Sobreingeniería (KISS Roto)**: Se crearon 6 archivos para algo que podría resolverse de forma mucho más simple.
2.  **DTOs y Mappers Innecesarios**: Se están transformando datos que son idénticos solo por "seguir la arquitectura".
3.  **YAGNI (You Aren't Gonna Need It)**: Hay campos en el modelo (`isbn`, `reviewerEmail`) y métodos en el servicio (`deleteReview`) que nadie pidió.
4.  **Acoplamiento Alto**: El servicio depende directamente de `LibraryManager`.
5.  **Mala Organización**: Todo está "apeñuscado" en un mismo paquete de challenge, ignorando la estructura de capas del proyecto.
 
## El Objetivo
Tu misión es refactorizar este componente para que sea:
- **Simple (KISS)**: Elimina lo que no aporta valor.
- **Pragmático (YAGNI)**: Borra el código muerto y los campos que puedan sobrar.
- **Análisis de Estructura (YAGNI)**: Analiza si es necesario aplicar alguna estructura de encarpetado.

 

 