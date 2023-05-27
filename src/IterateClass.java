import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterateClass<T> implements Iterator<T> {
    private int currentIndex = 0;
    int size;
    T[] array;

    public IterateClass(int currentIndex, int size, T[] array) {
        this.currentIndex = currentIndex;
        this.size = size;
        this.array = array;
    }

    public IterateClass(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public T next() {
        if (hasNext()) {
            T element = array[currentIndex];
            currentIndex++;
            return element;
        } else {
            throw new NoSuchElementException("Empty array!");
        }
    }

    public void increaseSize(int newSize) {
        if (newSize <= size) {
            throw new IllegalArgumentException("The provided size aint bigger than the current!");
        } else {
            size = newSize;
        }
    }
}