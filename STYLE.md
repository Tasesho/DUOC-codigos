# STYLE.md

Guía de estilo para apuntes técnicos en Markdown.

El objetivo de este estilo es mantener los apuntes **claros, ordenados, visualmente agradables y fáciles de estudiar**, sin convertirlos en documentación excesivamente formal.

---

# 1. Principios Generales

Los apuntes deben seguir estas prioridades:

1. **Claridad**
2. **Consistencia**
3. **Legibilidad**
4. **Precisión**
5. **Facilidad de estudio**

El formato debe utilizarse para **mejorar la comprensión**, no simplemente para decorar el documento.

> [!IMPORTANT]
> El contenido debe seguir siendo comprensible incluso si se elimina todo el formato visual.

Evitar sobrecargar una sección con:

* demasiadas negritas;
* demasiadas tablas;
* demasiados bloques destacados;
* demasiados niveles de encabezados;
* elementos visuales innecesarios.

---

# 2. Jerarquía de Encabezados

Utilizar encabezados para representar la estructura lógica del contenido.

```markdown
## 1. Concepto principal

### Definición

### Características

### Ejemplo

## 2. Siguiente concepto
```

Utilizar numeración cuando el documento tenga una estructura secuencial o corresponda a una clase.

No crear encabezados únicamente para separar pequeños párrafos.

La jerarquía debe seguir una relación lógica:

```text
Tema
│
├── Concepto
│   ├── Definición
│   ├── Características
│   └── Ejemplo
│
└── Siguiente concepto
```

Evitar saltos innecesarios como:

```markdown
## Tema

#### Subtema
```

si no existe un `###` intermedio que justifique esa profundidad.

---

# 3. Negrita

Utilizar **negrita** para destacar conceptos importantes dentro de una explicación.

Ejemplo:

```markdown
La **encapsulación** permite proteger el estado interno de un objeto.
```

Utilizar negrita principalmente para:

* conceptos fundamentales;
* términos técnicos importantes;
* palabras que deben identificarse rápidamente;
* conclusiones;
* nombres de categorías.

Evitar escribir párrafos completos en negrita.

Incorrecto:

```markdown
**La encapsulación permite proteger el estado interno de un objeto mediante mecanismos de acceso.**
```

Preferible:

```markdown
La **encapsulación** permite proteger el **estado interno** de un objeto.
```

---

# 4. Cursiva

Utilizar *cursiva* de manera moderada para dar énfasis secundario.

Puede utilizarse para:

* aclaraciones;
* términos que se quieren enfatizar ligeramente;
* conceptos secundarios;
* palabras extranjeras;
* matices dentro de una explicación.

Ejemplo:

```markdown
El objeto representa una instancia *concreta* de una clase.
```

La cursiva debe tener menor importancia visual que la negrita.

Jerarquía recomendada:

```text
Texto normal
    ↓
*cursiva*
    ↓
**negrita**
    ↓
> [!IMPORTANT]
```

No combinar `**negrita**` y `*cursiva*` salvo que exista una razón clara.

---

# 5. Código Inline

Utilizar `backticks` para elementos técnicos pequeños.

Ejemplo:

```markdown
La variable `edad` utiliza el tipo `int`.
```

Utilizarlo para:

* variables;
* funciones;
* métodos;
* atributos;
* clases;
* comandos;
* palabras reservadas;
* nombres de tablas;
* nombres de columnas;
* archivos;
* rutas;
* valores técnicos;
* fragmentos pequeños de código.

Ejemplo:

```markdown
El método `getNombre()` devuelve el valor de `nombre`.
```

No utilizar backticks para conceptos generales que no sean elementos técnicos.

---

# 6. Bloques de Código

Utilizar bloques de código cuando exista código real.

Siempre que sea posible, especificar el lenguaje:

````markdown
```java
public class Persona {
}
```
````

Ejemplos:

````markdown
```bash
sudo systemctl status nginx
```
````

````markdown
```sql
SELECT *
FROM usuarios;
```
````

````markdown
```python
print("Hola")
```
````

No utilizar bloques de código genéricos cuando se conoce el lenguaje.

---

# 7. Diagramas y Representaciones Visuales

Utilizar bloques `text-x-trilium-auto` para representar estructuras conceptuales, relaciones, jerarquías, árboles o diagramas ASCII.

Ejemplo:

````markdown
```text-x-trilium-auto
        CLASE
           │
     ┌─────┴─────┐
     ▼           ▼
  ATRIBUTOS    MÉTODOS
```
````

Utilizar diagramas cuando permitan comprender algo más rápidamente que mediante texto.

Son especialmente útiles para:

