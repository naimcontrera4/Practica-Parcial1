package unlar.edu.ar.isi.service;
import unlar.edu.ar.isi.model.Vehiculo;
import unlar.edu.ar.isi.strategy.pagoStrategy.PagoBilletera;
import unlar.edu.ar.isi.strategy.pagoStrategy.PagoEstrategias;
import unlar.edu.ar.isi.strategy.pagoStrategy.PagoTarjeta;
import unlar.edu.ar.isi.strategy.usuarioStrategy.UsuarioEstandar;
import unlar.edu.ar.isi.strategy.usuarioStrategy.Usuariopremium;
import unlar.edu.ar.isi.strategy.usuarioStrategy.UsuariosEstrategias;

public class ProcesamientoPagoService {
    public void validarBateria(Vehiculo vehiculo){
        if(vehiculo.getBateria()<15){
            throw new RuntimeException("Bateria baja");
        }
    }
    public UsuariosEstrategias tiposuario(String tipo){
        if(tipo.equalsIgnoreCase("Premium")){
            return new Usuariopremium(); 
        }else{
            return new UsuarioEstandar();
        }
    }

    public PagoEstrategias pago(String metodoPago){
        if(metodoPago.equalsIgnoreCase("Billetera")){
            return new PagoBilletera(); 
        }else{
            return new PagoTarjeta();
        }
    }

    public String finalizarCompra(Vehiculo vehiculo,String tipoPago,String tipoUsuario){
        UsuariosEstrategias usuario=tiposuario(tipoUsuario);
        PagoEstrategias metodPago=pago(tipoPago);
        double monto=usuario.calcularPago(vehiculo);
        double montoFinal=metodPago.costoFinal(monto);
        return "Costo Final al alquilar Vehiculo "+montoFinal+" Realizado con "+tipoPago;
    }


}

