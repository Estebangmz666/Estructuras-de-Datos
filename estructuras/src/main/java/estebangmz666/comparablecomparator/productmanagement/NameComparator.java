package estebangmz666.comparablecomparator.productmanagement;

import java.util.Comparator;

public class NameComparator implements Comparator<Product> {
    
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}