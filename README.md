# LibraryKissYagni - Gestor de Biblioteca con Principios KISS y YAGNI

## Descripción General

Este repositorio educativo ilustra la aplicación práctica de dos principios fundamentales de diseño de software: **KISS (Keep It Simple, Stupid)** y **YAGNI (You Aren't Gonna Need It)**.

El proyecto implementa un **gestor de biblioteca sencillo** que permite la gestión de préstamos y devoluciones de libros, así como la consulta de disponibilidad de libros.

---

## Dominio del Proyecto

### Gestor de Biblioteca Sencillo

El dominio elegido es un sistema de gestión de biblioteca que proporciona las siguientes funcionalidades:

- **Préstamo de Libros:** Registro de préstamos de libros a usuarios
- **Devolución de Libros:** Control y registro de devoluciones
- **Disponibilidad de Libros:** Consulta del estado y disponibilidad de cada libro

---

## Ramas del Proyecto

El repositorio está organizado en diferentes ramas que ilustran la evolución del diseño según los principios KISS y YAGNI:

### Rama: NoRefactoring
Implementación inicial que contiene problemas de diseño típicos que violan los principios KISS y YAGNI.

### Rama: Refactoring
Implementación refactorizada que aplica correctamente los principios KISS y YAGNI.

### Rama: Reto
Rama de desafío para práctica de estudiantes.

---

## Problemas de Diseño Identificados (Rama NoRefactoring)

### 1. Exceso de Complejidad (Violación del Principio KISS)

#### A. Campos Innecesarios en Entidades

El modelo de datos contiene campos que no son utilizados en la funcionalidad principal:

- Campos redundantes que duplican información disponible en otras entidades
- Atributos especulativos agregados "por si acaso"
- Información de auditoría no requerida inicialmente

**Impacto:**
- Incrementa la complejidad del modelo sin proporcionar valor inmediato
- Dificulta el mantenimiento y la comprensión del código
- Aumenta la superficie de acoplamiento

#### B. Mapeo Manual y Duplicación de Lógica

La conversión entre modelos se realiza de forma repetida sin abstracciones claras:

- Lógica de transformación distribuida en múltiples lugares
- Falta de separación clara entre capas
- DTOs innecesarios para funcionalidades simples

**Impacto:**
- Aumenta la posibilidad de inconsistencias
- Dificulta el mantenimiento
- Requiere cambios en múltiples lugares para una simple modificación

---

### 2. Implementación de Características No Solicitadas (Violación del YAGNI)

#### A. Capas de Abstracción Innecesarias

Se implementan capas y abstracciones que no son requeridas inicialmente:

- Múltiples niveles de mapeo entre modelos
- Interfaces para componentes que solo tienen una implementación

**Impacto:**
- Agrega complejidad sin beneficio inmediato
- Dificulta la curva de aprendizaje
- Crea deuda técnica desde el inicio

#### B. Funcionalidades Especulativas

Se agregan características anticipando necesidades futuras:

- Campos de estado que no se utilizan
- Timestamps y auditoría no solicitados
- Validaciones preventivas innecesarias

**Impacto:**
- Aumenta el tiempo de desarrollo inicial
- Incrementa la curva de mantenimiento
- Parte del código nunca se utiliza

---

## Principios Aplicados

### KISS (Keep It Simple, Stupid)

**Definición:** Mantén las cosas simples. La mayoría de sistemas funcionan mejor si se mantienen simples, evitando la complejidad innecesaria.

**Aplicación en el Proyecto:**

1. **Simplicidad en las Entidades**
   - Reducir campos a solo los esenciales para la funcionalidad actual
   - Evitar campos especulativos o de futura funcionalidad
   - Mantener modelos de datos enfocados

2. **Arquitectura Transparente**
   - Capas claramente definidas sin complejidad innecesaria
   - Métodos con responsabilidad única y enfocada
   - Eliminación de abstracción innecesaria

3. **Legibilidad del Código**
   - Nombres descriptivos y autoexplicativos para clases y métodos
   - Lógica directa y fácil de seguir
   - Evitar soluciones "inteligentes" que sacrifican claridad

4. **Separación de Responsabilidades**
   - Cada clase tiene una única razón para cambiar
   - Componentes enfocados en una funcionalidad específica
   - Facilita testing y mantenimiento

### YAGNI (You Aren't Gonna Need It)

**Definición:** No implementes funcionalidades que crees que necesitarás en el futuro, sino solo las que necesitas ahora.

**Aplicación en el Proyecto:**

1. **Características Mínimas Viables**
   - Solo implementar las funcionalidades del requisito actual
   - Permitir agregar características cuando realmente se necesiten
   - Evitar "preparar el terreno" para cambios futuros

2. **Diseño Extensible Pero Simple**
   - Estructura que permite agregar funcionalidades fácilmente
   - Sin pre-implementar patrones "por si acaso"
   - Extensión a través de herencia o composición cuando sea necesario

3. **Evitar Over-Engineering**
   - No crear capas de abstracción innecesarias
   - Usar patrones solo cuando resuelven un problema actual
   - Refactorizar cuando emerge la necesidad, no antes

4. **Pragmatismo en la Implementación**
   - Balance entre flexibilidad y simplicidad
   - Aceptar que el código puede evolucionar
   - No anticipar todos los posibles cambios futuros

---

## Decisiones de Diseño Relevantes

### 1. Estructura de Entidades

**Decisión:** Utilizar entidades simples con solo los atributos esenciales.

**Justificación:**
- Reduce la complejidad del código inicial
- Facilita el mantenimiento
- Permite agregar campos cuando realmente se necesiten
- Mejora la claridad del modelo de negocio

---

### 2. Separación de Capas

**Decisión:** Mantener una separación clara pero no excesiva entre capas (Controller, Service, Domain).

**Justificación:**
- Facilita testing y mantenibilidad
- Evita acoplamiento directo entre componentes
- Permite cambios independientes en cada capa
- Respeta la arquitectura en capas sin sobre-complicarla

---

### 3. Inyección de Dependencias

**Decisión:** Usar Spring para inyección de dependencias.

**Justificación:**
- Reduce acoplamiento entre componentes
- Facilita testing mediante mocks
- Es un patrón ampliamente aceptado en la comunidad Java
- Permite cambiar implementaciones sin modificar clientes
