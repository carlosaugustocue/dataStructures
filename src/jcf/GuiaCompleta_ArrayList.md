# Guía Completa de ArrayList en Java

## 📑 Tabla de Contenidos

1. [Introducción](#introducción)
2. [¿Qué es un ArrayList?](#qué-es-un-arraylist)
3. [Características Principales](#características-principales)
4. [Diferencias: ArrayList vs Array](#diferencias-arraylist-vs-array)
5. [Creación de ArrayList](#creación-de-arraylist)
6. [Métodos Principales](#métodos-principales)
7. [Operaciones Comunes](#operaciones-comunes)
8. [Tipos de Recorridos](#tipos-de-recorridos)
9. [Trabajar con Objetos](#trabajar-con-objetos)
10. [Buenas Prácticas](#buenas-prácticas)
11. [Errores Comunes](#errores-comunes)
12. [Performance y Complejidad](#performance-y-complejidad)
13. [Ejemplos Prácticos](#ejemplos-prácticos)
14. [Preguntas Frecuentes](#preguntas-frecuentes)

---

## Introducción

**ArrayList** es una de las estructuras de datos más utilizadas en Java. Forma parte del **Java Collections Framework** y proporciona una implementación de lista dinámica basada en arrays redimensionables.

### Importación

```java
import java.util.ArrayList;
```

### Ejemplo Básico

```java
ArrayList<String> nombres = new ArrayList<>();
nombres.add("Ana");
nombres.add("Juan");
nombres.add("María");

System.out.println(nombres); // [Ana, Juan, María]
```

---

## ¿Qué es un ArrayList?

Un **ArrayList** es:

- ✅ Una **lista dinámica** que puede crecer o reducirse automáticamente
- ✅ Una **colección ordenada** que mantiene el orden de inserción
- ✅ Una **estructura indexada** (acceso por posición)
- ✅ Permite **elementos duplicados**
- ✅ Acepta valores `null`
- ❌ **No es sincronizada** (no es thread-safe por defecto)

### Jerarquía de Clases

```
java.lang.Object
  ↳ java.util.AbstractCollection<E>
      ↳ java.util.AbstractList<E>
          ↳ java.util.ArrayList<E>
```

**Interfaces implementadas:**
- `List<E>`
- `Collection<E>`
- `Iterable<E>`
- `Cloneable`
- `Serializable`
- `RandomAccess`

---

## Características Principales

### 1. Tamaño Dinámico

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(10);  // Tamaño: 1
numeros.add(20);  // Tamaño: 2
numeros.add(30);  // Tamaño: 3
// ¡No necesitamos declarar el tamaño de antemano!
```

### 2. Acceso Rápido por Índice

```java
ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");

String primera = frutas.get(0);  // O(1) - Acceso constante
```

### 3. Implementación Basada en Array

Internamente, ArrayList usa un **array dinámico**:

```java
// Capacidad inicial por defecto: 10
ArrayList<String> lista = new ArrayList<>();  // capacidad = 10

// Cuando se llena, aumenta su capacidad en ~50%
// Nueva capacidad = (capacidad_actual * 3/2) + 1
```

### 4. Permite Duplicados y Null

```java
ArrayList<String> datos = new ArrayList<>();
datos.add("Hola");
datos.add("Hola");    // ✅ Duplicados permitidos
datos.add(null);      // ✅ Null permitido
datos.add(null);      // ✅ Múltiples null permitidos

System.out.println(datos);  // [Hola, Hola, null, null]
```

---

## Diferencias: ArrayList vs Array

| Característica | Array (`String[]`) | ArrayList (`ArrayList<String>`) |
|----------------|--------------------|---------------------------------|
| **Tamaño** | Fijo | Dinámico |
| **Declaración** | `String[] arr = new String[5];` | `ArrayList<String> list = new ArrayList<>();` |
| **Acceso** | `arr[0]` | `list.get(0)` |
| **Modificación** | `arr[0] = "Hola";` | `list.set(0, "Hola");` |
| **Longitud/Tamaño** | `arr.length` | `list.size()` |
| **Agregar elementos** | ❌ No se puede después de creado | ✅ `list.add("Nuevo")` |
| **Eliminar elementos** | ❌ No directamente | ✅ `list.remove(0)` |
| **Tipos primitivos** | ✅ `int[]`, `double[]` | ❌ Usar `Integer`, `Double` |
| **Rendimiento** | Más rápido | Ligeramente más lento |
| **Funcionalidad** | Limitada | Rica en métodos |
| **Flexibilidad** | Baja | Alta |

### Ejemplo Comparativo

```java
// ═══ ARRAY TRADICIONAL ═══
String[] arrayFrutas = new String[3];
arrayFrutas[0] = "Manzana";
arrayFrutas[1] = "Banana";
arrayFrutas[2] = "Naranja";
// arrayFrutas[3] = "Uva"; // ❌ ERROR: ArrayIndexOutOfBoundsException

System.out.println(arrayFrutas.length); // 3

// ═══ ARRAYLIST ═══
ArrayList<String> listaFrutas = new ArrayList<>();
listaFrutas.add("Manzana");
listaFrutas.add("Banana");
listaFrutas.add("Naranja");
listaFrutas.add("Uva");      // ✅ Se expande automáticamente

System.out.println(listaFrutas.size()); // 4
```

---

## Creación de ArrayList

### 1. Constructor por Defecto

```java
// Capacidad inicial: 10
ArrayList<String> lista = new ArrayList<>();
```

### 2. Constructor con Capacidad Inicial

```java
// Útil cuando conoces aproximadamente cuántos elementos tendrás
ArrayList<Integer> numeros = new ArrayList<>(100);
```

### 3. Constructor desde otra Colección

```java
ArrayList<String> original = new ArrayList<>();
original.add("A");
original.add("B");

// Copia los elementos
ArrayList<String> copia = new ArrayList<>(original);
```

### 4. Usando Arrays.asList()

```java
import java.util.Arrays;

ArrayList<String> colores = new ArrayList<>(
    Arrays.asList("Rojo", "Verde", "Azul")
);
```

### 5. Usando List.of() (Java 9+)

```java
// Crea una lista inmutable, luego la convierte a ArrayList
ArrayList<Integer> numeros = new ArrayList<>(
    List.of(1, 2, 3, 4, 5)
);
```

### 6. Sintaxis Diamond (Java 7+)

```java
// Antes de Java 7
ArrayList<String> lista1 = new ArrayList<String>();

// Java 7+: El compilador infiere el tipo
ArrayList<String> lista2 = new ArrayList<>();  // ✅ Recomendado
```

---

## Métodos Principales

### Métodos de Inserción

#### `add(E elemento)`
Agrega un elemento al final de la lista.

```java
ArrayList<String> lista = new ArrayList<>();
lista.add("Primero");
lista.add("Segundo");
// [Primero, Segundo]
```

**Complejidad:** O(1) amortizado

---

#### `add(int index, E elemento)`
Inserta un elemento en una posición específica.

```java
ArrayList<String> lista = new ArrayList<>();
lista.add("A");
lista.add("C");
lista.add(1, "B");  // Inserta en posición 1
// [A, B, C]
```

**Complejidad:** O(n) - Necesita desplazar elementos

---

#### `addAll(Collection<? extends E> c)`
Agrega todos los elementos de otra colección.

```java
ArrayList<Integer> lista1 = new ArrayList<>();
lista1.add(1);
lista1.add(2);

ArrayList<Integer> lista2 = new ArrayList<>();
lista2.add(3);
lista2.add(4);

lista1.addAll(lista2);
// lista1: [1, 2, 3, 4]
```

---

#### `addAll(int index, Collection<? extends E> c)`
Inserta todos los elementos en una posición específica.

```java
ArrayList<String> lista1 = new ArrayList<>();
lista1.add("A");
lista1.add("D");

ArrayList<String> lista2 = new ArrayList<>();
lista2.add("B");
lista2.add("C");

lista1.addAll(1, lista2);
// [A, B, C, D]
```

---

### Métodos de Acceso

#### `get(int index)`
Obtiene el elemento en la posición indicada.

```java
ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");

String primera = frutas.get(0);  // "Manzana"
String segunda = frutas.get(1);  // "Banana"
```

**Complejidad:** O(1)

---

#### `size()`
Devuelve el número de elementos en la lista.

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(10);
numeros.add(20);

System.out.println(numeros.size());  // 2
```

**Complejidad:** O(1)

---

#### `isEmpty()`
Verifica si la lista está vacía.

```java
ArrayList<String> lista = new ArrayList<>();
System.out.println(lista.isEmpty());  // true

lista.add("Algo");
System.out.println(lista.isEmpty());  // false
```

**Complejidad:** O(1)

---

### Métodos de Modificación

#### `set(int index, E elemento)`
Reemplaza el elemento en la posición indicada.

```java
ArrayList<String> colores = new ArrayList<>();
colores.add("Rojo");
colores.add("Verde");

colores.set(1, "Azul");  // Reemplaza "Verde" con "Azul"
// [Rojo, Azul]
```

**Complejidad:** O(1)

---

### Métodos de Eliminación

#### `remove(int index)`
Elimina el elemento en la posición indicada y devuelve el elemento eliminado.

```java
ArrayList<String> nombres = new ArrayList<>();
nombres.add("Ana");
nombres.add("Juan");
nombres.add("María");

String eliminado = nombres.remove(1);  // "Juan"
// [Ana, María]
```

**Complejidad:** O(n)

---

#### `remove(Object o)`
Elimina la primera aparición del elemento especificado.

```java
ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");
frutas.add("Manzana");

frutas.remove("Manzana");  // Elimina la primera "Manzana"
// [Banana, Manzana]
```

**Complejidad:** O(n)

---

#### `removeAll(Collection<?> c)`
Elimina todos los elementos que están en la colección especificada.

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);
numeros.add(4);

ArrayList<Integer> aEliminar = new ArrayList<>();
aEliminar.add(2);
aEliminar.add(4);

numeros.removeAll(aEliminar);
// [1, 3]
```

---

#### `clear()`
Elimina todos los elementos de la lista.

```java
ArrayList<String> lista = new ArrayList<>();
lista.add("A");
lista.add("B");
lista.add("C");

lista.clear();
System.out.println(lista.size());  // 0
```

**Complejidad:** O(n)

---

### Métodos de Búsqueda

#### `contains(Object o)`
Verifica si la lista contiene el elemento especificado.

```java
ArrayList<String> colores = new ArrayList<>();
colores.add("Rojo");
colores.add("Verde");

System.out.println(colores.contains("Rojo"));    // true
System.out.println(colores.contains("Azul"));    // false
```

**Complejidad:** O(n)

---

#### `indexOf(Object o)`
Devuelve el índice de la primera aparición del elemento, o -1 si no existe.

```java
ArrayList<String> letras = new ArrayList<>();
letras.add("A");
letras.add("B");
letras.add("C");
letras.add("B");

System.out.println(letras.indexOf("B"));   // 1 (primera aparición)
System.out.println(letras.indexOf("X"));   // -1 (no existe)
```

**Complejidad:** O(n)

---

#### `lastIndexOf(Object o)`
Devuelve el índice de la última aparición del elemento.

```java
ArrayList<String> letras = new ArrayList<>();
letras.add("A");
letras.add("B");
letras.add("C");
letras.add("B");

System.out.println(letras.lastIndexOf("B"));  // 3 (última aparición)
```

**Complejidad:** O(n)

---

### Métodos de Conversión

#### `toArray()`
Convierte el ArrayList a un array de Object.

```java
ArrayList<String> lista = new ArrayList<>();
lista.add("Uno");
lista.add("Dos");

Object[] array = lista.toArray();
```

---

#### `toArray(T[] a)`
Convierte el ArrayList a un array del tipo especificado.

```java
ArrayList<String> lista = new ArrayList<>();
lista.add("Uno");
lista.add("Dos");

String[] array = lista.toArray(new String[0]);
// O especificando el tamaño:
String[] array2 = lista.toArray(new String[lista.size()]);
```

---

### Otros Métodos Útiles

#### `clone()`
Crea una copia superficial del ArrayList.

```java
ArrayList<String> original = new ArrayList<>();
original.add("A");
original.add("B");

@SuppressWarnings("unchecked")
ArrayList<String> copia = (ArrayList<String>) original.clone();
```

---

#### `subList(int fromIndex, int toIndex)`
Devuelve una vista de una porción de la lista.

```java
ArrayList<Integer> numeros = new ArrayList<>();
for (int i = 1; i <= 10; i++) {
    numeros.add(i);
}

List<Integer> subLista = numeros.subList(2, 5);
System.out.println(subLista);  // [3, 4, 5]
```

⚠️ **Importante:** Modificar la sublista afecta la lista original.

---

#### `ensureCapacity(int minCapacity)`
Aumenta la capacidad interna del ArrayList si es necesario.

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.ensureCapacity(1000);  // Evita múltiples redimensionamientos
```

---

#### `trimToSize()`
Reduce la capacidad interna al tamaño actual de la lista.

```java
ArrayList<Integer> numeros = new ArrayList<>(1000);
numeros.add(1);
numeros.add(2);

numeros.trimToSize();  // Reduce la capacidad a 2
```

---

## Operaciones Comunes

### 1. Verificar si una Lista Contiene Todos los Elementos de Otra

```java
ArrayList<String> lista1 = new ArrayList<>();
lista1.add("A");
lista1.add("B");
lista1.add("C");

ArrayList<String> lista2 = new ArrayList<>();
lista2.add("A");
lista2.add("B");

boolean contieneTodos = lista1.containsAll(lista2);
System.out.println(contieneTodos);  // true
```

---

### 2. Retener Solo Elementos Comunes

```java
ArrayList<Integer> lista1 = new ArrayList<>();
lista1.add(1);
lista1.add(2);
lista1.add(3);
lista1.add(4);

ArrayList<Integer> lista2 = new ArrayList<>();
lista2.add(2);
lista2.add(4);
lista2.add(6);

lista1.retainAll(lista2);
System.out.println(lista1);  // [2, 4]
```

---

### 3. Invertir una Lista

```java
import java.util.Collections;

ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);

Collections.reverse(numeros);
System.out.println(numeros);  // [3, 2, 1]
```

---

### 4. Ordenar una Lista

```java
import java.util.Collections;

ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(3);
numeros.add(1);
numeros.add(4);
numeros.add(2);

Collections.sort(numeros);
System.out.println(numeros);  // [1, 2, 3, 4]

// Orden descendente
Collections.sort(numeros, Collections.reverseOrder());
System.out.println(numeros);  // [4, 3, 2, 1]
```

---

### 5. Mezclar Aleatoriamente

```java
import java.util.Collections;

ArrayList<String> cartas = new ArrayList<>();
cartas.add("As");
cartas.add("Rey");
cartas.add("Reina");
cartas.add("Jota");

Collections.shuffle(cartas);
System.out.println(cartas);  // Orden aleatorio
```

---

### 6. Llenar con un Valor

```java
import java.util.Collections;

ArrayList<String> lista = new ArrayList<>();
lista.add("A");
lista.add("B");
lista.add("C");

Collections.fill(lista, "X");
System.out.println(lista);  // [X, X, X]
```

---

### 7. Reemplazar Todos los Elementos

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);

numeros.replaceAll(n -> n * 2);  // Multiplica cada elemento por 2
System.out.println(numeros);  // [2, 4, 6]
```

---

### 8. Eliminar con Condición (removeIf)

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);
numeros.add(4);
numeros.add(5);

numeros.removeIf(n -> n % 2 == 0);  // Elimina números pares
System.out.println(numeros);  // [1, 3, 5]
```

---

## Tipos de Recorridos

### 1. Bucle For Tradicional (con índice)

```java
ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");
frutas.add("Naranja");

for (int i = 0; i < frutas.size(); i++) {
    System.out.println("Índice " + i + ": " + frutas.get(i));
}
```

**Ventajas:**
- ✅ Acceso al índice
- ✅ Permite modificar la lista durante el recorrido

**Cuándo usar:** Cuando necesitas el índice o modificar elementos.

---

### 2. Bucle For-Each (mejorado)

```java
ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");
frutas.add("Naranja");

for (String fruta : frutas) {
    System.out.println("Fruta: " + fruta);
}
```

**Ventajas:**
- ✅ Sintaxis más limpia
- ✅ Menos propenso a errores

**Desventajas:**
- ❌ No tienes el índice
- ❌ No puedes modificar la lista durante el recorrido

**Cuándo usar:** Cuando solo necesitas leer los elementos.

---

### 3. Iterator

```java
import java.util.Iterator;

ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");
frutas.add("Naranja");

Iterator<String> iterator = frutas.iterator();
while (iterator.hasNext()) {
    String fruta = iterator.next();
    System.out.println(fruta);
    
    // Puedes eliminar de forma segura
    if (fruta.equals("Banana")) {
        iterator.remove();
    }
}
```

**Ventajas:**
- ✅ Permite eliminar elementos de forma segura durante el recorrido

**Cuándo usar:** Cuando necesitas eliminar elementos mientras recorres.

---

### 4. ListIterator (Bidireccional)

```java
import java.util.ListIterator;

ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");
frutas.add("Naranja");

ListIterator<String> iterator = frutas.listIterator();

// Recorrido hacia adelante
while (iterator.hasNext()) {
    System.out.println("→ " + iterator.next());
}

// Recorrido hacia atrás
while (iterator.hasPrevious()) {
    System.out.println("← " + iterator.previous());
}
```

---

### 5. forEach con Lambda (Java 8+)

```java
ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");
frutas.add("Naranja");

frutas.forEach(fruta -> System.out.println("Fruta: " + fruta));

// O usando method reference
frutas.forEach(System.out::println);
```

---

### 6. Stream API (Java 8+)

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);
numeros.add(4);
numeros.add(5);

// Filtrar números pares y multiplicarlos por 2
numeros.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * 2)
    .forEach(System.out::println);
// Salida: 4, 8
```

---

### 7. Recorrido Inverso

```java
ArrayList<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");
frutas.add("Naranja");

// Desde el último hasta el primero
for (int i = frutas.size() - 1; i >= 0; i--) {
    System.out.println(frutas.get(i));
}
```

---

### Comparación de Recorridos

| Método | Sintaxis | Acceso Índice | Eliminar Seguro | Velocidad |
|--------|----------|---------------|-----------------|-----------|
| **For tradicional** | Verbose | ✅ Sí | ✅ Sí (desde atrás) | ⚡ Rápido |
| **For-each** | Simple | ❌ No | ❌ No | ⚡ Rápido |
| **Iterator** | Medio | ❌ No | ✅ Sí | ⚡ Rápido |
| **ListIterator** | Medio | ✅ Sí | ✅ Sí | ⚡ Rápido |
| **forEach lambda** | Simple | ❌ No | ❌ No | ⚡ Rápido |
| **Stream** | Funcional | ❌ No | ❌ No | 🐢 Más lento |

---

## Trabajar con Objetos

### Crear una Clase Personalizada

```java
class Estudiante {
    private String nombre;
    private int edad;
    private double promedio;
    
    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public double getPromedio() {
        return promedio;
    }
    
    @Override
    public String toString() {
        return String.format("Estudiante{nombre='%s', edad=%d, promedio=%.2f}",
            nombre, edad, promedio);
    }
}
```

---

### Usar ArrayList con Objetos

```java
public class Main {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        // Agregar estudiantes
        estudiantes.add(new Estudiante("Ana", 20, 8.5));
        estudiantes.add(new Estudiante("Juan", 22, 7.8));
        estudiantes.add(new Estudiante("María", 21, 9.2));
        
        // Recorrer
        for (Estudiante est : estudiantes) {
            System.out.println(est);
        }
        
        // Buscar estudiante por nombre
        for (Estudiante est : estudiantes) {
            if (est.getNombre().equals("Juan")) {
                System.out.println("Encontrado: " + est);
            }
        }
        
        // Filtrar estudiantes con promedio > 8.0
        for (Estudiante est : estudiantes) {
            if (est.getPromedio() > 8.0) {
                System.out.println("Excelente: " + est);
            }
        }
    }
}
```

---

### Ordenar Objetos

#### Opción 1: Implementar Comparable

```java
class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private double promedio;
    
    // Constructor, getters...
    
    @Override
    public int compareTo(Estudiante otro) {
        // Ordenar por promedio (mayor a menor)
        return Double.compare(otro.promedio, this.promedio);
    }
}

// Uso
ArrayList<Estudiante> estudiantes = new ArrayList<>();
// ... agregar estudiantes
Collections.sort(estudiantes);  // Ordena automáticamente
```

---

#### Opción 2: Usar Comparator

```java
import java.util.Comparator;

ArrayList<Estudiante> estudiantes = new ArrayList<>();
// ... agregar estudiantes

// Ordenar por nombre
Collections.sort(estudiantes, new Comparator<Estudiante>() {
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        return e1.getNombre().compareTo(e2.getNombre());
    }
});

// O con lambda (Java 8+)
Collections.sort(estudiantes, (e1, e2) -> 
    e1.getNombre().compareTo(e2.getNombre()));

// O más simple
estudiantes.sort(Comparator.comparing(Estudiante::getNombre));
```

---

### Buscar Objetos

```java
// Buscar por atributo
Estudiante encontrado = null;
for (Estudiante est : estudiantes) {
    if (est.getNombre().equals("María")) {
        encontrado = est;
        break;
    }
}

// Con Stream (Java 8+)
Optional<Estudiante> resultado = estudiantes.stream()
    .filter(est -> est.getNombre().equals("María"))
    .findFirst();

if (resultado.isPresent()) {
    System.out.println("Encontrado: " + resultado.get());
}
```

---

## Buenas Prácticas

### 1. ✅ Especificar el Tipo (Usar Generics)

```java
// ❌ Evitar
ArrayList lista = new ArrayList();  // Raw type

// ✅ Correcto
ArrayList<String> lista = new ArrayList<>();
```

---

### 2. ✅ Usar la Interfaz List

```java
// ❌ Menos flexible
ArrayList<String> lista = new ArrayList<>();

// ✅ Más flexible (permite cambiar la implementación)
List<String> lista = new ArrayList<>();
```

---

### 3. ✅ Especificar Capacidad Inicial si Conoces el Tamaño

```java
// Si sabes que tendrás ~1000 elementos
ArrayList<Integer> numeros = new ArrayList<>(1000);
```

**Por qué:** Evita múltiples redimensionamientos, mejorando el rendimiento.

---

### 4. ✅ No Modificar la Lista Durante For-Each

```java
// ❌ INCORRECTO - ConcurrentModificationException
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);

for (Integer num : numeros) {
    if (num == 2) {
        numeros.remove(num);  // ❌ ERROR
    }
}

// ✅ CORRECTO - Usar Iterator
Iterator<Integer> iterator = numeros.iterator();
while (iterator.hasNext()) {
    Integer num = iterator.next();
    if (num == 2) {
        iterator.remove();  // ✅ Seguro
    }
}

// ✅ CORRECTO - For tradicional (desde atrás)
for (int i = numeros.size() - 1; i >= 0; i--) {
    if (numeros.get(i) == 2) {
        numeros.remove(i);
    }
}

// ✅ CORRECTO - removeIf (Java 8+)
numeros.removeIf(num -> num == 2);
```

---

### 5. ✅ Comparar Strings con equals()

```java
// ❌ Incorrecto
if (texto == "Hola") { }

// ✅ Correcto
if (texto.equals("Hola")) { }

// ✅ Ignorar mayúsculas
if (texto.equalsIgnoreCase("Hola")) { }
```

---

### 6. ✅ Usar isEmpty() en lugar de size() == 0

```java
// ❌ Menos legible
if (lista.size() == 0) { }

// ✅ Más claro
if (lista.isEmpty()) { }
```

---

### 7. ✅ Clonar o Copiar Correctamente

```java
ArrayList<String> original = new ArrayList<>();
original.add("A");
original.add("B");

// ❌ Referencia, no copia
ArrayList<String> referencia = original;
referencia.add("C");
System.out.println(original);  // [A, B, C] - ¡Se modificó!

// ✅ Copia real
ArrayList<String> copia = new ArrayList<>(original);
copia.add("C");
System.out.println(original);  // [A, B] - No se modificó
```

---

### 8. ✅ Null Safety

```java
ArrayList<String> lista = obtenerLista();

// ❌ Puede lanzar NullPointerException
lista.add("Algo");

// ✅ Verificar null
if (lista != null) {
    lista.add("Algo");
}

// ✅ O inicializar si es null
if (lista == null) {
    lista = new ArrayList<>();
}
lista.add("Algo");
```

---

### 9. ✅ Liberar Memoria con clear()

```java
ArrayList<DatosGrandes> datos = new ArrayList<>();
// ... llenar con muchos datos

// Cuando ya no necesites la lista
datos.clear();  // Permite al GC liberar memoria
```

---

### 10. ✅ Usar Métodos Bulk cuando sea Posible

```java
// ❌ Menos eficiente
for (String elemento : otraLista) {
    lista.add(elemento);
}

// ✅ Más eficiente
lista.addAll(otraLista);
```

---

## Errores Comunes

### 1. ❌ IndexOutOfBoundsException

```java
ArrayList<String> lista = new ArrayList<>();
lista.add("A");

// ❌ ERROR: índice 1 no existe (solo hay elemento en 0)
String elemento = lista.get(1);
```

**Solución:**

```java
// ✅ Verificar el tamaño primero
if (indice < lista.size()) {
    String elemento = lista.get(indice);
}
```

---

### 2. ❌ ConcurrentModificationException

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);

// ❌ ERROR: modificar durante for-each
for (Integer num : numeros) {
    if (num == 2) {
        numeros.remove(num);  // ❌ Lanza excepción
    }
}
```

**Soluciones:**

```java
// ✅ Opción 1: Iterator
Iterator<Integer> it = numeros.iterator();
while (it.hasNext()) {
    if (it.next() == 2) {
        it.remove();
    }
}

// ✅ Opción 2: For inverso
for (int i = numeros.size() - 1; i >= 0; i--) {
    if (numeros.get(i) == 2) {
        numeros.remove(i);
    }
}

// ✅ Opción 3: removeIf
numeros.removeIf(num -> num == 2);
```

---

### 3. ❌ NullPointerException

```java
ArrayList<String> lista = null;

// ❌ ERROR: lista es null
lista.add("Elemento");
```

**Solución:**

```java
// ✅ Inicializar siempre
ArrayList<String> lista = new ArrayList<>();
```

---

### 4. ❌ Usar Tipos Primitivos

```java
// ❌ ERROR: no compila
ArrayList<int> numeros = new ArrayList<>();
```

**Solución:**

```java
// ✅ Usar clases Wrapper
ArrayList<Integer> numeros = new ArrayList<>();
```

---

### 5. ❌ Comparar con == en lugar de equals()

```java
ArrayList<String> lista = new ArrayList<>();
lista.add("Hola");

// ❌ Incorrecto (compara referencias)
if (lista.get(0) == "Hola") { }

// ✅ Correcto (compara contenido)
if (lista.get(0).equals("Hola")) { }
```

---

### 6. ❌ Olvidar Importar

```java
// ❌ ERROR: ArrayList no encontrado
public class Test {
    ArrayList<String> lista = new ArrayList<>();
}
```

**Solución:**

```java
// ✅ Importar al inicio
import java.util.ArrayList;

public class Test {
    ArrayList<String> lista = new ArrayList<>();
}
```

---

### 7. ❌ Modificar ArrayList mientras se Itera con Stream

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);

// ❌ Comportamiento indefinido
numeros.stream().forEach(n -> {
    if (n == 2) {
        numeros.remove(n);  // ❌ Puede causar problemas
    }
});
```

**Solución:**

```java
// ✅ Recolectar primero, luego modificar
List<Integer> aEliminar = numeros.stream()
    .filter(n -> n == 2)
    .collect(Collectors.toList());

numeros.removeAll(aEliminar);
```

---

## Performance y Complejidad

### Tabla de Complejidad Temporal

| Operación | Complejidad | Descripción |
|-----------|-------------|-------------|
| `add(E e)` | **O(1)** amortizado | Agregar al final |
| `add(int, E)` | **O(n)** | Insertar en posición (desplaza elementos) |
| `get(int)` | **O(1)** | Acceso por índice |
| `set(int, E)` | **O(1)** | Modificar por índice |
| `remove(int)` | **O(n)** | Eliminar por índice (desplaza elementos) |
| `remove(Object)` | **O(n)** | Buscar y eliminar |
| `contains(Object)` | **O(n)** | Búsqueda lineal |
| `indexOf(Object)` | **O(n)** | Búsqueda lineal |
| `size()` | **O(1)** | Obtener tamaño |
| `clear()` | **O(n)** | Limpiar toda la lista |
| `isEmpty()` | **O(1)** | Verificar si está vacía |

---

### Complejidad Espacial

- **Espacio:** O(n) donde n es el número de elementos
- **Capacidad interna:** Se duplica automáticamente cuando se llena

```java
// Capacidad inicial: 10
ArrayList<Integer> lista = new ArrayList<>();

// Cuando agregas el elemento 11, la capacidad se expande a ~15
// Nueva capacidad = (capacidad_anterior * 3/2) + 1
```

---

### Comparación con Otras Estructuras

| Operación | ArrayList | LinkedList | HashSet | TreeSet |
|-----------|-----------|------------|---------|---------|
| **Agregar al final** | O(1) | O(1) | O(1) | O(log n) |
| **Agregar al inicio** | O(n) | O(1) | - | - |
| **Acceso por índice** | O(1) | O(n) | - | - |
| **Búsqueda** | O(n) | O(n) | O(1) | O(log n) |
| **Eliminación** | O(n) | O(1)* | O(1) | O(log n) |
| **Permite duplicados** | ✅ | ✅ | ❌ | ❌ |
| **Ordenado** | ❌ | ❌ | ❌ | ✅ |

\* Si ya tienes la referencia al nodo

---

### Cuándo Usar ArrayList

✅ **Usa ArrayList cuando:**
- Necesitas acceso rápido por índice
- Agregas elementos principalmente al final
- Lees más de lo que modificas
- No necesitas sincronización

❌ **NO uses ArrayList cuando:**
- Insertas/eliminas frecuentemente en el inicio o medio
- Necesitas sincronización (usa `Vector` o `Collections.synchronizedList()`)
- Trabajas con tipos primitivos y necesitas máximo rendimiento (considera arrays)

---

## Ejemplos Prácticos

### Ejemplo 1: Sistema de Inventario

```java
import java.util.ArrayList;

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    
    public void agregarStock(int cantidad) {
        this.cantidad += cantidad;
    }
    
    public boolean vender(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("%s - $%.2f (Stock: %d)", 
            nombre, precio, cantidad);
    }
}

public class Inventario {
    private ArrayList<Producto> productos;
    
    public Inventario() {
        productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
    
    public void mostrarInventario() {
        System.out.println("=== INVENTARIO ===");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
    
    public double valorTotalInventario() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio() * p.getCantidad();
        }
        return total;
    }
    
    public static void main(String[] args) {
        Inventario inv = new Inventario();
        
        inv.agregarProducto(new Producto("Laptop", 800.00, 5));
        inv.agregarProducto(new Producto("Mouse", 20.00, 50));
        inv.agregarProducto(new Producto("Teclado", 45.00, 30));
        
        inv.mostrarInventario();
        
        System.out.println("\nValor total: $" + inv.valorTotalInventario());
        
        Producto laptop = inv.buscarProducto("Laptop");
        if (laptop != null) {
            laptop.vender(2);
            System.out.println("\nDespués de vender 2 laptops:");
            inv.mostrarInventario();
        }
    }
}
```

---

### Ejemplo 2: Sistema de Calificaciones

```java
import java.util.ArrayList;
import java.util.Collections;

class EstudianteCalif {
    private String nombre;
    private ArrayList<Double> calificaciones;
    
    public EstudianteCalif(String nombre) {
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }
    
    public void agregarCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            calificaciones.add(calificacion);
        }
    }
    
    public double calcularPromedio() {
        if (calificaciones.isEmpty()) return 0;
        
        double suma = 0;
        for (double cal : calificaciones) {
            suma += cal;
        }
        return suma / calificaciones.size();
    }
    
    public double obtenerMaxima() {
        return calificaciones.isEmpty() ? 0 : Collections.max(calificaciones);
    }
    
    public double obtenerMinima() {
        return calificaciones.isEmpty() ? 0 : Collections.min(calificaciones);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return String.format("%s - Promedio: %.2f | Calificaciones: %s",
            nombre, calcularPromedio(), calificaciones);
    }
}

public class SistemaCalificaciones {
    public static void main(String[] args) {
        ArrayList<EstudianteCalif> estudiantes = new ArrayList<>();
        
        EstudianteCalif est1 = new EstudianteCalif("Ana García");
        est1.agregarCalificacion(9.5);
        est1.agregarCalificacion(8.7);
        est1.agregarCalificacion(9.2);
        estudiantes.add(est1);
        
        EstudianteCalif est2 = new EstudianteCalif("Carlos López");
        est2.agregarCalificacion(7.5);
        est2.agregarCalificacion(8.0);
        est2.agregarCalificacion(7.8);
        estudiantes.add(est2);
        
        System.out.println("=== REPORTE DE CALIFICACIONES ===\n");
        
        for (EstudianteCalif est : estudiantes) {
            System.out.println(est);
            System.out.println("  Máxima: " + est.obtenerMaxima());
            System.out.println("  Mínima: " + est.obtenerMinima());
            System.out.println();
        }
        
        // Encontrar estudiante con mejor promedio
        EstudianteCalif mejor = estudiantes.get(0);
        for (EstudianteCalif est : estudiantes) {
            if (est.calcularPromedio() > mejor.calcularPromedio()) {
                mejor = est;
            }
        }
        System.out.println("Mejor promedio: " + mejor.getNombre() + 
            " con " + mejor.calcularPromedio());
    }
}
```

---

### Ejemplo 3: Lista de Tareas (To-Do List)

```java
import java.util.ArrayList;
import java.util.Scanner;

class Tarea {
    private String descripcion;
    private boolean completada;
    
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }
    
    public void marcarCompletada() {
        this.completada = true;
    }
    
    public boolean estaCompletada() {
        return completada;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        String estado = completada ? "[✓]" : "[ ]";
        return estado + " " + descripcion;
    }
}

public class ToDoList {
    private static ArrayList<Tarea> tareas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            
            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    mostrarTareas();
                    break;
                case 3:
                    completarTarea();
                    break;
                case 4:
                    eliminarTarea();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== TO-DO LIST ===");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Estadísticas");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }
    
    private static void agregarTarea() {
        System.out.print("Descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        tareas.add(new Tarea(descripcion));
        System.out.println("✓ Tarea agregada");
    }
    
    private static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
            return;
        }
        
        System.out.println("\n--- TAREAS ---");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }
    
    private static void completarTarea() {
        mostrarTareas();
        if (tareas.isEmpty()) return;
        
        System.out.print("Número de tarea a completar: ");
        int num = scanner.nextInt();
        
        if (num > 0 && num <= tareas.size()) {
            tareas.get(num - 1).marcarCompletada();
            System.out.println("✓ Tarea completada");
        } else {
            System.out.println("Número inválido");
        }
    }
    
    private static void eliminarTarea() {
        mostrarTareas();
        if (tareas.isEmpty()) return;
        
        System.out.print("Número de tarea a eliminar: ");
        int num = scanner.nextInt();
        
        if (num > 0 && num <= tareas.size()) {
            tareas.remove(num - 1);
            System.out.println("✓ Tarea eliminada");
        } else {
            System.out.println("Número inválido");
        }
    }
    
    private static void mostrarEstadisticas() {
        int total = tareas.size();
        int completadas = 0;
        
        for (Tarea t : tareas) {
            if (t.estaCompletada()) {
                completadas++;
            }
        }
        
        int pendientes = total - completadas;
        
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de tareas: " + total);
        System.out.println("Completadas: " + completadas);
        System.out.println("Pendientes: " + pendientes);
        
        if (total > 0) {
            double porcentaje = (completadas * 100.0) / total;
            System.out.printf("Progreso: %.1f%%\n", porcentaje);
        }
    }
}
```

---

## Preguntas Frecuentes

### 1. ¿Cuál es la diferencia entre capacity y size?

- **`size()`**: Número de elementos actuales en la lista
- **`capacity`**: Espacio total disponible en el array interno

```java
ArrayList<String> lista = new ArrayList<>(10);
// capacity = 10, size = 0

