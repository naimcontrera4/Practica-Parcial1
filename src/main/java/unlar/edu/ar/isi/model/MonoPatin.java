package unlar.edu.ar.isi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonoPatin extends Vehiculo {
    private boolean amortiguador;

    public MonoPatin(String patente,double bateria,double tarifaBase,boolean amortiguador) {
        super(patente, bateria, tarifaBase);
        this.amortiguador=amortiguador;
        
    }
}
