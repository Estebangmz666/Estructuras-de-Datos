package estebangmz666.pila;

public class Pila<T> {
    private Nodo<T> nodoPrimero;
    private int tamanio;

    public Pila() {
        this.nodoPrimero = null;
        this.tamanio = 0;
    }

    public void push(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (nodoPrimero == null) {
            nodoPrimero = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }
        tamanio++;
    }

    public T pop() {
        if (nodoPrimero == null) {
            return null;
        }
        Nodo<T> nodoAEliminar = nodoPrimero;
        nodoPrimero = nodoPrimero.getSiguiente();
        nodoAEliminar.setSiguiente(null);
        tamanio--;
        return nodoAEliminar.getValor();
    }

    public Object peek() {
        if (nodoPrimero == null) {
            return null;
        }
        return nodoPrimero.getValor();
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> nodoActual = nodoPrimero;
        while (nodoActual != null) {
            sb.append(nodoActual.getValor()).append(" -> ");
            nodoActual = nodoActual.getSiguiente();
        }
        sb.append("null");
        return sb.toString();
    }
}