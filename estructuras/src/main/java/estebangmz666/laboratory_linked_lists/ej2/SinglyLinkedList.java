package estebangmz666.laboratory_linked_lists.ej2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T> {

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

    public SinglyLinkedList() {
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
            throw new IndexOutOfBoundsException("Invalid index: " + index);
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
            throw new IndexOutOfBoundsException("The list is empty");
        }
        firstNode = firstNode.getNext();
        if (size == 1) {
            lastNode = null;
        }
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("The list is empty");
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

    public SinglyLinkedList<Person> getPeopleWithEvenLengthId(){
        SinglyLinkedList<Person> result = new SinglyLinkedList<>();
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            Person person = (Person) currentNode.getData();
            int length = person.getId().length();
            System.out.println(person.getName() + " - Cédula: " + person.getId() + " - Longitud: " + length);
            if (length % 2 == 0) {
                result.addLast(person);
            }
            currentNode = currentNode.getNext();
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