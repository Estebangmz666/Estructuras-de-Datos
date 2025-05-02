package estebangmz666.preparcial_2.ej3;

public class Pila2Colas {
    private MyQueue q1 = new MyQueue();
    private MyQueue q2 = new MyQueue();

    public void push(int value) {
        q2.enqueue(value);

        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }

        MyQueue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) throw new RuntimeException("Stack is empty");
        return q1.dequeue();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int top() {
        if (q1.isEmpty()) throw new RuntimeException("Stack is empty");
        return q1.peek();
    }
}