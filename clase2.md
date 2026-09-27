# Herencia

La **herencia** es un pilar de la Programación Orientada a Objetos (**POO**) que permite crear clases nuevas a partir de una clase existente.

> La herencia favorece la **reutilización**, la **especialización** y el **polimorfismo**.

---

## 1. ¿Qué es la herencia?

Mediante la herencia, una **subclase** adquiere los atributos y métodos de una **superclase**. Después, puede añadir características propias o modificar comportamientos heredados cuando sea necesario.

La relación que representa es **«es un»**: un `Perro` *es un* `Animal`.

### Características

- **Reutilización:** el comportamiento común se escribe una sola vez en la clase base.
- **Especialización:** las subclases pueden añadir características únicas o adaptar las heredadas.
- **Jerarquía natural:** permite modelar relaciones del mundo real de forma clara.

```text-x-trilium-auto
            Animal
       ┌──────┴──────┐
       ▼             ▼
    Perro          Gato
```

> [!NOTE]
> Una clase como `Animal` puede tener tantas clases hijas como sean necesarias: `Perro`, `Gato`, `Hamster`, `Rata` o `Perico`, entre otras.

---

## 2. ¿Por qué es útil la herencia?

La herencia permite crear nuevas clases basadas en clases existentes y obtener sus características automáticamente.

- **Reutilización de código:** aprovecha atributos y métodos ya definidos en la superclase.
- **Menos duplicación:** centraliza el comportamiento común y evita copiar y pegar código.
- **Organización jerárquica:** representa relaciones lógicas entre los objetos del sistema.

---

## 3. Superclase y subclase

La herencia establece una relación jerárquica: unas clases derivan de otras para reutilizar y extender su comportamiento.

| Tipo | Ejemplo | Función |
| ---- | ------- | ------- |
| **Superclase** | `Animal` | Proporciona atributos y métodos comunes; actúa como plantilla genérica. |
| **Subclase** | `Perro` | Hereda de `Animal` y añade comportamientos específicos, como `ladrar()`. |
| **Subclase** | `Gato` | Hereda de `Animal` y añade comportamientos específicos, como `maullar()`. |

---

## 4. Sintaxis básica con `extends`

Implementar herencia en Java es directo: se utiliza la palabra clave `extends` para conectar una subclase con su superclase.

1. Define la **superclase** con atributos y métodos comunes.
2. Declara la **subclase** con `extends NombreSuperClase`.
3. Crea una instancia de la subclase y usa tanto sus métodos propios como los heredados.

> [!IMPORTANT]
> En Java, una clase solo puede heredar directamente de una clase a la vez.

### Ejemplo: `Animal`, `Perro` y `Gato`

```java
public class Animal {
    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void hablar() {
        System.out.println("El animal hace un sonido");
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public static void main(String[] args) {
        Perro perro = new Perro("Pedrito", 4);
        Gato gato = new Gato("Michi", 2);

        perro.hablar();
        perro.ladrar();

        gato.hablar();
        gato.maullar();
    }
}

class Perro extends Animal {
    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hablar() {
        System.out.println(getNombre() + " dice: guau");
    }

    public void ladrar() {
        System.out.println(getNombre() + " está ladrando.");
    }
}

class Gato extends Animal {
    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hablar() {
        System.out.println(getNombre() + " dice: miau");
    }

    public void maullar() {
        System.out.println(getNombre() + " está maullando.");
    }
}
```

En este ejemplo, `Perro` y `Gato` heredan los atributos `nombre` y `edad` de `Animal`. Sus constructores usan `super(...)` para inicializar esos datos.

Además, ambas clases **sobrescriben** el método `hablar()` para especializar el sonido de cada animal y añaden un comportamiento propio: `ladrar()` o `maullar()`.

---

## 5. Uso de `super` y constructores

Como se observó en el código anterior, los constructores de las clases hijas usan `super(...)` como primera instrucción. Esta palabra clave actúa como un puente hacia la **superclase** y permite reutilizar su inicialización.

### ¿Para qué se utiliza `super`?

- **Invocar el constructor de la clase padre:** `super(nombre, edad)` inicializa los atributos heredados.
- **Acceder a un método de la superclase:** `super.metodo()` ejecuta la versión original de un método sobrescrito.
- **Reutilizar lógica común:** evita repetir la inicialización en cada subclase.

> [!IMPORTANT]
> Si se utiliza `super(...)` dentro de un constructor, debe ser la **primera instrucción**.

### Ejemplo

```java
class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }
}
```

En este caso, `super(nombre, edad)` llama al constructor de `Animal` para inicializar `nombre` y `edad`. Después, el constructor de `Perro` inicializa su atributo propio: `raza`.

También es posible llamar a la implementación original de un método:

```java
@Override
public void hablar() {
    super.hablar();
    System.out.println("El perro dice: guau");
}
```

---

## 6. Jerarquía de animales

Una **jerarquía** organiza tipos relacionados desde lo más general —las superclases— hasta lo más específico —las subclases—.

```text-x-trilium-auto
                 Animal
            ┌──────┴──────┐
            ▼             ▼
        Mamífero         Ave
        ┌───┴───┐          │
        ▼       ▼          ▼
      Perro   Gato       Águila
```

- **Nivel base:** `Animal` agrupa características y comportamientos universales.
- **Nivel intermedio:** categorías amplias, como `Mamifero` o `Ave`, heredan de `Animal`.
- **Nivel específico:** clases concretas, como `Perro`, `Gato` o `Aguila`, añaden rasgos únicos.

Esta organización permite colocar el comportamiento común en los niveles superiores y dejar los detalles particulares en las subclases.

---

## 7. Polimorfismo

Gracias a la herencia, una referencia del tipo de la superclase —por ejemplo, `Animal`— puede apuntar a un objeto de cualquiera de sus subclases, como `Perro` o `Gato`.

```java
Animal animal1 = new Perro("Pedrito", 4);
Animal animal2 = new Gato("Michi", 2);

animal1.hablar(); // Pedrito dice: guau
animal2.hablar(); // Michi dice: miau
```

Aunque ambas variables son de tipo `Animal`, al llamar a `hablar()` se ejecuta la versión correspondiente al objeto real almacenado en memoria. Esto es posible porque `Perro` y `Gato` sobrescriben ese método.

> [!IMPORTANT]
> El **polimorfismo** permite trabajar con diferentes subclases mediante una interfaz común: la superclase.

### Ventajas

- Permite escribir código más **genérico**.
- Facilita extender el programa con nuevas subclases.
- Mantiene una interfaz común para objetos relacionados.

---

## 8. Conclusión

La herencia permite reutilizar código, organizar objetos jerárquicamente y crear diseños más limpios y escalables en Java.

| Concepto | Idea principal |
| -------- | -------------- |
| **Reutilizar** | La clase base evita duplicar atributos y métodos comunes. |
| **Especializar** | Cada subclase puede añadir características propias. |
| **Sobrescribir** | Una subclase puede adaptar un comportamiento heredado con `@Override`. |
| **Polimorfismo** | Una referencia de la superclase puede representar objetos de sus subclases. |
 
