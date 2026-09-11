/* =====================================================================
 *  EXAMEN PARCIAL 1 - ESTRUCTURAS DE DATOS
 *  "Tren de Carga"
 *
 *  INSTRUCCIONES
 *  1. Copia este archivo dentro de "src/" del proyecto de Java
 *     de la estructura de datos que elegiste (uno de tus 5 laboratorios),
 *     junto a sus archivos (por ejemplo MiLista.java, ListInterface.java,
 *     ListNode.java).
 *  2. Completa TODOS los bloques marcados con el comentario // TODO
 *  3. Ejecuta la clase Tren (metodo main) desde tu IDE.
 *
 *  RESTRICCIÓN: el tren debe almacenarse en TU estructura de datos y sus
 *  métodos implementados (insertar en la cabeza, insertar en la cola,
 *  insertar despues de un dato dado y eliminar un dato dado).
 *  Se permite el uso de ArrayList, LinkedList, arreglos redimensionables
 *  de la libreria estandar, etc. En caso que su ED no esté terminada o
 *  no funcione bien, pero se califica sobre 3.0.
 *  Si se permite: Scanner, System.out, String y tipos primitivos.
 * =====================================================================
 *
 *  JUSTIFICACION DE LA ESTRUCTURA DE DATOS ELEGIDA
 *  (rellena aqui o en el archivo .md del enunciado)
 *
 *  Estructura elegida Lista Simplemente Enlazada :
 *  Laboratorio de origen 01 :  ( 01 / 02 / 03 / 04 / 05 )
 *
 *  Por que esta estructura y no otra?
 *  -Escogi esta estructura por que no nos dan un tren el cual esta enazado de forma lineal.
 *  -No es una lista circular pq no nos piden un bucle.
 *  -No es una pila pq en el tren puede salir tanto el ultimo como el primero.
 *  -No es cola pq no solo nos dan la cola si no tambien la cabeza que es la locomotora
 *  -No escogi lista doble pq es mas facil trabajar con lista simple y no tener que hacer mayor trabajo
 *  -Escogi lista simple pq aqui sacar, agregar , eliminar datos es mas facil que en las otras estructuras
 *
 * ===================================================================== */

import java.util.Scanner;

public class Tren {

    // =================================================================
    // COMO SE REPRESENTA UN VAGON
    //
    // Cada vagon se guarda DIRECTAMENTE como su codigo, un TEXTO que
    // describe la carga que transporta:
    //
    //        "carbon1"      "alimentos1"
    //
    // A diferencia de otros ejercicios, aqui no hace falta empaquetar
    // varios datos en un solo texto: el codigo ES el dato que guardas
    // en cada nodo de tu estructura.
    // =================================================================

    // =================================================================
    // PASO 1 - Conecta AQUI tu estructura de datos.
    // TODO:
    // Descomenta / adapta UNA de estas lineas segun tu laboratorio.
    // El tren vive dentro de esta estructura y cada elemento que
    // guardes en ella es un String con el codigo del vagon.
    //
       MiLista         tren = new MiLista();          // Lab 01 - Lista simple
    //   MiListaDoble    tren = new MiListaDoble();     // Lab 02 - Lista doble
    //   MiListaCircular tren = new MiListaCircular();  // Lab 03 - Lista circular
    //   ListStack       tren = new ListStack();        // Lab 04 - Pila
    //   Queue           tren = new Queue();            // Lab 05 - Cola
    //
    // -----------------------------------------------------------------
    // OPERACION 1 - Enganchar vagon en la cabeza  (no produce salida)
    // -----------------------------------------------------------------
    public void engancharCabeza(String codigo) {
        // TODO: inserta 'codigo' en la CABEZA de tu estructura de datos.
        tren.insertHead(codigo);
    }

    // -----------------------------------------------------------------
    // OPERACION 2 - Enganchar vagon en la cola  (no produce salida)
    // -----------------------------------------------------------------
    public void engancharCola(String codigo) {
        // TODO: inserta 'codigo' en la COLA de tu estructura de datos.
        tren.insertTail(codigo);
    }

