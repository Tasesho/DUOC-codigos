# Clases abstractas e interfaces

Las **clases abstractas** y las **interfaces** permiten definir bases comunes y contratos para organizar programas orientados a objetos de forma flexible.

---

## 1. Clases abstractas

Una **clase abstracta** es una plantilla parcial que sirve como base para otras clases. No puede instanciarse por sí misma, pero puede contener estado y comportamiento que sus subclases reutilizan.

### Características

- **No es instanciable:** evita crear objetos genéricos que no tienen sentido por sí solos.
- **Base común:** agrupa atributos y métodos compartidos.
- **Contrato parcial:** puede combinar métodos con implementación y métodos abstractos.

> [!IMPORTANT]
> Una clase que contiene al menos un método abstracto debe declararse como `abstract`.

### ¿Por qué usar clases abstractas?

- **Lógica común:** reutilizan estado y comportamiento idéntico, como `edad` o `dormir()`.
- **Contrato parcial:** obligan a las subclases a implementar comportamientos específicos.
- **Especialización:** permiten decidir qué partes de la clase son fijas y cuáles deben adaptarse.

### Ejemplo base

La clase abstracta `Animal` centraliza el estado compartido y establece reglas que cada subclase debe cumplir.

```java
abstract class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }

    public abstract void hacerSonido();
}
```

`dormir()` tiene una implementación común, mientras que `hacerSonido()` no tiene cuerpo: cada animal debe definir su propio sonido.

> [!WARNING]
> No se puede crear un objeto con `new Animal(...)` porque `Animal` es abstracta.

### Subclases: `Perro` y `Gato`

Las subclases concretas deben implementar todos los métodos abstractos heredados o, de lo contrario, también deben declararse como abstractas.

```java
class Perro extends Animal {
    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: guau");
    }
}

class Gato extends Animal {
    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: miau");
    }
}
```

`Perro` y `Gato` heredan `nombre`, `edad` y `dormir()`, pero cada uno especializa `hacerSonido()` mediante `@Override`.

---

## 2. ¿Qué es una interfaz?

Una **interfaz** define un contrato: indica qué debe poder hacer una clase, sin especificar por completo cómo debe hacerlo. Es útil para modelar **capacidades**.

### Conceptos clave

- **Contrato:** las clases que implementan una interfaz proporcionan el código de sus métodos.
- **Capacidad `Volador`:** toda clase que implemente `Volador` debe proporcionar `volar()`.
- **Capacidad `Nadador`:** toda clase que implemente `Nadador` debe proporcionar `nadar()`.
- **Múltiples capacidades:** una clase puede implementar varias interfaces.

> Un `Pato` puede volar y nadar, sin importar de qué clase base herede.

```java
interface Volador {
    void volar();
}

interface Nadador {
    void nadar();
}
```

---

## 3. Clase abstracta vs. interfaz

| Característica | Clase abstracta | Interfaz |
| -------------- | --------------- | -------- |
| Herencia | Una clase base mediante `extends` | Varias capacidades mediante `implements` |
| Estado | Puede tener atributos de instancia | Define principalmente un contrato; sus campos son constantes |
| Constructores | Sí, para inicializar la parte heredada | No |
| Métodos | Abstractos y concretos | Abstractos; también puede incluir métodos `default` o `static` |
| Propósito | Identidad base: qué **es** un objeto | Capacidades: qué **puede hacer** un objeto |

> [!IMPORTANT]
> Una clase solo puede extender una clase —abstracta o no—, pero puede implementar múltiples interfaces.

---

## 4. Interfaces en acción

Las interfaces permiten añadir capacidades a una clase sin importar su posición en la jerarquía de herencia.

### Implementación múltiple con `Pato`

`Pato` hereda el estado común de `Animal` e implementa dos capacidades: volar y nadar.

```java
class Pato extends Animal implements Volador, Nadador {
    public Pato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: cuac");
    }

    @Override
    public void volar() {
        System.out.println(nombre + " está volando.");
    }

    @Override
    public void nadar() {
        System.out.println(nombre + " está nadando.");
    }
}
```

