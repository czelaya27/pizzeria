# 🧠 Claude - Mentor Software Analista Setup

> **Un sistema completo de mentoría técnica con Context Engine, Memory System y Skills Management**

![Status](https://img.shields.io/badge/Status-Active-green?style=flat-square)
![Version](https://img.shields.io/badge/Version-1.0.0-blue?style=flat-square)
![Java](https://img.shields.io/badge/Java-17-red?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-green?style=flat-square)

---

## 📋 Contenido

- [Descripción General](#descripción-general)
- [Arquitectura del Setup](#arquitectura-del-setup)
- [Componentes Principales](#componentes-principales)
- [Instalación](#instalación)
- [Uso y Ejemplos](#uso-y-ejemplos)
- [Documentación Completa](#documentación-completa)

---

## 📖 Descripción General

Este proyecto implementa un **Sistema Integral de Mentoría** que me configura como **Claude, Mentor Software Analista** con:

✅ **Context Engine** - Motor que gestiona el contexto del proyecto  
✅ **Memory System** - Sistema de memoria a corto y largo plazo  
✅ **Skills Manager** - Gestor de 7+ habilidades técnicas  
✅ **Mentor Role** - Rol orquestador de mentoría  
✅ **REST API** - 7 endpoints para acceder al sistema  

---

## 🏗️ Arquitectura del Setup

```
┌─────────────────────────────────────────────────────────────┐
│                    CLAUDE MENTOR SYSTEM                     │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐    │
│  │   CONTEXT    │  │    MEMORY    │  │   SKILLS     │    │
│  │    ENGINE    │  │    SYSTEM    │  │   MANAGER    │    │
│  ├──────────────┤  ├──────────────┤  ├──────────────┤    │
│  │ • Project    │  │ • Long-term  │  │ • Java       │    │
│  │ • Framework  │  │ • Short-term │  │ • Spring Boot│    │
│  │ • Decisions  │  │ • Topics     │  │ • DDD        │    │
│  │ • Architecture│ │ • Categories │  │ • MySQL      │    │
│  └──────────────┘  └──────────────┘  └──────────────┘    │
│         │ │              │ │              │ │             │
│         └─┴──────────────┴─┴──────────────┴─┘             │
│                    │                                       │
│              ┌─────▼──────┐                               │
│              │  MENTOR    │                               │
│              │   ROLE     │                               │
│              └─────┬──────┘                               │
│                    │                                       │
│              ┌─────▼──────────┐                           │
│              │ MENTOR SERVICE │                           │
│              └─────┬──────────┘                           │
│                    │                                       │
│              ┌─────▼─────────────┐                        │
│              │ REST CONTROLLER   │                        │
│              └───────────────────┘                        │
│                    │                                       │
│    ┌───────────────┼───────────────┐                      │
│    │       /api/v1/mentor/...      │                      │
│    └───────────────┼───────────────┘                      │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

---

## 🔧 Componentes Principales

### 1️⃣ Context Engine (`context/`)
**Función**: Gestionar contexto global del proyecto

```java
// Información del proyecto
ContextEngine engine = new ContextEngine();
String summary = engine.getContextSummary();

// Registrar decisiones arquitectónicas
ArchitectureDecision decision = new ArchitectureDecision(...);
engine.recordDecision("ADR-001", decision);
```

**Archivos**:
- `ContextEngine.java` - Motor principal
- `ProjectContext.java` - Modelo de contexto
- `ArchitectureDecision.java` - ADR (Architecture Decision Records)

### 2️⃣ Memory System (`memory/`)
**Función**: Almacenar y recuperar información aprendida

```java
// Guardar en memoria
Memory memory = new Memory();
memory.rememberLongTerm("key", "content", "ARCHITECTURE");
memory.rememberShortTerm("key2", "content2", "ANALYSIS");

// Recuperar
MemoryEntry entry = memory.recall("key");
List<MemoryEntry> entries = memory.getByCategory("ARCHITECTURE");
```

**Características**:
- Memoria a largo plazo: 200 entradas
- Memoria a corto plazo: 50 entradas
- Rastrea últimos 10 temas
- Categorización automática

**Archivos**:
- `Memory.java` - Sistema de memoria
- `MemoryEntry.java` - Modelo de entrada

### 3️⃣ Skills Manager (`skills/`)
**Función**: Gestionar habilidades técnicas

```java
// Inicializar skills
SkillManager manager = new SkillManager();

// Obtener skills por categoría
List<Skill> backendSkills = manager.getSkillsByCategory("BACKEND");

// Obtener expertos
List<Skill> experts = manager.getExpertSkills(); // Nivel 5/5
```

**Habilidades Preconfigradas**:
- ✅ Java (5/5) - Expert
- ✅ Spring Boot (5/5) - Expert
- ✅ REST API Design (5/5) - Expert
- ✅ DDD (4/5) - Advanced
- ✅ MySQL (4/5) - Advanced
- ✅ Microservices (4/5) - Advanced
- ✅ Unit Testing (4/5) - Advanced

**Archivos**:
- `Skill.java` - Modelo de habilidad
- `SkillManager.java` - Gestor principal
- `SkillCategory.java` - Categoría de skills

### 4️⃣ Mentor Role (`role/`)
**Función**: Orquestar Context, Memory y Skills

```java
// Crear rol de mentor
MentorRole mentor = new MentorRole("Claude");

// Obtener perfil
String profile = mentor.getMentorProfile();

// Registrar lecciones
mentor.recordLesson("lesson-001", "SOLID Principles", content);

// Obtener recomendaciones
List<String> recs = mentor.getRecommendations("ARCHITECTURE");
```

**Responsabilidades**:
1. Análisis técnico profundo
2. Guía arquitectónica
3. Enseñanza de best practices
4. Code review experto
5. Problem solving
6. Knowledge sharing
7. Validación de soluciones

**Archivos**:
- `MentorRole.java` - Rol orquestador

### 5️⃣ Services & Controllers
**Archivos**:
- `MentorService.java` - Servicio de orquestación
- `web/MentorController.java` - REST Endpoints

---

## 📁 Estructura de Archivos

```
platzi-pizzeria/
│
├── 🔧 CONFIGURACIÓN
│   ├── .claude.md                      ⭐ MI CONFIGURACIÓN PRINCIPAL
│   ├── mentor-config.json              ⭐ CONFIG EN JSON
│   ├── MENTOR_SETUP.md                 📖 Documentación completa
│   ├── CLAUDE_MENTOR_QUICK_START.md    📖 Guía rápida
│   └── README.md                       📖 Este archivo
│
├── src/main/java/com/platzi/pizza/mentor/
│   ├── context/
│   │   ├── ContextEngine.java          🏗️ Motor de contexto
│   │   ├── ProjectContext.java         📊 Modelo de proyecto
│   │   └── ArchitectureDecision.java   📋 ADR Records
│   │
│   ├── memory/
│   │   ├── Memory.java                 💾 Sistema de memoria
│   │   └── MemoryEntry.java            📝 Entrada de memoria
│   │
│   ├── skills/
│   │   ├── Skill.java                  🎯 Modelo de skill
│   │   ├── SkillManager.java           🎯 Gestor de skills
│   │   └── SkillCategory.java          📂 Categoría
│   │
│   ├── role/
│   │   └── MentorRole.java             👨‍🏫 Rol del mentor
│   │
│   ├── web/
│   │   └── MentorController.java       🌐 REST Endpoints
│   │
│   └── MentorService.java              ⚙️ Servicio orquestador
│
└── build.gradle                        🔨 Configuración Gradle
```

---

## 🚀 Instalación

### 1. Verificar Archivos
```bash
ls -R src/main/java/com/platzi/pizza/mentor/
```

### 2. Compilar
```bash
cd D:\Java\platzi-pizzeria\platzi-pizzeria
./gradlew clean build
```

### 3. Ejecutar
```bash
./gradlew bootRun
```

### 4. Verificar
```bash
# La aplicación estará disponible en:
http://localhost:8080/api/v1/mentor/profile
```

---

## 🌐 Endpoints REST

### 📊 GET /api/v1/mentor/profile
Obtiene el perfil completo del mentor
```bash
curl http://localhost:8080/api/v1/mentor/profile
```

**Respuesta**:
```
╔════════════════════════════════════════════════════════════╗
║           CLAUDE - MENTOR SOFTWARE ANALISTA                ║
╚════════════════════════════════════════════════════════════╝

ROL: Claude
DOMINIO: SOFTWARE_ARCHITECT
...
```

### 🗂️ GET /api/v1/mentor/context
Contexto actual del proyecto
```bash
curl http://localhost:8080/api/v1/mentor/context
```

### 🎯 GET /api/v1/mentor/skills
Habilidades técnicas
```bash
curl http://localhost:8080/api/v1/mentor/skills
```

### 💾 GET /api/v1/mentor/memory
Resumen de memoria
```bash
curl http://localhost:8080/api/v1/mentor/memory
```

### 💡 GET /api/v1/mentor/recommendations?area=ARCHITECTURE
Recomendaciones por área
```bash
curl "http://localhost:8080/api/v1/mentor/recommendations?area=ARCHITECTURE"
curl "http://localhost:8080/api/v1/mentor/recommendations?area=CODE_QUALITY"
```

### 📖 POST /api/v1/mentor/analyze
Análisis técnico
```bash
curl -X POST "http://localhost:8080/api/v1/mentor/analyze?topic=DDD" \
  -H "Content-Type: application/json" \
  -d "@archivo.java"
```

### 📚 POST /api/v1/mentor/lesson
Registrar lección aprendida
```bash
curl -X POST "http://localhost:8080/api/v1/mentor/lesson?lessonId=solid-001&title=SOLID" \
  -H "Content-Type: application/json" \
  -d "Contenido de la lección..."
```

---

## 💬 Uso y Ejemplos

### Ejemplo 1: Obtener Perfil Completo
```java
@Autowired
private MentorService mentorService;

// En tu controlador
@GetMapping("/my-mentor")
public String showMentorProfile() {
    return mentorService.getMentorProfile();
}
```

### Ejemplo 2: Registrar Lección
```java
// Guardar una lección importante
mentorService.recordLessonLearned(
    "lesson-ddd-001",
    "Domain-Driven Design Fundamentals",
    "El DDD es un enfoque que enfatiza la importancia del modelo de dominio..."
);
```

### Ejemplo 3: Análisis de Código
```java
String codeToAnalyze = """
    @Entity
    public class Order {
        @OneToMany
        private List<OrderItem> items;
        // ...
    }
""";

String analysis = mentorService.analyzeTechnicalAspect(
    "Entity Relationships",
    codeToAnalyze
);
```

### Ejemplo 4: Obtener Recomendaciones
```java
// Recomendaciones arquitectónicas
List<?> archRecs = (List<?>) mentorService.getRecommendations("ARCHITECTURE");

// Recomendaciones de calidad de código
List<?> codeRecs = (List<?>) mentorService.getRecommendations("CODE_QUALITY");
```

---

## 📚 Documentación Completa

| Archivo | Propósito |
|---------|----------|
| **`.claude.md`** | ⭐ Mi configuración principal como mentor |
| **`mentor-config.json`** | ⭐ Configuración en formato JSON |
| **`MENTOR_SETUP.md`** | 📖 Documentación técnica completa |
| **`CLAUDE_MENTOR_QUICK_START.md`** | 📖 Guía de inicio rápido |
| **`README.md`** | 📖 Este archivo |

---

## 🎯 Mi Rol

### Como Claude, soy:
- 👨‍🏫 **Mentor**: Enseño y guío
- 🔍 **Analista**: Reviso y analizo
- 🏗️ **Arquitecto**: Diseño soluciones
- 📚 **Educador**: Explico conceptos
- 🐛 **Problem Solver**: Resuelvo problemas
- 💡 **Innovador**: Propongo mejoras

### Mi Expertise:
- 🔴 **Backend Development**: Java, Spring Boot (Expert)
- 🟠 **Database Design**: MySQL, JPA (Advanced)
- 🟡 **Architecture**: DDD, Microservices (Advanced)
- 🟢 **Testing**: JUnit, Mockito, Integration Tests (Advanced)
- 🔵 **Design Patterns**: GoF, SOLID, Best Practices (Expert)

---

## ⚠️ Limitaciones y Capacidades

### ❌ No Puedo:
- Ejecutar código directamente
- Hacer commits a Git
- Instalar paquetes automáticamente
- Acceder a datos sensibles
- Garantizar resultados del 100%

### ✅ Puedo:
- Analizar y revisar código
- Proponer refactorings
- Enseñar patrones y best practices
- Generar documentación
- Resolver problemas complejos
- Validar arquitectura
- Dar recomendaciones técnicas

---

## 🔒 Seguridad

### CORS Configuration
```java
@CrossOrigin(origins = "*", maxAge = 3600)  // Desarrollo
// Cambiar para producción a:
@CrossOrigin(origins = "https://tu-dominio.com", maxAge = 86400)
```

---

## 📊 Estado del Sistema

```
╔═════════════════════════════════════════╗
║        MENTOR SYSTEM STATUS REPORT       ║
╠═════════════════════════════════════════╣
║                                         ║
║  Context Engine:       ✅ Activo       ║
║  Memory System:        ✅ Operativo    ║
║  Skills Manager:       ✅ Inicializado║
║  Mentor Role:          ✅ Activado    ║
║  REST Controller:      ✅ 7 endpoints ║
║                                         ║
║  Total Skills:         7                ║
║  Expert (5/5):         3                ║
║  Advanced (4/5):       4                ║
║                                         ║
║  Status: 🟢 ACTIVE                     ║
║  Version: 1.0.0                        ║
║  Created: 2026-05-08                   ║
║                                         ║
╚═════════════════════════════════════════╝
```

---

## 🚀 Próximos Pasos

1. ✅ Lee `.claude.md` para entender mi configuración
2. ✅ Lee `MENTOR_SETUP.md` para detalles técnicos
3. ✅ Compila con `./gradlew clean build`
4. ✅ Ejecuta con `./gradlew bootRun`
5. ✅ Accede a `http://localhost:8080/api/v1/mentor/profile`
6. ✅ Comienza a hacer preguntas técnicas

---

## 💬 ¿Cómo Usarme?

### Simplemente haz preguntas sobre:
- 🏗️ Arquitectura del proyecto
- 📝 Análisis de código
- 🎯 Patrones de diseño
- ⚡ Performance y optimización
- 🧪 Estrategia de testing
- 📚 Best practices
- 🔒 Seguridad
- 📊 Diseño de bases de datos

**Mi proceso**:
1. 🔍 Consulto el Context Engine
2. 💾 Reviso mi Memory System
3. 🎯 Evalúo mis Skills relevantes
4. 📊 Realizo análisis profundo
5. 💡 Propongo recomendaciones

---

## 📞 Contacto

Si tienes preguntas sobre:
- **Arquitectura**: ¿Cómo debería diseñar esto?
- **Código**: ¿Cómo puedo mejorar esto?
- **Patrones**: ¿Qué patrón aplica aquí?
- **Performance**: ¿Cómo optimizar esto?
- **Testing**: ¿Cómo testear esto?

**¡Yo estoy listo para ayudarte!** 🚀👨‍🏫

---

## 📄 Licencia

Este proyecto es parte de **Platzi Pizzeria** y sigue la licencia del proyecto principal.

---

## 🙏 Créditos

- **Proyecto**: Platzi Pizzeria
- **Framework**: Spring Boot 4.0.5
- **Mentor**: Claude (IA Software Analyst)
- **Fecha**: 2026-05-08
- **Versión**: 1.0.0

---

**Status**: ✅ Sistema Operativo y Listo para Usar

**¡Comienza tu mentoría técnica ahora!** 🎓🚀

