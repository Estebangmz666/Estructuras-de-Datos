package estebangmz666.preparcial_1.ej11;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList{
    String [] words;

    public MyList(String[] words){
        this.words = words;
    }

    public Iterator<String> evenIterator(){
        return new EvenIterator();
    }

    private class EvenIterator implements Iterator<String>{


        private Integer index;

        public EvenIterator(){
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < words.length;
        }

        @Override
        public String next() {
            if(!hasNext()){
                throw new NoSuchElementException("No more elements");
            } else{
                String word = words[index];
                index += 2;
                return word;
            }
        }
    }

    public void showEven(){
        while (evenIterator().hasNext()){
            System.out.println(evenIterator().next());
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "c", "d", "e", "f", "g"};
        MyList myList = new MyList(words);
        myList.showEven();
    }
}