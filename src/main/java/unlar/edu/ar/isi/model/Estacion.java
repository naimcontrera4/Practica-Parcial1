package unlar.edu.ar.isi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Estacion {
    String nombre;
    List<Vehiculo>listaVehiculos;
    
    public Estacion(String nombre){
        this.nombre=nombre;
        this.listaVehiculos=new ArrayList<>();
        this.listaVehiculos.add(new Vehiculo("AB123CD", 100,500)); 
        this.listaVehiculos.add(new Vehiculo("MOTO999", 10,500));  
        this.listaVehiculos.add(new Vehiculo("UNLAR22", 50,500));
    }
}
