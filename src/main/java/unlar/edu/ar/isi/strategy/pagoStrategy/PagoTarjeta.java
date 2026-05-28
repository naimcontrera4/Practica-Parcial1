package unlar.edu.ar.isi.strategy.pagoStrategy;

public class PagoTarjeta implements PagoEstrategias{
    @Override
    public double costoFinal(double monto){
        return monto;
    }
}
