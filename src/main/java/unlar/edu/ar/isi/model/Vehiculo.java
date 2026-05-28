package unlar.edu.ar.isi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    private String patente;
    private double bateria;
    private double tarifaBase;
}
