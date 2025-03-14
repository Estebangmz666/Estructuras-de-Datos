package estebangmz666.preparcial_1.ej5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(ListReverter.revertList(numbers)); // [5, 4, 3, 2, 1]

        List<String> words = Arrays.asList("uno", "dos", "tres");
        System.out.println(ListReverter.revertList(words)); // [tres, dos, uno]
    }
}