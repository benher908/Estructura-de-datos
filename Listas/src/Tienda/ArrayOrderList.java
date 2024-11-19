package Tienda;

import java.util.ArrayList;
import java.util.List;

public class ArrayOrderList<T> {
    private List<T> lista;

    public ArrayOrderList() {
        lista = new ArrayList<>();
    }

    // Método para agregar un producto al final
    public void add(T item) {
        lista.add(item);
    }

    // Método para insertar un producto en una posición específica
    public void addAt(int index, T item) {
        lista.add(index, item);
    }

    // Método para eliminar un producto por objeto
    public void remove(T item) {
        lista.remove(item);
    }

    // Método para obtener un producto por índice
    public T get(int index) {
        return lista.get(index);
    }

    // Método para obtener el tamaño de la lista
    public int size() {
        return lista.size();
    }
}