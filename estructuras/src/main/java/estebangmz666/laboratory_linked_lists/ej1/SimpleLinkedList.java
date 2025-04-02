package estebangmz666.laboratory_linked_lists.ej1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> implements Iterable<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;
    
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    
        public T getData() {
            return data;
        }
    
        public void setData(T data) {
            this.data = data;
        }
    
        public Node<T> getNext() {
            return next;
        }
    
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public SimpleLinkedList() {
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (size == 0) {
            firstNode = lastNode = newNode;
        } else {
            newNode.setNext(firstNode);
            firstNode = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (size == 0) {
            firstNode = lastNode = newNode;
        } else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        size++;
    }

    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + index);
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            size++;
        }
    }

    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        }
        firstNode = firstNode.getNext();
        if (size == 1) {
            lastNode = null;
        }
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        } else if (size == 1) {
            firstNode = lastNode = null;
        } else {
            Node<T> currentNode = firstNode;
            while (currentNode.getNext() != lastNode) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            lastNode = currentNode;
        }
        size--;
    }    

    public void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + index);
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
            size--;
        }
    }

    public T getAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + index);
        }
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public void updateAtIndex(int index, T newData) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("El índice no es válido: " + index);
        }
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setData(newData);
    }

    public boolean contains(T data) {
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            if ((data == null && currentNode.getData() == null) || 
                (data != null && data.equals(currentNode.getData()))) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }    

    public void reverse() {
        if (size <= 1) return;
        Node<T> prev = null;
        Node<T> current = firstNode;
        lastNode = firstNode;
        while (current != null) {
            Node<T> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        firstNode = prev;
    }

    public SimpleLinkedList<T> getOddIndexPositions() {
        SimpleLinkedList<T> result = new SimpleLinkedList<>();
        Node<T> currentNode = firstNode;
        int index = 0;
        while (currentNode != null) {
            if (index % 2 == 1) {
                result.addLast(currentNode.getData());
            }
            currentNode = currentNode.getNext();
            index++;
        }
        return result;
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            sb.append(currentNode.getData()).append(" -> ");
            currentNode = currentNode.getNext();
        }
        sb.append("null");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = firstNode;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.getData();
                current = current.getNext();
                return value;
            }
        };
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }   
}