    // -----------------------------------------------------------------
    // OPERACION 3 - Enganchar vagon despues de otro
    //   Devuelve true  si 'codigoExistente' esta en el tren (y ya quedo
    //                  enganchado 'codigoNuevo' justo despues).
    //   Devuelve false si 'codigoExistente' NO esta en el tren (no se
    //                  engancha nada).
    // -----------------------------------------------------------------
    public boolean engancharDespuesDe(String codigoExistente, String codigoNuevo) {
        // TODO: busca 'codigoExistente' en tu estructura e inserta
        // 'codigoNuevo' justo despues. Si no lo encuentras, no insertes
        // nada y devuelve false.
        return tren.insert(codigoExistente, codigoNuevo);
    }

    // -----------------------------------------------------------------
    // OPERACION 4 - Desenganchar un vagon  (lo retira de donde este)
    //   Devuelve true  si 'codigo' estaba en el tren (y ya se quito).
    //   Devuelve false si 'codigo' NO estaba en el tren.
    // -----------------------------------------------------------------
    public boolean desengancharVagon(String codigo) {
        // TODO: busca 'codigo' en tu estructura (cabeza, cola o en
        // medio) y retiralo. Si no lo encuentras, devuelve false.
        ListNode Newcodigo=tren.searchN(codigo) ;
        return  tren.remove(Newcodigo);
    }

    // -----------------------------------------------------------------
    // OPERACION 5 - Ver estado del tren
    //   Con vagones:  TREN: <codigo1> -> <codigo2> -> ...
    //   Sin vagones:  TREN_VACIO
    //   El orden debe ir de la CABEZA a la COLA.
    // -----------------------------------------------------------------
    public String estado() {
        // TODO:
        // 1. Si el tren esta vacio -> return "TREN_VACIO";
        // 2. Recorre los vagones EN ORDEN (cabeza -> cola) y arma el texto
        //    con el prefijo "TREN: " y cada codigo separado por " -> ".
        tren.isEmpty();
        return "TREN_VACIO"; // <-- placeholder, reemplazalo

    }

    // =================================================================
    // Bucle de menu. NO deberias necesitar cambiar nada de aqui abajo,
    // salvo que quieras mejorar los mensajes.
    // =================================================================
    public static void main(String[] args) {
        Tren sistema = new Tren();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println();
            System.out.println("===== TREN DE CARGA =====");
            System.out.println("1. Enganchar vagon en la cabeza");
            System.out.println("2. Enganchar vagon en la cola");
            System.out.println("3. Enganchar vagon despues de otro");
            System.out.println("4. Desenganchar un vagon");
            System.out.println("5. Ver estado del tren");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            String opcion = sc.hasNextLine() ? sc.nextLine().trim() : "0";

            switch (opcion) {
                case "1": {
                    System.out.print("Codigo del vagon: ");
                    String codigo = sc.hasNextLine() ? sc.nextLine().trim() : "";
                    if (codigo.isEmpty()) {
                        System.out.println("ENTRADA_INVALIDA");
                        break;
                    }
                    sistema.engancharCabeza(codigo);
                    break;
                }
                case "2": {
                    System.out.print("Codigo del vagon: ");
                    String codigo = sc.hasNextLine() ? sc.nextLine().trim() : "";
                    if (codigo.isEmpty()) {
                        System.out.println("ENTRADA_INVALIDA");
                        break;
                    }
                    sistema.engancharCola(codigo);
                    break;
                }
                case "3": {
                    System.out.print("Codigo del vagon existente: ");
                    String existente = sc.hasNextLine() ? sc.nextLine().trim() : "";
                    System.out.print("Codigo del nuevo vagon: ");
                    String nuevo = sc.hasNextLine() ? sc.nextLine().trim() : "";

                    if (nuevo.isEmpty()) {
                        System.out.println("ENTRADA_INVALIDA");
                        break;
                    }
                    boolean encontrado = sistema.engancharDespuesDe(existente, nuevo);
                    if (!encontrado) {
                        System.out.println("VAGON_NO_ENCONTRADO");
                    }
                    break;
                }
                case "4": {
                    System.out.print("Codigo del vagon a desenganchar: ");
                    String codigo = sc.hasNextLine() ? sc.nextLine().trim() : "";
                    if (codigo.isEmpty()) {
                        System.out.println("ENTRADA_INVALIDA");
                        break;
                    }
                    boolean encontrado = sistema.desengancharVagon(codigo);
                    if (!encontrado) {
                        System.out.println("VAGON_NO_ENCONTRADO");
                    }
                    break;
                }
                case "5":
                    System.out.println(sistema.estado());
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println("OPCION_INVALIDA");
            }
        }

        sc.close();
    }
}
