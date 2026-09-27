# Ejercicio de práctica: Centro de arriendo de vehículos

## 1. Contexto del caso

La empresa **RuedaLibre** necesita un sistema para administrar los vehículos que
ofrece en arriendo y calcular el costo de cada reserva. La empresa trabaja con
distintos tipos de vehículos; todos comparten información básica, pero el costo
de arriendo depende del tipo de vehículo y de sus características particulares.

Además, algunos vehículos pueden estar disponibles para arriendo inmediato. El
sistema debe modelar esta situación aplicando los principios de Programación
Orientada a Objetos, organizando correctamente el comportamiento común y el
comportamiento específico de cada tipo de vehículo.

Debes implementar la solución en Java, utilizando clases separadas y respetando
las convenciones de nomenclatura: `PascalCase` para clases y `camelCase` para
atributos y métodos.

## 2. Entidades del sistema

### Clase abstracta `Vehiculo`

Todos los vehículos comparten los siguientes atributos:

- `marca` (`String`)
- `modelo` (`String`)
- `anio` (`int`)
- `kilometraje` (`double`)

La clase debe:

- incluir constructor(es), getters, setters y `toString()`;
- mantener una lista de vehículos registrados en el sistema;
- declarar un método abstracto `calcularCostoArriendo(int dias)`;
- hacer que `toString()` muestre únicamente la marca, el modelo y el año;
- utilizar los setters dentro de los constructores para aplicar las validaciones.

### Clase `Automovil`

Hereda de `Vehiculo` y agrega:

- `cantidadPuertas` (`int`)
- `tieneAireAcondicionado` (`boolean`)

El costo de arriendo se calcula de la siguiente manera:

- costo base: `$25.000` por día;
- si tiene aire acondicionado, se agrega un `10%` al costo total.

### Clase `Motocicleta`

Hereda de `Vehiculo` y agrega:

- `cilindrada` (`int`)
- `incluyeCasco` (`boolean`)

El costo de arriendo se calcula de la siguiente manera:

- costo base: `$18.000` por día;
- si no incluye casco, se agrega un `15%` al costo total.

### Interfaz `Arrendable`

La interfaz define el contrato para los vehículos que pueden ser arrendados.
Debe contener los siguientes métodos:

- `boolean estaDisponible()`;
- `void marcarComoDisponible()`.

Por ahora, solamente los automóviles deben implementar esta interfaz. El diseño
debe permitir que otros tipos de vehículos la implementen en el futuro sin
modificar la jerarquía existente.

### Interfaz `GestorVehiculos`

Debe definir las operaciones necesarias para administrar la colección de
vehículos:

- agregar un vehículo;
- modificar un vehículo existente;
- eliminar un vehículo;
- listar todos los vehículos;
- buscar vehículos por marca.

## 3. Validaciones obligatorias

Las validaciones deben realizarse dentro de los setters. Cuando una validación
falle, se debe lanzar `IllegalArgumentException` con un mensaje descriptivo.

- `marca`: no puede ser nula ni estar vacía;
- `modelo`: no puede ser nulo ni estar vacío;
- `anio`: debe estar entre `1990` y `2026`;
- `kilometraje`: debe ser mayor o igual que cero;
- `cantidadPuertas`: debe estar entre `2` y `5`;
- `cilindrada`: debe ser mayor que cero;
- `dias`: debe ser mayor que cero.

## 4. Operaciones del gestor

La clase concreta que implemente `GestorVehiculos` debe almacenar los objetos en
una colección, por ejemplo, un `ArrayList<Vehiculo>`.

Debe cumplir con lo siguiente:

1. **Agregar:** incorporar un vehículo e informar por consola que fue registrado.
2. **Modificar:** reemplazar los datos de un vehículo existente usando un
   criterio identificable, como marca y modelo.
3. **Eliminar:** quitar un vehículo de la colección según marca y modelo.
4. **Listar:** mostrar todos los vehículos usando su método `toString()`.
5. **Buscar:** retornar todos los vehículos cuya marca coincida con la marca
   recibida como criterio de búsqueda.
6. **Costo:** calcular e informar el costo de arriendo de cualquier vehículo
   utilizando polimorfismo, sin preguntar previamente si es automóvil o
   motocicleta.

## 5. Requerimientos de la clase principal

Crea una clase `Principal` que demuestre el funcionamiento completo del sistema.
Debe realizar las siguientes acciones:

1. Crear dos automóviles y dos motocicletas usando los datos de la tabla.
2. Marcar el automóvil `Toyota Corolla` como disponible para arriendo.
3. Registrar los cuatro vehículos en el gestor.
4. Listar todos los vehículos registrados.
5. Buscar y mostrar los vehículos de la marca `Honda`.
6. Calcular el costo de arriendo de cada vehículo durante `3` días.
7. Modificar el kilometraje de la motocicleta `Yamaha MT-03` y mostrar el
   resultado.
8. Eliminar el vehículo `Suzuki Swift` y volver a listar la colección.
9. Probar al menos una validación incorrecta mediante un bloque `try-catch`.

### Datos para probar el programa

| Tipo | Marca | Modelo | Año | Kilometraje | Atributos específicos |
|---|---|---|---:|---:|---|
| Automóvil | Toyota | Corolla | 2022 | 18.500,5 | 4 puertas, con aire acondicionado |
| Automóvil | Suzuki | Swift | 2020 | 42.100,0 | 5 puertas, sin aire acondicionado |
| Motocicleta | Honda | CB190R | 2023 | 7.800,0 | 190 cc, incluye casco |
| Motocicleta | Yamaha | MT-03 | 2021 | 15.250,7 | 321 cc, no incluye casco |

## 6. Resultado esperado

La ejecución debe mostrar información equivalente a la siguiente. Se aceptan
pequeñas diferencias en los textos y en el formato de los números, siempre que
los resultados sean correctos.

```text
Vehículo registrado correctamente: Toyota Corolla
Vehículo registrado correctamente: Suzuki Swift
Vehículo registrado correctamente: Honda CB190R
Vehículo registrado correctamente: Yamaha MT-03

Vehículos registrados:
Toyota Corolla (2022)
Suzuki Swift (2020)
Honda CB190R (2023)
Yamaha MT-03 (2021)

Vehículos de marca Honda:
Honda CB190R (2023)

Costo Toyota Corolla por 3 días: $82.500
Costo Suzuki Swift por 3 días: $75.000
Costo Honda CB190R por 3 días: $54.000
Costo Yamaha MT-03 por 3 días: $62.100
```

## 7. Restricciones de implementación

- No usar `instanceof` para decidir cómo calcular el costo.
- El cálculo debe resolverse mediante el método abstracto y polimorfismo.
- Los atributos deben ser privados.
- La lista debe almacenar objetos del tipo general `Vehiculo`.
- Cada clase debe estar en su propio archivo `.java`.
- Los constructores deben delegar las asignaciones a los setters.
- Los mensajes de error deben explicar claramente qué dato es inválido.

## 8. Preguntas de autoevaluación

Antes de revisar una solución, intenta responder:

1. ¿Por qué `Vehiculo` debería ser una clase abstracta?
2. ¿Qué ventaja entrega guardar automóviles y motocicletas en un
   `ArrayList<Vehiculo>`?
3. ¿Cómo se ejecuta el método correcto de `calcularCostoArriendo()` sin conocer
   el tipo concreto del objeto?
4. ¿Por qué `Arrendable` debe ser una interfaz y no una clase padre?
5. ¿Qué ocurre si se intenta crear un vehículo con kilometraje negativo?
