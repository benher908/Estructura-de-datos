package Tienda;
public class Producto implements Comparable<Producto> {
    private String nombre;
    private int id; // Cambié de Integer a int
    private String categoria;
    private double precio;
    public Producto(String nombre, int id, String categoria, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.categoria = categoria;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    // Método para comparar productos por ID
    @Override
    public int compareTo(Producto other) {
        return Integer.compare(this.id, other.id);
    }
    // Método para mostrar información del producto
    @Override
    public String toString() {
        return "nombre: '" + nombre + '\'' +
                "\nid: " + id +
                "\ncategoria: '" + categoria + '\'' +
                "\nprecio: " + precio;
    }
}