* jerarquías;
* relaciones;
* dependencias;
* estructuras;
* arquitecturas;
* flujos;
* modelos;
* árboles.

No utilizar diagramas simplemente porque existe espacio para uno.

---

# 8. Tablas

Las tablas deben utilizarse cuando permitan **comparar, clasificar o resumir información**.

Son especialmente útiles para:

* comparar conceptos;
* listar propiedades;
* resumir diferencias;
* mostrar categorías;
* mostrar sintaxis;
* relacionar conceptos con ejemplos.

Ejemplo:

```markdown
| Concepto | Descripción |
| -------- | ----------- |
| **Clase** | Molde para crear objetos |
| **Objeto** | Instancia de una clase |
| **Método** | Comportamiento de un objeto |
```

Mantener los encabezados cortos y descriptivos.

Evitar tablas cuando el contenido sea simplemente una lista.

Incorrecto:

```markdown
| Conceptos |
| --------- |
| Java      |
| Python    |
| C++       |
```

Preferible:

```markdown
- Java
- Python
- C++
```

---

# 9. Tablas Comparativas

Cuando dos o más conceptos puedan confundirse, utilizar una tabla comparativa.

Ejemplo:

```markdown
| Característica | Clase | Objeto |
| -------------- | ----- | ------ |
| Representa | Molde | Instancia |
| Define | Estado y comportamiento | Estado concreto |
| Existencia | Conceptual | Concreta |
```

Las tablas comparativas deben centrarse en las **diferencias relevantes**, no intentar incluir toda la información disponible.

---

# 10. Tablas de Resumen

Al finalizar un tema grande, puede utilizarse una tabla para condensar los conceptos principales.

```markdown
## Resumen General

| Concepto | Idea principal |
| -------- | -------------- |
| **Entidad** | Objeto relevante del sistema |
| **Atributo** | Característica de una entidad |
| **Relación** | Asociación entre entidades |
```

La tabla de resumen debe ser breve.

Su objetivo es permitir revisar un tema rápidamente.

---

# 11. Listas

Utilizar listas cuando los elementos tengan la misma importancia o cuando se estén enumerando características.

Ejemplo:

```markdown
Un sistema puede tener:

- Usuarios
- Roles
- Permisos
- Recursos
```

También pueden utilizarse para procedimientos:

```markdown
1. Crear la base de datos.
2. Crear las tablas.
3. Definir las restricciones.
4. Insertar los datos.
```

No utilizar tablas para reemplazar listas simples.

---

# 12. Separadores

Utilizar `---` para separar secciones conceptualmente independientes.

Ejemplo:

```markdown
## 1. Concepto

Contenido.

---

## 2. Siguiente concepto
```

No utilizar separadores entre cada pequeño párrafo.

El separador debe representar un **cambio significativo de contexto**.

---

# 13. Notes y Admonitions

Las notas destacadas deben utilizarse para información que merece atención especial.

Las principales categorías son:

* `TIP`
* `IMPORTANT`
* `WARNING`
* `NOTE`

Ejemplo:

```markdown
> [!TIP]
> Utiliza nombres descriptivos para facilitar la lectura del código.
```

```markdown
> [!IMPORTANT]
> Una clase define la estructura y comportamiento de sus objetos.
```

```markdown
> [!WARNING]
> No confundas asignación `=` con comparación `==`.
```

```markdown
> [!NOTE]
> Esta característica depende de la implementación utilizada.
```

---

# 14. TIP

Utilizar `TIP` para consejos prácticos o reglas que faciliten el aprendizaje.

Ejemplo:

```markdown
> [!TIP]
> Si dos conceptos son fáciles de confundir, compáralos en una tabla.
```

No utilizar `TIP` para definiciones fundamentales.

---

# 15. IMPORTANT

Utilizar `IMPORTANT` para información que el lector debería recordar.

Ejemplo:

```markdown
> [!IMPORTANT]
> Si declaras un constructor, Java deja de proporcionar automáticamente el constructor sin parámetros.
```

Debe utilizarse con moderación.

Una sección no debería contener múltiples bloques `IMPORTANT` sin una razón clara.

---

# 16. WARNING

Utilizar `WARNING` para:

* errores frecuentes;
* confusiones;
* comportamientos inesperados;
* excepciones importantes;
* malas prácticas.

Ejemplo:

```markdown
> [!WARNING]
> Comparar objetos mediante `==` no equivale necesariamente a comparar su contenido.
```

No utilizar `WARNING` simplemente para llamar la atención.

---

# 17. NOTE

Utilizar `NOTE` para información adicional que complementa la explicación principal.

Ejemplo:

```markdown
> [!NOTE]
> Esta característica puede variar dependiendo de la tecnología utilizada.
```

