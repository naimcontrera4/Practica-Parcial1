package unlar.edu.ar.isi.strategy.pagoStrategy;

public class PagoBilletera implements PagoEstrategias {
    @Override
    public double costoFinal(double monto){
        return monto;
    }
}
