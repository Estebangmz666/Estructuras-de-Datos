package estebangmz666.preparcial_1.trials;

import java.util.HashMap;
import java.util.Map;

public class trials {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        map.remove("B");
        map.put("D", 4);

        System.out.println(map.get("A")); 
        System.out.println(map.get("B"));  
        System.out.println(map.size());  
    }   
}