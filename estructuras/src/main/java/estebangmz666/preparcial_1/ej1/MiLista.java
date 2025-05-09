package estebangmz666.preparcial_1.ej1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MiLista {
    private String[] lista;
    public MiLista(String[] elementos) {
        this.lista = elementos;
    }
    
    public Iterator<String> iteradorPares() {
        return new IteradorPares();
    }

    private class IteradorPares implements Iterator<String> {
        private int indice;

        public IteradorPares() {
            this.indice = 0;
        }

        @Override
        public boolean hasNext() {
            return indice < lista.length;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String elemento = lista[indice];
            indice += 2;
            return elemento;
        }
    }

    public void mostrarConPares() {
        Iterator<String> it = iteradorPares();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        String[] elementos = {"a", "b", "c", "d", "e", "f", "g"};
        MiLista miLista = new MiLista(elementos);
        miLista.mostrarConPares();
    }
}