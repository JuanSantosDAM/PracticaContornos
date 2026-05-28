package entregas;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Pedido> historialPedidos;

    public Cliente(String nombreCliente, String emailCliente, String telefonoCliente) {
        super(nombreCliente, emailCliente, telefonoCliente);
        this.historialPedidos = new ArrayList<>();
    }

    public void anhadirPedido(Pedido pedido) {
        if (pedido != null && !historialPedidos.contains(pedido)) {
            this.historialPedidos.add(pedido);
        }
    }

    public List<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }
}
