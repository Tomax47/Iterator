import java.util.Iterator;

public class Iterate<T> implements Iterable<T> {

    private int size;
    private int capacity = 10;
    private T[] array;

    public Iterate() {
        this.array = (T[]) new Object[capacity];
    }

    protected Iterate(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (size >= capacity) {
            expandTheSizeOfArray();
        }
        array[size] = data;
        size++;
    }
    private void shrink() {
        int newCapacity = (capacity / 2);
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public void insert(int index, T data) {
        if (size >= capacity) {
            expandTheSizeOfArray();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = data;
        size++;
    }

    public void delete(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                for (int j = 0; j < (size - i - 1); j++) {
                    array[i + j] = array[i + j + 1];
                }
                array[size - 1] = null;
                size--;
                if (size <= (int) (capacity / 3)) {
                    shrink();
                }
                break;
            }
        }
    }

    private void expandTheSizeOfArray() {
        int newCapacity = capacity * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        capacity = newCapacity;
        array = newArray;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new IterateClass<>(0, size, array);
    }
}
