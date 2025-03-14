package estebangmz666.preparcial_1.ej3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ComparableStuff<Integer> stuff1 = new ComparableStuff<>(5);
        ComparableStuff<Integer> stuff2 = new ComparableStuff<>(10);
        ComparableStuff<Integer> stuff3 = new ComparableStuff<>(5);

        System.out.println(stuff1.isGreaterThan(stuff2));
        System.out.println(stuff1.isLessThan(stuff2));
        System.out.println(stuff1.isEqualTo(stuff3));

        List<Integer> numbers = Arrays.asList(3, 7, 2, 9, 5);
        System.out.println("El número máximo es: " + ComparableList.findMax(numbers)); // 9

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        System.out.println("La palabra máxima es: " + ComparableList.findMax(words)); // cherry
    }   
}