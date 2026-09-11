# Examen Parcial 1 — Estructuras de Datos

## "Tren de Carga"

> Debes resolver el ejercicio **reutilizando una de las estructuras de datos
> que implementaste en los laboratorios 01–05**. Parte de la nota depende de
> que **justifiques** por qué esa estructura es la adecuada (ver última
> sección).

---

## 1. Contexto

Una empresa ferroviaria arma trenes de carga **enganchando vagones sobre la
marcha**. Cada vagón transporta un tipo de carga (carbón, alimentos, ropa,
madera, …) y se identifica con un **código** de texto que describe esa carga,
por ejemplo `"Carbon"` o `"Alimentos"`. Dicho de otro
modo: el **objeto** que guarda cada nodo de tu estructura **es la carga que
transporta ese vagón**.

Un vagón se puede enganchar de tres formas distintas:

1. **Al frente del tren** (justo detrás de la locomotora).
2. **Al final del tren**.
3. **Inmediatamente después de un vagón que ya está enganchado.**

Y también se puede **desenganchar** (quitar) un vagón del tren, en cualquier
posición en la que esté.

Debes diseñar e implementar la estructura que gestiona el tren y un programa
que la use.

---

## 2. Qué debes entregar

1. El archivo **`Tren.java`** completado, dentro del proyecto del laboratorio
   (estructura) que elegiste, junto a los archivos de esa estructura (por
   ejemplo `MiLista.java`, `ListInterface.java`, `ListNode.java`).
2. La **justificación de la estructura elegida** como comentario al inicio de
   `Tren.java`.

### ¿Cómo entregarlo?

Un **link de GitHub**. Dos casos:

1. **Usaste tu propia estructura** (labs 01–05): el **mismo repo de esa
   estructura**, con **nuevos commits** que agregan `Tren.java` junto a sus
   archivos.
2. **Usaste una librería de Java** (`java.util.LinkedList`, `ArrayList`, …):
   un **repo nuevo llamado `parcial`** con `Tren.java`.

Si no alcanzas por el tiempo envia los archivos al moodle y después cargas el link.

---

## 3. El programa: menú interactivo

`Tren` es una clase **ejecutable** (tiene `main`). Al correr, muestra un menú
en un bucle hasta que se elige `0. Salir`:

```
===== TREN DE CARGA =====
1. Enganchar vagon en la cabeza
2. Enganchar vagon en la cola
3. Enganchar vagon despues de otro
4. Desenganchar un vagon
5. Ver estado del tren
0. Salir
Opcion:
```

### Opción 1 — Enganchar vagón en la cabeza

Pide `Codigo del vagon` y lo engancha **al frente** del tren. **No produce
salida.** Si el código está vacío, el vagón **no se engancha** y se imprime:

```
ENTRADA_INVALIDA
```

### Opción 2 — Enganchar vagón en la cola

Pide `Codigo del vagon` y lo engancha **al final** del tren. **No produce
salida.** Código vacío ⇒ igual que arriba, `ENTRADA_INVALIDA` y no se
engancha.

### Opción 3 — Enganchar vagón después de otro

Pide `Codigo del vagon existente` (después de cuál se engancha) y
`Codigo del nuevo vagon`.

- Si `Codigo del nuevo vagon` está vacío: **no se engancha nada** y se
  imprime `ENTRADA_INVALIDA` (esta validación tiene prioridad sobre la
  siguiente).
- Si no, y el vagón existente **no está** en el tren: **no se engancha nada**
  y se imprime:
  ```
  VAGON_NO_ENCONTRADO
  ```
- Si el vagón existente **sí está**: se engancha el nuevo vagón justo después
  y **no produce salida**.

### Opción 4 — Desenganchar un vagón

Pide `Codigo del vagon a desenganchar` y lo **quita** del tren, sin importar
en qué posición esté (cabeza, cola o en medio).

- Si el código está vacío: **no se quita nada** y se imprime
  `ENTRADA_INVALIDA`.
- Si el vagón **no está** en el tren: **no se quita nada** y se imprime
  `VAGON_NO_ENCONTRADO`.
- Si el vagón **sí está**: se quita y **no produce salida**.

### Opción 5 — Ver estado del tren

Lista los vagones **en orden, de la cabeza a la cola**:

- Con vagones: `TREN: <codigo1> -> <codigo2> -> ...`
- Sin vagones: `TREN_VACIO`

### Opción 0 — Salir

Termina el programa.

---

## 4. Contrato de salida (exacto)

Respeta **mayúsculas, espacios y el separador `->`**. Diferencias de formato
se consideran incorrectas.

| Situación                                          | Salida exacta         |
| --------------------------------------------------- | ---------------------- |
| Estado con vagones                                  | `TREN: carbon1 -> ropa1` |
| Estado sin vagones                                  | `TREN_VACIO`           |
| Código vacío (opciones 1, 2, 3 o 4)                 | `ENTRADA_INVALIDA`     |
| Enganchar después de o desenganchar un vagón inexistente | `VAGON_NO_ENCONTRADO` |