lista.add("A");
// capacity = 10, size = 1

lista.add("B");
// capacity = 10, size = 2
```

---

### 2. ¿Cómo funciona el redimensionamiento?

Cuando el ArrayList se llena:
1. Crea un nuevo array con mayor capacidad (~1.5x el tamaño actual)
2. Copia todos los elementos al nuevo array
3. Reemplaza el array antiguo

```java
// Capacidad inicial: 10
ArrayList<Integer> lista = new ArrayList<>();

// Elemento 11 → expande a ~15
// Elemento 16 → expande a ~22
// Y así sucesivamente...
```

---

### 3. ¿ArrayList es thread-safe?

**No**, ArrayList no es sincronizado. Para uso en múltiples hilos:

```java
// Opción 1: Sincronizar manualmente
List<String> lista = Collections.synchronizedList(new ArrayList<>());

// Opción 2: Usar CopyOnWriteArrayList
import java.util.concurrent.CopyOnWriteArrayList;
List<String> lista = new CopyOnWriteArrayList<>();
```

---

### 4. ¿Cuándo usar ArrayList vs LinkedList?

| Usa ArrayList cuando: | Usa LinkedList cuando: |
|----------------------|------------------------|
| Acceso frecuente por índice | Inserción/eliminación frecuente al inicio |
| Agregar al final | Implementar cola/deque |
| Tamaño relativamente estable | Tamaño muy variable |
| Iterar frecuentemente | Eliminar elementos durante iteración |

---

### 5. ¿Puedo almacenar diferentes tipos en un ArrayList?

Técnicamente sí, usando `ArrayList<Object>`, pero **NO es recomendado**:

```java
// ❌ Evitar
ArrayList<Object> mezcla = new ArrayList<>();
mezcla.add("Texto");
mezcla.add(123);
mezcla.add(true);

