package unlar.edu.ar.isi.strategy.usuarioStrategy;
import unlar.edu.ar.isi.model.Vehiculo;

public class Usuariopremium implements UsuariosEstrategias {
    @Override
    public double calcularPago(Vehiculo vehiculo){
        return vehiculo.getTarifaBase();
    }
}