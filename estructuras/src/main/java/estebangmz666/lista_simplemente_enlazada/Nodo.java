package estebangmz666.lista_simplemente_enlazada;

public class Nodo<T> {
    private Nodo<T> siguiente;
    private T valor;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}