// ✅ Mejor: usar tipos específicos o crear clases
ArrayList<String> textos = new ArrayList<>();
ArrayList<Integer> numeros = new ArrayList<>();
```

---

### 6. ¿Cómo convertir Array a ArrayList?

```java
// Array tradicional
String[] array = {"A", "B", "C"};

// Opción 1: Arrays.asList() + Constructor
ArrayList<String> lista1 = new ArrayList<>(Arrays.asList(array));

// Opción 2: Collections.addAll()
ArrayList<String> lista2 = new ArrayList<>();
Collections.addAll(lista2, array);

// Opción 3: Stream (Java 8+)
ArrayList<String> lista3 = new ArrayList<>(
    Arrays.stream(array).toList()
);
```

---

### 7. ¿Cómo hacer una copia profunda de ArrayList con objetos?

```java
// Copia superficial (referencias compartidas)
ArrayList<Persona> copia = new ArrayList<>(original);

// Copia profunda (nuevos objetos)
ArrayList<Persona> copiaP profunda = new ArrayList<>();
for (Persona p : original) {
    copiaProfunda.add(new Persona(p));  // Constructor de copia
}
```

---

### 8. ¿Por qué no puedo usar tipos primitivos?

Java Generics solo funciona con objetos, no con primitivos:

```java
// ❌ Error de compilación
ArrayList<int> numeros = new ArrayList<>();

