package estebangmz666.lista_doblemente_enlazada;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazadaDoble<T> implements Iterable<T> {
    private int tamanio;
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    
    public ListaEnlazadaDoble() {
        this.tamanio = 0;
        this.nodoPrimero = null;
        this.nodoUltimo = null;
    }

    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (tamanio == 0) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(nodoPrimero);
            nodoPrimero.setAnterior(nuevoNodo);
            nodoPrimero = nuevoNodo;
        }
        tamanio++;
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (tamanio == 0) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nodoUltimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(nodoUltimo);
            nodoUltimo = nuevoNodo;
        }
        tamanio++;
    }

    public void agregarConIndice(T dato, int indice) {
        if (indice < 0 || indice > tamanio) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + indice);
        }
        if (indice == 0) {
            agregarAlInicio(dato);
        } else if (indice == tamanio) {
            agregarAlFinal(dato);
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(dato);
            Nodo<T> nodoActual = nodoPrimero;
            for (int i = 0; i < indice - 1; i++) {
                nodoActual = nodoActual.getSiguiente();
            }
            Nodo<T> siguienteNodo = nodoActual.getSiguiente();
            nuevoNodo.setSiguiente(siguienteNodo);
            nuevoNodo.setAnterior(nodoActual);
            nodoActual.setSiguiente(nuevoNodo);
            if (siguienteNodo != null) {
                siguienteNodo.setAnterior(nuevoNodo);
            }
            tamanio++;
        }
    }

    public void eliminarAlInicio() {
        if (tamanio == 0) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        }
        nodoPrimero = nodoPrimero.getSiguiente();
        if (nodoPrimero != null) {
            nodoPrimero.setAnterior(null);
        } else {
            nodoUltimo = null;
        }
        tamanio--;
    }

    public void eliminarAlFinal() {
        if (tamanio == 0) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        } else if (tamanio == 1) {
            nodoPrimero = nodoUltimo = null;
        } else {
            nodoUltimo = nodoUltimo.getAnterior();
            nodoUltimo.setSiguiente(null);
        }
        tamanio--;
    }

    public void eliminarPorIndice(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + indice);
        }
        if (indice == 0) {
            eliminarAlInicio();
        } else if (indice == tamanio - 1) {
            eliminarAlFinal();
        } else {
            Nodo<T> nodoActual = nodoPrimero;
            for (int i = 0; i < indice; i++) {
                nodoActual = nodoActual.getSiguiente();
            }
            Nodo<T> anterior = nodoActual.getAnterior();
            Nodo<T> siguiente = nodoActual.getSiguiente();
            anterior.setSiguiente(siguiente);
            if (siguiente != null) {
                siguiente.setAnterior(anterior);
            }
            tamanio--;
        }
    }
    
    public T obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + indice);
        }
        Nodo<T> nodoActual = nodoPrimero;
        for (int i = 0; i < indice; i++) {
            nodoActual = nodoActual.getSiguiente();
        }
        return nodoActual.getValor();
    }
    
    public void actualizarPorIndice(int indice, T nuevoDato) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + indice);
        }
        Nodo<T> nodoActual = nodoPrimero;
        for (int i = 0; i < indice; i++) {
            nodoActual = nodoActual.getSiguiente();
        }
        nodoActual.setValor(nuevoDato);
    }
    
    public boolean contiene(T dato) {
        Nodo<T> nodoActual = nodoPrimero;
        while (nodoActual != null) {
            if (nodoActual.getValor().equals(dato)) {
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }
    
    public void reversa() {
        Nodo<T> actual = nodoPrimero;
        Nodo<T> temp = null;
        while (actual != null) {
            temp = actual.getAnterior();
            actual.setAnterior(actual.getSiguiente());
            actual.setSiguiente(temp);
            actual = actual.getAnterior();
        }
        if (temp != null) {
            nodoUltimo = nodoPrimero;
            nodoPrimero = temp.getAnterior();
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> nodoActual = nodoPrimero;
        while (nodoActual != null) {
            sb.append(nodoActual.getValor()).append(" <-> ");
            nodoActual = nodoActual.getSiguiente();
        }
        sb.append("null");
        return sb.toString();
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> current = nodoPrimero;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.getValor();
                current = current.getSiguiente();
                return value;
            }
        };
    }
    
    public int getTamanio() {
        return tamanio;
    }

    public void limpiar() {
        nodoPrimero = nodoUltimo = null;
        tamanio = 0;
    }
    
    public static void main(String[] args) {}
}