Si la información es fundamental para comprender el tema, utilizar `IMPORTANT` en lugar de `NOTE`.

---

# 18. Citas y Definiciones

Las citas normales `>` pueden utilizarse para definiciones, conclusiones o frases que resuman una idea.

Ejemplo:

```markdown
> Una clase es una plantilla que define las características y comportamientos de sus objetos.
```

Cuando la información requiera mayor énfasis, utilizar una admonición.

```markdown
> [!IMPORTANT]
> Una clase define qué puede tener y hacer un objeto.
```

No utilizar ambos simultáneamente sin necesidad.

---

# 19. Estructura de una Explicación

Cuando un concepto sea importante, utilizar preferentemente esta progresión:

```text
Definición
    ↓
Explicación
    ↓
Características
    ↓
Ejemplo
    ↓
Interpretación
    ↓
Idea clave
```

Ejemplo:

````markdown
## Encapsulamiento

El **encapsulamiento** permite controlar el acceso al estado interno de un objeto.

### Características

- Protege los atributos.
- Controla su modificación.
- Reduce el acceso directo al estado interno.

### Ejemplo

```java
private int edad;
````

El atributo no puede modificarse directamente desde cualquier parte del programa.

> [!IMPORTANT]
> El encapsulamiento permite controlar cómo se accede al estado interno de un objeto.

````

No todos los conceptos necesitan todas estas subsecciones.

---

# 20. Ejemplos

Los ejemplos deben aparecer cerca del concepto que explican.

Preferir:

```markdown
## Herencia

La **herencia** permite...

### Ejemplo

```java
class Perro extends Animal {
}
````

`Perro` hereda características de `Animal`.

````

En lugar de colocar todos los ejemplos al final del documento.

Los ejemplos deben ser suficientemente pequeños para demostrar el concepto sin introducir complejidad innecesaria.

---

# 21. Explicaciones Conceptuales

Cuando exista código, no limitarse a mostrarlo.

Explicar qué representa.

Ejemplo:

```markdown
```java
Persona persona = new Persona();
````

Aquí se crea una nueva instancia de `Persona` y se almacena su referencia en la variable `persona`.

````

La regla general es:

> **Código + explicación.**

---

# 22. Comparaciones

Cuando dos conceptos sean similares, utilizar una estructura explícita de comparación.

```markdown
## Clase vs. Objeto

| | Clase | Objeto |
|---|---|---|
| Representa | Molde | Instancia |
| Define | Estructura | Estado concreto |
````

Después de la tabla, puede añadirse una frase de memorización:

```markdown
> [!IMPORTANT]
> **Clase = molde. Objeto = instancia.**
```

---

# 23. Errores Comunes

Cuando el tema tenga errores frecuentes, incluir una sección específica.

```markdown
## Errores comunes

### Confundir `=` con `==`

`=` asigna un valor.

`==` compara valores.

> [!WARNING]
> `=` y `==` tienen funciones diferentes.
```

Esta sección es especialmente recomendable para programación, bases de datos, sistemas operativos y configuración.

---

# 24. Buenas Prácticas

Cuando corresponda, incluir una sección de buenas prácticas.

```markdown
## Buenas prácticas

- Utilizar nombres descriptivos.
- Mantener una estructura consistente.
- Evitar código innecesariamente complejo.
- Documentar comportamientos importantes.
```

Las buenas prácticas deben ser concretas y relacionadas con el tema.

---

# 25. Resumen General

Los temas grandes deberían terminar con un resumen.

```markdown
---

## Resumen General

| Concepto | Idea principal |
| -------- | -------------- |
| **A** | ... |
| **B** | ... |
| **C** | ... |
```

El resumen debe condensar el contenido, no repetirlo literalmente.

---

# 26. Conceptos que Conviene Memorizar

Para conceptos fundamentales, utilizar una sección de memorización.

```markdown
## Conceptos que conviene memorizar

> **Clase:** molde que define la estructura y comportamiento de los objetos.

> **Objeto:** instancia concreta de una clase.

> **Método:** comportamiento definido dentro de una clase.
```

Las definiciones deben ser breves.

No convertir esta sección en una segunda versión completa del documento.

---

# 27. Mapas Mentales

Cuando el contenido tenga una estructura jerárquica clara, puede finalizarse con un mapa conceptual.

````markdown
## Mapa mental

```text-x-trilium-auto
POO
│
├── Clase
│   ├── Atributos
│   ├── Métodos
│   └── Constructores
│
├── Encapsulamiento
├── Herencia
├── Polimorfismo
└── Abstracción
````

````

El mapa debe mostrar **relaciones**, no simplemente repetir una lista.

---

# 28. Convenciones de Nombres

Respetar la convención propia de cada lenguaje o tecnología.

No imponer una única convención para todos los proyectos.

Ejemplo:

```text
Java
├── Clase       → PascalCase
├── Variable    → camelCase
└── Constante   → MAYUSCULAS_CON_GUIONES_BAJOS