// ✅ Usar clases Wrapper
ArrayList<Integer> numeros = new ArrayList<>();
```

**Autoboxing/Unboxing** (automático desde Java 5):
```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(10);        // Autoboxing: int → Integer
int valor = numeros.get(0);  // Unboxing: Integer → int
```

---

### 9. ¿Cuál es la diferencia entre remove(int) y remove(Object)?

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(10);
numeros.add(20);
numeros.add(30);

// remove(int index) - Elimina por posición
numeros.remove(0);  // Elimina el elemento en índice 0 (10)

// remove(Object o) - Elimina por valor
numeros.remove(Integer.valueOf(20));  // Elimina el objeto 20
```

---

### 10. ¿Cómo evitar NullPointerException?

```java
// ✅ Opción 1: Verificar null
if (lista != null && !lista.isEmpty()) {
    // Trabajar con la lista
}

// ✅ Opción 2: Inicializar siempre
ArrayList<String> lista = new ArrayList<>();

// ✅ Opción 3: Optional (Java 8+)
Optional<ArrayList<String>> optLista = Optional.ofNullable(obtenerLista());
optLista.ifPresent(l -> {
    // Trabajar con la lista
});
```

---

## Recursos Adicionales

### Documentación Oficial

- [ArrayList JavaDoc](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html)
- [Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Java Tutorial - Collections](https://docs.oracle.com/javase/tutorial/collections/)

### Temas Relacionados

- **LinkedList**: Otra implementación de List
- **Vector**: ArrayList sincronizado (legacy)
- **CopyOnWriteArrayList**: ArrayList thread-safe
- **Collections Utility Class**: Métodos para trabajar con colecciones
- **Stream API**: Programación funcional con colecciones

---

## Resumen Final

### Puntos Clave

1. ✅ ArrayList es una **lista dinámica** basada en arrays
2. ✅ Proporciona **acceso rápido por índice** O(1)
3. ✅ Permite **elementos duplicados y null**
4. ✅ **No es sincronizado** (no thread-safe)
5. ✅ Se **redimensiona automáticamente** cuando se llena
6. ✅ Forma parte del **Java Collections Framework**
7. ✅ Usa **Generics** para type safety
8. ✅ Mejor para **lectura frecuente**, no tanto para inserción/eliminación en medio

### Cuándo Usar ArrayList

- ✅ Necesitas acceso rápido por índice
- ✅ Agregas elementos principalmente al final
- ✅ El orden de inserción es importante
- ✅ Necesitas permitir duplicados

### Alternativas

- **LinkedList**: Mejor para inserción/eliminación frecuente
- **HashSet**: Sin duplicados, sin orden
- **TreeSet**: Sin duplicados, ordenado
- **Vector**: Sincronizado (legacy, usa `Collections.synchronizedList()` en su lugar)

---

## Conclusión

ArrayList es una de las estructuras de datos más utilizadas en Java por su simplicidad y eficiencia. Dominar ArrayList te dará una base sólida para trabajar con el Java Collections Framework y te preparará para estructuras más avanzadas.

**Recuerda:**
- Practica con ejemplos reales
- Entiende las complejidades temporales
- Sigue las buenas prácticas
- Elige la estructura de datos correcta según tus necesidades

---

**¡Éxito en tu aprendizaje de Java! 🚀**

---

_Documento creado para estudiantes de Ingeniería de Software_  
_Última actualización: Octubre 2025_
