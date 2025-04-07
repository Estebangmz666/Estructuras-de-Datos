package estebangmz666.laboratory_linked_lists.ej13;

public class Lista {
    NodoLista inicio = null;

    public void insertar(int x) {
        inicio = new NodoLista(x, inicio);
    }

    public int maximaDistancia(int clave) {
        return maximaDistanciaRec(inicio, clave, -1, 0, 0);
    }

    private int maximaDistanciaRec(NodoLista nodo, int clave, int firstIndex, int currentIndex, int maxDistance) {
        if (nodo == null) return maxDistance;

        if (nodo.dato == clave) {
            if (firstIndex == -1) {
                return maximaDistanciaRec(nodo.sig, clave, currentIndex, currentIndex + 1, maxDistance);
            } else {
                int dist = currentIndex - firstIndex;
                if (dist > maxDistance) {
                    maxDistance = dist;
                }
            }
        }
        return maximaDistanciaRec(nodo.sig, clave, firstIndex, currentIndex + 1, maxDistance);
    }
}