package estebangmz666.laboratory_linked_lists.ej1;

public class Main {
    public static void main(String[] args) {
    SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);
    list.addFirst(5);
    list.addFirst(6);
    SimpleLinkedList<Integer> odd = list.getOddIndexPositions();
    System.out.println(odd);   
    }
}