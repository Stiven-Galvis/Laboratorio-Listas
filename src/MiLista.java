import java.util.Iterator;

public class MiLista implements ListInterface {
    ListNode cabeza;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        ListNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
            contador = contador + 1;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;

    }

    @Override
    public Object getHead() {

        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (isEmpty()) {//0 si head==null
            return null;

        }
        ListNode tail = this.cabeza;
        //ciclo
        while (tail.siguiente != null) {
            tail = tail.siguiente;
        }
        return tail.dato;
    }

    @Override
    public Object get(ListNode node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public Object search(Object object) {
        if (isEmpty() || object == null) {
            return null;
        }

        ListNode actual = this.cabeza;
        while (actual != null) {
            if (actual.dato != null && actual.dato.equals(object)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    @Override
    public boolean add(Object object) {
        ListNode nuevo = new ListNode(object);
        if (isEmpty()) {
            this.cabeza = nuevo;
        } else {
            ListNode actual = this.cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        return true;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        if (node == null) {
            return false;
        }
        ListNode nuevo = new ListNode(object);
        nuevo.siguiente = node.siguiente;
        node.siguiente = nuevo;
        return true;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        if (isEmpty() || ob == null) {
            return false;
        }
        ListNode actual = this.cabeza;
        while (actual != null) {
            if (actual.dato != null && actual.dato.equals(ob)) {
                return insert(actual, object);
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if (this.cabeza == null) {
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        } else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(ListNode node) {
        if (isEmpty() || node == null) {
            return false;
        }

        if (this.cabeza == node) {
            this.cabeza = this.cabeza.siguiente;
            return true;
        }

        ListNode actual = this.cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente == node) {
                actual.siguiente = node.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    @Override
    public boolean contains(Object object) {
        if (isEmpty() || object == null) {
            return false;
        }

        ListNode actual = this.cabeza;
        while (actual != null) {
            if (actual.dato != null && actual.dato.equals(object)) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }
    @Override
    public Object[] toArray() {
        int tamano = 0;
        ListNode actual = this.cabeza;
        while (actual != null) {
            tamano++;
            actual = actual.siguiente;
        }

        Object[] arreglo = new Object[tamano];
        actual = this.cabeza;
        int i = 0;
        while (actual != null) {
            arreglo[i++] = actual.dato;
            actual = actual.siguiente;
        }

        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        Object[] arregloDatos = toArray();
        if (object.length < arregloDatos.length) {
            return arregloDatos;
        }

        System.arraycopy(arregloDatos, 0, object, 0, arregloDatos.length);
        if (object.length > arregloDatos.length) {
            object[arregloDatos.length] = null;
        }

        return object;
    }

    @Override
    public Object getBeforeTo() {
        if (isEmpty() || this.cabeza.siguiente == null) {
            return null;
        }

        ListNode actual = this.cabeza;
        while (actual.siguiente != null && actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }
    @Override
    public Object getNextTo() {
        if (isEmpty() || this.cabeza.siguiente == null) {
            return null;
        }
        return this.cabeza.siguiente.dato;
    }
    @Override
    public MiLista subList(ListNode from, ListNode to) {
        MiLista sub = new MiLista();
        if (isEmpty() || from == null) {
            return sub;
        }

        ListNode actual = from;
        while (actual != null) {
            sub.add(actual.dato);
            if (actual == to) {
                break;
            }
            actual = actual.siguiente;
        }
        return sub;
    }

    @Override
    public MiLista sortList() {
        if (isEmpty()) {
            return this;
        }

        Object[] arreglo = toArray();

        int[] arregloInt = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] instanceof Integer) {
                arregloInt[i] = (Integer) arreglo[i];
            }
        }

        java.util.Arrays.sort(arregloInt);

        MiLista listaOrdenada = new MiLista();
        for (int val : arregloInt) {
            listaOrdenada.add(val);
        }

        return listaOrdenada;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "MiLista[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("MiLista[");
        ListNode actual = this.cabeza;

        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }

        sb.append("]");
        return sb.toString();
    }
}