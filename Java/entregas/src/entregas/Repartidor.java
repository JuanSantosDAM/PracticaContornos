package entregas;

public class Repartidor extends Usuario {
    private String lugarReparto; 
    private EstadoRepartidor estado;

    public Repartidor(String nombreRepartidor, String emailRepartidor, String telefonoRepartidor, String lugarReparto) {
        super(nombreRepartidor, emailRepartidor, telefonoRepartidor);
        this.lugarReparto = lugarReparto;
        this.estado = EstadoRepartidor.Disponible; 
    }

    public String getLugarReparto() {
        return lugarReparto;
    }

    public EstadoRepartidor getEstado() {
        return estado;
    }

    public void setEstado(EstadoRepartidor estado) {
        this.estado = estado;
    }
}