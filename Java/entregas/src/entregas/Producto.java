package entregas;

import java.util.Objects;

public class Producto {
    private String nombre;
    private int precio; 
    private CategoriaProducto categoria;

    public Producto(String nombreProducto, int precioProducto, CategoriaProducto categoria) {
        this.nombre = nombreProducto;
        this.precio = precioProducto;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    
   
}