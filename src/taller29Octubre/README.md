# Actividad en Clase - ArrayList en Java
## Manipulación de colecciones con ArrayList

Este proyecto contiene las soluciones a los 6 ejercicios de la actividad de clase sobre ArrayList.

---

## 📁 Estructura de Archivos

### Ejercicios Básicos (1-5)
- **Punto1_Frutas.java** - Creación y recorrido de listas
- **Punto2_Ciudades.java** - Inserción, modificación y eliminación
- **Punto3Estudiantes.java** - Búsqueda y validación
- **Punto4_Colores.java** - Combinación y limpieza de listas
- **Punto5Numeros.java** - Recorrido inverso y filtrado

### Sistema Completo (6)
- **Tarea.java** - Clase modelo para representar una tarea
- **Punto6SistemaGestionTareas.java** - Sistema completo de gestión de tareas

---

## 🚀 Cómo Ejecutar los Programas

### Opción 1: Desde la terminal

```bash
# Para los puntos 1-5 (ejecutar cada uno individualmente)
javac Punto1_Frutas.java
java Punto1_Frutas

javac Punto2_Ciudades.java
java Punto2_Ciudades

# ... y así sucesivamente

# Para el punto 6 (requiere compilar ambos archivos)
javac Tarea.java Punto6SistemaGestionTareas.java
java Punto6SistemaGestionTareas
```

### Opción 2: Desde un IDE (Eclipse, IntelliJ, NetBeans, VS Code)

1. Crear un nuevo proyecto Java
2. Copiar los archivos .java al proyecto
3. Ejecutar el archivo que contenga el método `main()`

---

## 📚 Conceptos Clave de ArrayList

### ¿Qué es un ArrayList?

ArrayList es una clase de Java que implementa una **lista dinámica**. A diferencia de los arrays tradicionales, los ArrayList pueden crecer o reducirse automáticamente.

```java
// Array tradicional (tamaño fijo)
String[] array = new String[5];

// ArrayList (tamaño dinámico)
ArrayList<String> lista = new ArrayList<>();
```

### Métodos Principales

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `add(E e)` | Agrega un elemento al final | `lista.add("Hola")` |
| `add(int index, E e)` | Inserta en posición específica | `lista.add(0, "Inicio")` |
| `get(int index)` | Obtiene elemento en posición | `lista.get(2)` |
| `set(int index, E e)` | Reemplaza elemento en posición | `lista.set(1, "Nuevo")` |
| `remove(int index)` | Elimina elemento en posición | `lista.remove(0)` |
| `size()` | Devuelve cantidad de elementos | `lista.size()` |
| `contains(Object o)` | Verifica si existe un elemento | `lista.contains("Hola")` |
| `indexOf(Object o)` | Devuelve posición de elemento | `lista.indexOf("Hola")` |
| `clear()` | Elimina todos los elementos | `lista.clear()` |
| `isEmpty()` | Verifica si está vacía | `lista.isEmpty()` |
| `addAll(Collection c)` | Agrega todos los elementos de otra colección | `lista.addAll(otra)` |

### Tipos de Recorridos

#### 1. Bucle for tradicional (con índice)
```java
for (int i = 0; i < lista.size(); i++) {
    System.out.println(lista.get(i));
}
```

#### 2. Bucle for-each (mejorado)
```java
for (String elemento : lista) {
    System.out.println(elemento);
}
```

#### 3. Recorrido inverso
```java
for (int i = lista.size() - 1; i >= 0; i--) {
    System.out.println(lista.get(i));
}
```

---

## 💡 Consejos y Buenas Prácticas

### 1. Importar la clase
Siempre importar ArrayList al inicio del archivo:
```java
import java.util.ArrayList;
```

### 2. Especificar el tipo (Generics)
Usar `<TipoDato>` para indicar qué tipo de elementos contendrá:
```java
ArrayList<String> nombres = new ArrayList<>();  // ✓ Correcto
ArrayList lista = new ArrayList();              // ✗ Evitar (sin tipo)
```

