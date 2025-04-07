package estebangmz666.laboratory_linked_lists.ej2;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Person> list = new SinglyLinkedList<>();
        list.addFirst(new Person("Juan", "123456789"));
        list.addFirst(new Person("Maria", "987654321"));
        list.addFirst(new Person("Pedro", "456789123"));
        list.addLast(new Person("Ana", "321654987"));
        list.addLast(new Person("Luis", "65432178")); // ID with even length
        list.addLast(new Person("Sofia", "78912345")); // ID with even length

        System.out.println("Original list: " + list);
        SinglyLinkedList<Person> result = list.getPeopleWithEvenLengthId();
        System.out.println("People with even-length ID: " + result);
    }
}