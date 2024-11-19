package Tienda;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayOrderList<Producto> inventario = new ArrayOrderList<>();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            procesarOpcion(opcion);
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Inventario de RGSolucionesCibernéticas ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Buscar producto por ID");
        System.out.println("4. Buscar productos por categoría");
        System.out.println("5. Mostrar inventario");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
            return -1;
        }
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> agregarProducto();
            case 2 -> eliminarProducto();
            case 3 -> buscarProductoPorId();
            case 4 -> buscarProductosPorCategoria();
            case 5 -> mostrarInventario();
            case 6 -> salir();
            default -> System.out.println("Opción incorrecta. Intenta nuevamente.");
        }
    }

    private static void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del producto: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Categoría del producto: ");
        String categoria = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = Double.parseDouble(scanner.nextLine());

        Producto nuevoProducto = new Producto(nombre, id, categoria, precio);

        boolean agregado = false;
        for (int i = 0; i < inventario.size(); i++) {
            Producto existente = inventario.get(i);
            if (existente.compareTo(nuevoProducto) > 0) {
                inventario.addAt(i, nuevoProducto); // Inserta en la posición ordenada
                agregado = true;
                break;
            }
        }

        if (!agregado) {
            inventario.add(nuevoProducto); // Si no hay mayores, agregar al final
        }

        System.out.println("Producto agregado: " + nuevoProducto);
    }

    private static void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Producto productoAEliminar = buscarProductoPorId(id);

        if (productoAEliminar != null) {
            inventario.remove(productoAEliminar);
            System.out.println("Producto eliminado: " + productoAEliminar);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static Producto buscarProductoPorId(int id) {
        for (int i = 0; i < inventario.size(); i++) {
            Producto producto = inventario.get(i);
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    private static void buscarProductoPorId() {
        System.out.print("ID del producto a buscar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Producto encontrado = buscarProductoPorId(id);
        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void buscarProductosPorCategoria() {
        System.out.print("Categoría a buscar: ");
        String categoria = scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < inventario.size(); i++) {
            Producto producto = inventario.get(i);
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(producto);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos en la categoría: " + categoria);
        }
    }

    private static void mostrarInventario() {
        if (inventario.size() == 0) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("Inventario:");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(inventario.get(i));
        }
    }

    private static void salir() {
        System.out.println("Gracias por usar el sistema. ¡Adiós!");
        System.exit(0);
    }
}
