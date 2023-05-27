import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Iterate<Integer> array = new Iterate<>(10);
        array.add(2);
        array.add(21);
        array.add(13);
        array.add(1);
        array.add(0);
        array.add(22);
        array.add(9);

        array.delete(0);

        System.out.println("Array : ");
        for (Object number : array) {
            System.out.print(number+" ");
        }

        System.out.println("\n\nSorted array : ");
        sortArray(array);

    }

    public static void sortArray(Iterate<Integer> array) {

        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        Collections.sort(list);
        array = new Iterate<>();
        for (Integer value : list) {
            array.add(value);
        }

        System.out.println(array);
    }
}
