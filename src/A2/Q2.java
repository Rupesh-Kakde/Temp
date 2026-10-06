import java.util.*;


class EnumerationAdapter implements Iterator<String> {

    private Enumeration<String> enumeration;

    public EnumerationAdapter(Enumeration<String> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public String next() {
        return enumeration.nextElement();
    }
}

public class Q2 {
    public static void main(String[] args) {

        Vector<String> list = new Vector<>();

        list.add("Java");
        list.add("Python");
        list.add("C++");

        Enumeration<String> enumeration = list.elements();

        Iterator<String> iterator = new EnumerationAdapter(enumeration);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
