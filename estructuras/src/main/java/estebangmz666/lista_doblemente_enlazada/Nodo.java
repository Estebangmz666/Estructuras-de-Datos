package estebangmz666.lista_doblemente_enlazada;

public class Nodo<T> {
    private Nodo<T> siguiente;
    private Nodo<T> anterior;
    private T valor;

    public Nodo(T valor) {
        this.valor = valor;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}