package entregas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDateTime fecha;
    private EstadoPedido estado;
    private Cliente cliente;
    private Repartidor repartidor;
    private List<Producto> productos;
    private int total; 

    public Pedido(int idPedido, Cliente cliente) {
        this.id = idPedido;
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
        this.estado = EstadoPedido.PENDIENTE;
        this.productos = new ArrayList<>();
        this.repartidor = null; 
        this.total = 0;
        
        
        if (cliente != null) {
            cliente.anhadirPedido(this);
        }
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public int getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

  
    public void anhadirProducto(Producto p) {
        if (p == null) return;
        
        if (productos.contains(p)) {
            System.out.println("Error: El producto '" + p.getNombre() + "' ya está en el pedido.");
            return;
        }
        
        this.productos.add(p);
        totalProducto(); 
    }

    
    public void asignarRepartidor(Repartidor rep) {
        if (productos.isEmpty()) {
            System.out.println("Error: No se puede asignar repartidor a un pedido sin productos.");
            return;
        }
        if (rep == null || rep.getEstado() != EstadoRepartidor.Disponible) {
            System.out.println("Error: El repartidor no está disponible o es inválido.");
            return;
        }

        this.repartidor = rep;
        this.estado = EstadoPedido.REPARTIENDO;         
        this.repartidor.setEstado(EstadoRepartidor.NoDisponible); 
        System.out.println("Pedido " + id + " asignado correctamente al repartidor " + rep.getNombre());
    }

    
    public void entregarPedido() {
        if (this.estado != EstadoPedido.REPARTIENDO) {
            System.out.println("Error: No se puede entregar un pedido que no esté en estado REPARTIENDO.");
            return;
        }

        this.estado = EstadoPedido.ENTREGADO;
        if (this.repartidor != null) {
            this.repartidor.setEstado(EstadoRepartidor.Disponible);
        }
        System.out.println("Pedido " + id + " ha sido entregado con éxito.");
    }

   
    public void totalProducto() {
        int suma = 0;
        for (Producto p : productos) {
            suma += p.getPrecio();
        }
        this.total = suma;
    }
}
