package entregas;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE GESTIÓN DE PEDIDOS ===");

     
        Producto p1 = new Producto("Hamburguesa Completa", 12, CategoriaProducto.COMIDA);
        Producto p2 = new Producto("Refresco de Cola", 3, CategoriaProducto.BEBIDA);
        Producto p3 = new Producto("Tarta de Queso", 5, CategoriaProducto.POSTRE);

 
        Cliente cliente = new Cliente("Juan Marcos", "juan@email.com", "600123456");
        Repartidor repartidor = new Repartidor("Carlos", "carlos@reparto.com", "611987654", "Zona Centro");

        System.out.println("\n--- Estado Inicial ---");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Repartidor: " + repartidor.getNombre() + " | Estado: " + repartidor.getEstado());


       
        Pedido pedido = new Pedido(101, cliente);
        System.out.println("\nPedido " + pedido.getId() + " creado para el cliente.");
        System.out.println("Estado inicial del pedido: " + pedido.getEstado());


  
       

        //Intentar asignar repartidor a un pedido vacío
        System.out.println("Prueba 1 (Asignar sin productos):");
        pedido.asignarRepartidor(repartidor); 

     
        pedido.anhadirProducto(p1);
        pedido.anhadirProducto(p2);

      //Intentar añadir un producto duplicado
        System.out.println("\nPrueba 2 (Añadir producto duplicado):");
        pedido.anhadirProducto(p1); 

   //Intentar entregar un pedido que aún no está en reparto
        System.out.println("\nPrueba 3 (Entregar sin estar en reparto):");
        pedido.entregarPedido(); 


    
      //Flujo sin errores
        pedido.anhadirProducto(p3);
        System.out.println("Total calculado automáticamente: " + pedido.getTotal() + "€");

      
        System.out.println("\nAsignando repartidor...");
        pedido.asignarRepartidor(repartidor);

     
        System.out.println("Nuevo estado del pedido: " + pedido.getEstado());
        System.out.println("Nuevo estado del repartidor: " + repartidor.getEstado());

   
        System.out.println("\nIntentando asignar el mismo repartidor a otro pedido:");
        Pedido pedido2 = new Pedido(102, cliente);
        pedido2.anhadirProducto(p2);
        pedido2.asignarRepartidor(repartidor); 

 
        System.out.println("\nFinalizando entrega del pedido " + pedido.getId() + "...");
        pedido.entregarPedido();


        System.out.println("Estado final del pedido 101: " + pedido.getEstado());
        System.out.println("Estado final del repartidor: " + repartidor.getEstado());


      
        System.out.println("\n--- Historial del Cliente ---");
        System.out.println("El cliente " + cliente.getNombre() + " tiene " + cliente.getHistorialPedidos().size() + " pedido(s) en su historial.");
    }
}