- **Herencia:** `Pato` obtiene `nombre`, `edad` y `dormir()` desde `Animal`.
- **Capacidad `Volador`:** obliga a implementar `volar()`.
- **Capacidad `Nadador`:** obliga a implementar `nadar()`.

---

## 5. Combinar una clase abstracta e interfaces

Combinar ambos mecanismos permite mantener estado compartido mediante herencia y añadir comportamientos modulares con interfaces.

- La **clase abstracta** aporta atributos comunes y lógica base.
- Las **interfaces** añaden roles específicos sin acoplar jerarquías completas.
- Esta combinación facilita el **polimorfismo** y la extensión del programa.

### Ejemplo: bloques de Minecraft

En este ejemplo, `Cubo` representa la base común de los bloques. `Cobblestone`, `MesaCrafteo` y `Horno` heredan de ella, mientras que las interfaces representan capacidades opcionales.

```java
abstract class Cubo {
    protected String nombre;
    protected int resistencia;

    public Cubo(String nombre, int resistencia) {
        this.nombre = nombre;
        this.resistencia = resistencia;
    }

    public void mostrarInformacion() {
        System.out.println(nombre + " tiene " + resistencia + " de resistencia.");
    }

    public abstract void interactuar();
}

interface Colocable {
    void colocar();
}

interface Fundible {
    void fundir();
}

class Cobblestone extends Cubo implements Colocable {
    public Cobblestone() {
        super("Cobblestone", 30);
    }

    @Override
    public void interactuar() {
        System.out.println("El bloque de cobblestone puede minarse.");
    }

    @Override
    public void colocar() {
        System.out.println("Se colocó un bloque de cobblestone.");
    }
}

class MesaCrafteo extends Cubo implements Colocable {
    public MesaCrafteo() {
        super("Mesa de crafteo", 25);
    }

    @Override
    public void interactuar() {
        System.out.println("Se abrió la cuadrícula de crafteo.");
    }

    @Override
    public void colocar() {
        System.out.println("Se colocó una mesa de crafteo.");
    }
}

class Horno extends Cubo implements Colocable, Fundible {
    public Horno() {
        super("Horno", 35);
    }

    @Override
    public void interactuar() {
        System.out.println("Se abrió la interfaz del horno.");
    }

    @Override
    public void colocar() {
        System.out.println("Se colocó un horno.");
    }

    @Override
    public void fundir() {
        System.out.println("El horno está fundiendo un objeto.");
    }
}
```

`Horno` ilustra la combinación: **es un** `Cubo`, por lo que hereda su estado, y **puede** ser `Colocable` y `Fundible`, por lo que implementa ambas capacidades.

---

## 6. Polimorfismo con clases abstractas e interfaces

El **polimorfismo** permite que una referencia de una clase abstracta o una interfaz apunte a cualquier objeto que la herede o implemente.

```java
Cubo bloque = new Horno();
Colocable objetoColocable = new MesaCrafteo();
Fundible objetoFundible = new Horno();

bloque.interactuar();
objetoColocable.colocar();
objetoFundible.fundir();
```

El código puede trabajar con `Cubo`, `Colocable` o `Fundible` sin depender de la clase concreta. Esto permite procesar objetos relacionados mediante una interfaz común.

### Beneficios

- Mayor **flexibilidad** para cambiar implementaciones.
- Código abierto a extensión y con menos cambios en lo existente.
- Tratamiento uniforme de colecciones de objetos relacionados.

---

## 7. Conclusión

La combinación de clases abstractas para el estado base e interfaces para capacidades transversales crea diseños robustos y flexibles.

| Concepto | Idea principal |
| -------- | -------------- |
| **Clase abstracta** | Define una base común que no se instancia directamente. |
| **Interfaz** | Define una capacidad o contrato que una clase puede implementar. |
| **Herencia** | Reutiliza estado y comportamiento mediante `extends`. |
| **Implementación** | Añade capacidades mediante `implements`. |
| **Polimorfismo** | Permite trabajar con objetos distintos desde un tipo común. |
