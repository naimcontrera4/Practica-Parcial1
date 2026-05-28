package unlar.edu.ar.isi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BicicletaElectrica extends Vehiculo {
    private double tamano;

    public BicicletaElectrica(String patente,double bateria,double tarifaBase,double tamano) {
        super(patente, bateria, tarifaBase);
        this.tamano=tamano;
        
    }
}