Observa: en el estado, los códigos se separan con una flecha `->` rodeada de
un espacio a cada lado (`" -> "`), sin coma y sin paréntesis. El código de un
vagón puede tener espacios (p. ej. `carbon1`): se compara tal cual,
sin recortar nada salvo los espacios de más al principio/final que deja el
usuario al escribirlo.

---

## 5. Ejemplo de sesión

Lo que teclea el usuario aparece después de `Opcion:`, `Codigo del vagon:`,
`Codigo del vagon existente:`, `Codigo del nuevo vagon:` y
`Codigo del vagon a desenganchar:`. Se omiten las repeticiones del menú para
abreviar.

```
Opcion: 2
Codigo del vagon: carbon1

Opcion: 1
Codigo del vagon: alimentos1

Opcion: 3
Codigo del vagon existente: alimentos1
Codigo del nuevo vagon: ropa1

Opcion: 2
Codigo del vagon: carbon2

Opcion: 5
TREN: alimentos1 -> ropa1 -> carbon1 -> carbon2

Opcion: 4
Codigo del vagon a desenganchar: ropa1

Opcion: 5
TREN: alimentos1 -> carbon1 -> carbon2

Opcion: 3
Codigo del vagon existente: acero1
Codigo del nuevo vagon: madera1
VAGON_NO_ENCONTRADO

Opcion: 5
TREN: alimentos1 -> carbon1 -> carbon2

Opcion: 0
```

`carbon1` entra a un tren vacío (queda solo). `alimentos1`
se engancha en la cabeza, delante de él. `ropa1` se engancha después
de `alimentos1`. `carbon2` se engancha en la cola.
Desenganchar `ropa1` lo quita de en medio del tren. Intentar
enganchar después de `acero1` (que no existe) no cambia el tren.

---

## 6. Cómo trabajar

1. **Elige la estructura de datos** (uno de tus 5 laboratorios) que consideres
   más adecuada para este problema.
2. **Copia `Tren.java`** dentro de `src/main/java/` del proyecto de esa
   estructura, junto a sus archivos.
3. **Completa los `TODO`** de `Tren.java`:
   - declara el atributo con tu estructura,
   - implementa `engancharCabeza(...)`, `engancharCola(...)`,
     `engancharDespuesDe(...)`, `desengancharVagon(...)` y `estado()`.
   - Cada vagón se guarda **directamente como el código** (un `String`, p. ej.
     `"carbon1"`): a diferencia de otros ejercicios, aquí **no hace
     falta empaquetar varios datos en un solo texto**.
4. **Ejecuta** `Tren` desde tu IDE (Run → `main`).
5. Prueba con el **ejemplo de sesión** de la sección 5 y con tus propios
   casos. Asegúrate de que la salida sea **exacta**.

---

## 7. Restricciones

- El tren **debe almacenarse en tu estructura de datos**.
- Debes usar explícitamente los métodos de tu estructura para **insertar en
  la cabeza**, **insertar en la cola**, **insertar después de un dato dado**
  y **eliminar un dato dado** (las cuatro operaciones del menú).
- Se permite el uso de `ArrayList`, `LinkedList`, arreglos redimensionables de
  la librería estándar, etc. En caso que su ED no esté terminada o no
  funcione bien, pero será penalizado en la rúbrica.
- **Sí** se permiten: `Scanner`, `System.out`, `String` y tipos primitivos.

---

## 8. Justificación de la estructura de datos elegida

> Justifica tu elección en el comentario al inicio de `Tren.java`.
> Se evalúa la calidad del razonamiento, no solo la elección.

**Estructura elegida:**
_(p. ej. lista simplemente enlazada, lista doblemente enlazada, lista
circular, …)_

**Laboratorio de origen:** _( 01 / 02 / 03 / 04 / 05 )_

**¿Por qué esta estructura y no otra?** _(mínimo 3 líneas)_

Apóyate en estas preguntas:

- ¿Cuál es el costo de insertar en la **cabeza** con tu estructura? ¿Y de
  insertar en la **cola**? ¿Por qué pueden ser distintos?
- ¿Cuál es el costo de **enganchar después de un vagón dado** y de
  **desenganchar un vagón dado**? ¿De qué depende (posición del vagón de
  referencia)?
- Si el tren tuviera que enganchar y desenganchar **muy seguido cerca de la
  cola**, ¿seguirías usando esta misma estructura sin cambios? ¿Qué harías
  distinto?
- ¿Qué desventaja aceptas al elegir esta estructura y por qué es tolerable en
  este escenario?

---

## 9. Criterios de evaluación (rúbrica)

| Criterio                                                                                                | Peso |
| --------------------------------------------------------------------------------------------------------- | :--: |
| Correctitud de las 4 operaciones y del contrato de salida (incluyendo el manejo de casos borde)            | 50 % |
| Uso correcto y coherente de su propia estructura de datos (implementación propia, no librería externa)     | 40 % |
| Justificación de la estructura                                                                              | 10 % |

Si hace todo perfecto pero utiliza una estructura de datos no propia (librería
externa) completa el 60% de la nota, es decir, la nota máxima será 3.