Base de datos
└── Atributos   → snake_case
````

Los nombres técnicos deben conservarse correctamente.

---

# 29. Consistencia

Un mismo concepto debe utilizar el mismo término a lo largo de todo el documento.

Evitar alternar innecesariamente entre:

```text
Base de Datos
BD
Base de datos
Database
```

si no existe una razón para hacerlo.

Definir la abreviatura la primera vez:

```markdown
Sistema Gestor de Bases de Datos (**SGBD**)
```

Después puede utilizarse:

```markdown
El **SGBD** permite...
```

---

# 30. Corrección del Markdown

Al editar apuntes existentes:

1. Corregir errores de Markdown.
2. Corregir ortografía y redacción.
3. Mejorar la estructura.
4. Mejorar tablas.
5. Aplicar formato.
6. Añadir elementos visuales cuando aporten valor.
7. Revisar consistencia.
8. Revisar precisión técnica.

No modificar innecesariamente el contenido original.

La prioridad es:

```text
Precisión
   ↓
Claridad
   ↓
Estructura
   ↓
Formato
   ↓
Estética
```

---

# 31. Corrección de Tablas

Las tablas deben tener siempre una estructura válida.

Incorrecto:

```markdown
| ConceptoDescripción |
| ------------------- |
| ClaseMolde          |
```

Correcto:

```markdown
| Concepto | Descripción |
| -------- | ----------- |
| Clase | Molde para crear objetos |
```

Los encabezados deben representar claramente qué contiene cada columna.

Evitar columnas vacías.

Evitar tablas excesivamente anchas cuando la información pueda expresarse de forma más sencilla.

---

# 32. Uso Moderado del Formato

No todo debe estar destacado.

Un buen documento debería tener una jerarquía visual:

```text
Título
  ↓
Encabezado
  ↓
Texto normal
  ↓
**Conceptos importantes**
  ↓
`Elementos técnicos`
  ↓
> [!IMPORTANT]
```

Si todo está destacado, nada destaca.

---

# 33. Regla de Oro

El formato debe responder a una pregunta:

> **¿Este elemento ayuda a comprender, recordar o navegar por el contenido?**

Si la respuesta es no, probablemente no sea necesario.

La finalidad del estilo no es crear un documento visualmente complejo.

La finalidad es convertir información técnica en **apuntes estructurados, comprensibles y fáciles de revisar**.

---

# 34. Plantilla General

Una estructura recomendada para un tema grande es:

````markdown
# Tema

**Conceptos clave**

- Concepto
- Concepto
- Concepto

---

## 1. Concepto

Definición y explicación.

> [!IMPORTANT]
> Idea fundamental.

### Características

- Característica
- Característica
- Característica

### Ejemplo

```text-x-trilium-auto
...
````

### Explicación

Interpretación del ejemplo.

> [!TIP]
> Consejo o regla práctica.

---

## 2. Siguiente concepto

...

---

## Errores comunes

### Error

Explicación.

> [!WARNING]
> Qué debe evitarse.

---

## Buenas prácticas

* Práctica
* Práctica
* Práctica

---

## Resumen General

| Concepto | Idea principal |
| -------- | -------------- |
| **A**    | ...            |
| **B**    | ...            |
| **C**    | ...            |

## Conceptos que conviene memorizar

> **A:** definición breve.

> **B:** definición breve.

## Mapa mental

```text-x-trilium-auto
Tema
│
├── Concepto A
├── Concepto B
└── Concepto C
```

````

No es obligatorio utilizar todas las secciones. La estructura debe adaptarse al tamaño y naturaleza del tema.

---

# 35. Filosofía del Estilo

Los apuntes deben sentirse como **material de estudio técnico**, no como documentación empresarial ni como un artículo académico.

La estructura ideal es:

```text
             INFORMACIÓN
                  │
                  ▼
              CONCEPTO
                  │
                  ▼
             EXPLICACIÓN
                  │
          ┌───────┴───────┐
          ▼               ▼
       EJEMPLO          DIAGRAMA
          │               │
          └───────┬───────┘
                  ▼
             IDEA CLAVE
                  │
                  ▼
               RESUMEN
````

La regla principal es:

> **Explicar primero. Destacar después. Decorar al final.**

El Markdown debe hacer que los apuntes sean más fáciles de **leer, comprender, estudiar y recordar**, manteniendo siempre una estructura consistente.
