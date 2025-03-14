package estebangmz666.preparcial_1.ej2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> list1 = Arrays.asList("Hola, ", "como ", "estas?");
        List<Object> list2 = Arrays.asList(1, 0 , 1, 0, 1, 1);
        System.out.println(GenericLinkedList.mergeLists(list1, list2));
    }       
}