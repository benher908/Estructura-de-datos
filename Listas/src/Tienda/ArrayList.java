package Tienda;
import java.util.Arrays;
public class ArrayList<T> {
    protected static final int DEFAULT_CAPACITY = 50;
    protected T[] list;
    protected int rear;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY]; // Cambiado a Comparable
        rear = 0;
    }

    protected void expandCapacity() {
        list = Arrays.copyOf(list, list.length * 2);
    }

    public boolean isEmpty() {
        return rear == 0;
    }

    public int size() {
        return rear;
    }

    public void printList() {
        for (int i = 0; i < rear; i++) {
            System.out.println(list[i]);
        }
    }

    public T remove(int index) {
        if (index < 0 || index >= rear) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        T removed = list[index];
        for (int i = index; i < rear - 1; i++) {
            list[i] = list[i + 1];
        }
        list[--rear] = null;
        return removed;
    }

    public T get(int index) {
        if (index < 0 || index >= rear) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return list[index];
    }
}