### 3. Índices comienzan en 0
El primer elemento está en la posición 0, no en la 1:
```java
lista.get(0)  // Primer elemento
lista.get(lista.size() - 1)  // Último elemento
```

### 4. Evitar modificar durante recorrido for-each
```java
// ✗ Incorrecto - ConcurrentModificationException
for (String item : lista) {
    lista.remove(item);  // ERROR
}

// ✓ Correcto - usar bucle for tradicional inverso
for (int i = lista.size() - 1; i >= 0; i--) {
    lista.remove(i);
}
```

### 5. Comparar Strings correctamente
```java
// ✗ Evitar
if (texto == "Hola") { }

// ✓ Correcto
if (texto.equals("Hola")) { }

// ✓ Ignorar mayúsculas/minúsculas
if (texto.equalsIgnoreCase("Hola")) { }
```

---

## 🎯 Ejercicios Resueltos - Resumen

### Punto 1: Fundamentos
- Creación de ArrayList
- Métodos `add()` y `size()`
- Recorridos con `for` y `for-each`

### Punto 2: Manipulación
- Insertar con `add(index, elemento)`
- Modificar con `set(index, elemento)`
- Eliminar con `remove(index)`

### Punto 3: Búsqueda
- Verificar existencia con `contains()`
- Obtener posición con `indexOf()`

### Punto 4: Operaciones de Lista
- Combinar listas con `addAll()`
- Limpiar con `clear()`
- Verificar si está vacía con `isEmpty()`

### Punto 5: Filtrado
- Recorrido inverso
- Filtrado con condiciones (`if`)

### Punto 6: Sistema Completo
- Creación de clases personalizadas
- Gestión completa de objetos en ArrayList
- Ordenamiento con `Collections.sort()`
- Métodos organizados y reutilizables

---

## 🔍 Diferencias: ArrayList vs Array Tradicional

| Característica | Array (`String[]`) | ArrayList (`ArrayList<String>`) |
|----------------|--------------------|---------------------------------|
| Tamaño | Fijo | Dinámico |
| Sintaxis | `array[0]` | `lista.get(0)` |
| Agregar elementos | No se puede después de creado | `add()` |
| Tipos primitivos | Sí (`int[]`) | No (usar `Integer`, `Double`, etc.) |
| Rendimiento | Más rápido | Ligeramente más lento |
| Flexibilidad | Baja | Alta |

---

## 📝 Notas Adicionales

### Tipos de Datos con Generics

Para tipos primitivos, usar las clases wrapper:

```java
ArrayList<Integer> numeros = new ArrayList<>();    // para int
ArrayList<Double> decimales = new ArrayList<>();   // para double
ArrayList<Boolean> banderas = new ArrayList<>();   // para boolean
ArrayList<Character> letras = new ArrayList<>();   // para char
```

### Collections Framework

ArrayList es parte del **Java Collections Framework**, que incluye otras estructuras:

- **List**: ArrayList, LinkedList, Vector
- **Set**: HashSet, TreeSet, LinkedHashSet
- **Map**: HashMap, TreeMap, LinkedHashMap
- **Queue**: LinkedList, PriorityQueue

---

## ✅ Checklist de Aprendizaje

- [ ] Entiendo qué es un ArrayList y cómo se diferencia de un array
- [ ] Puedo crear un ArrayList con el tipo de dato correcto
- [ ] Sé agregar elementos con `add()`
- [ ] Puedo acceder a elementos con `get()`
- [ ] Sé modificar elementos con `set()`
- [ ] Puedo eliminar elementos con `remove()`
- [ ] Entiendo cómo recorrer con `for` y `for-each`
- [ ] Sé buscar elementos con `contains()` e `indexOf()`
- [ ] Puedo combinar listas con `addAll()`
- [ ] Entiendo cuándo usar cada tipo de recorrido

---

## 📖 Recursos Adicionales

- [Documentación oficial de ArrayList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html)
- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)

---

**Autor:** Estudiante de Ingeniería de Software Dual  
**Docente:** David Cano Baquero  
**Tema:** Manipulación de colecciones con ArrayList
