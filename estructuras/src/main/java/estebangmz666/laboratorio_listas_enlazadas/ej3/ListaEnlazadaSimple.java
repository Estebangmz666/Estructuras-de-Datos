package estebangmz666.laboratorio_listas_enlazadas.ej3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazadaSimple<T> implements Iterable<T> {

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;
    
        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    
        public T getDato() {
            return dato;
        }
    
        public void setDato(T dato) {
            this.dato = dato;
        }
    
        public Nodo<T> getSiguiente() {
            return siguiente;
        }
    
        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }
    }

    private int tamanio;
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;

    public ListaEnlazadaSimple() {
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
            nuevoNodo.setSiguiente(nodoActual.getSiguiente());
            nodoActual.setSiguiente(nuevoNodo);
            tamanio++;
        }
    }

    public void eliminarAlInicio() {
        if (tamanio == 0) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        }
        nodoPrimero = nodoPrimero.getSiguiente();
        if (tamanio == 1) {
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
            Nodo<T> nodoActual = nodoPrimero;
            while (nodoActual.getSiguiente() != nodoUltimo) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(null);
            nodoUltimo = nodoActual;
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
            for (int i = 0; i < indice - 1; i++) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
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
        return nodoActual.getDato();
    }

    public void actualizarPorIndice(int indice, T nuevoDato) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + indice);
        }
        Nodo<T> nodoActual = nodoPrimero;
        for (int i = 0; i < indice; i++) {
            nodoActual = nodoActual.getSiguiente();
        }
        nodoActual.setDato(nuevoDato);
    }

    public boolean contiene(T dato) {
        Nodo<T> nodoActual = nodoPrimero;
        while (nodoActual != null) {
            if ((dato == null && nodoActual.getDato() == null) || 
                (dato != null && dato.equals(nodoActual.getDato()))) {
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }    

    public void reversa() {
        if (tamanio <= 1) return;
        Nodo<T> prev = null;
        Nodo<T> current = nodoPrimero;
        nodoUltimo = nodoPrimero;
        while (current != null) {
            Nodo<T> next = current.getSiguiente();
            current.setSiguiente(prev);
            prev = current;
            current = next;
        }
        nodoPrimero = prev;
    }

    public ListaEnlazadaSimple<T> obtenerPosicionesImpares() {
        ListaEnlazadaSimple<T> resultado = new ListaEnlazadaSimple<>();
        Nodo<T> nodoActual = nodoPrimero;
        int indice = 0;
        while (nodoActual != null) {
            if (indice % 2 == 1) {
                resultado.agregarAlFinal(nodoActual.getDato());
            }
            nodoActual = nodoActual.getSiguiente();
            indice++;
        }
        
        return resultado;
    }

    /*public ListaEnlazadaSimple<Persona> obtenerPersonasConCedulaPar() {
        ListaEnlazadaSimple<Persona> resultado = new ListaEnlazadaSimple<>();
        Nodo<T> nodoActual = nodoPrimero;
        while (nodoActual != null) {
            Persona persona = (Persona) nodoActual.getDato();
            int longitud = persona.getCedula().length();
            System.out.println(persona.getNombre() + " - Cédula: " + persona.getCedula() + " - Longitud: " + longitud);
            if (longitud % 2 == 0) {
                resultado.agregarAlFinal(persona);
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return resultado;
    }*/

    public void eliminarNumerosPares() {
        while (nodoPrimero != null && (Integer) nodoPrimero.getDato() % 2 == 0) {
            nodoPrimero = nodoPrimero.getSiguiente();
            tamanio--;
        }
        if (nodoPrimero == null) {
            nodoUltimo = null;
            return;
        }
        Nodo<T> nodoActual = nodoPrimero;
        while (nodoActual.getSiguiente() != null) {
            if ((Integer) nodoActual.getSiguiente().getDato() % 2 == 0) {
                nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
                tamanio--;
            } else {
                nodoActual = nodoActual.getSiguiente();
            }
        }
        nodoUltimo = nodoActual;
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> nodoActual = nodoPrimero;
        while (nodoActual != null) {
            sb.append(nodoActual.getDato()).append(" -> ");
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
                T value = current.getDato();
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
}