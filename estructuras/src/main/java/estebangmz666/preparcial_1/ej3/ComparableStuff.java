package estebangmz666.preparcial_1.ej3;

public class ComparableStuff<T extends Comparable<T>> {
    private T stuff;

    public ComparableStuff(T stuff) {
        this.stuff = stuff;
    }

    public T getStuff() {
        return stuff;
    }

    public void setStuff(T stuff) {
        this.stuff = stuff;
    }

    public boolean isGreaterThan(ComparableStuff<T> otherStuff) {
        return this.stuff.compareTo(otherStuff.getStuff()) > 0;
    }

    public boolean isLessThan(ComparableStuff<T> otherStuff) {
        return this.stuff.compareTo(otherStuff.getStuff()) < 0;
    }

    public boolean isEqualTo(ComparableStuff<T> otherStuff) {
        return this.stuff.compareTo(otherStuff.getStuff()) == 0;
    }
}