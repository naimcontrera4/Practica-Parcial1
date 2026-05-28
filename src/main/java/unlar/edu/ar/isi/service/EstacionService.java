package unlar.edu.ar.isi.service;
import java.util.List;
import unlar.edu.ar.isi.model.Vehiculo;

public class EstacionService {
    
    public void validarBateria(Vehiculo vehiculo){
        if(vehiculo.getBateria()<15){
            throw new RuntimeException("Bateria baja");
        }
    }
    public void obtenerLista(List <Vehiculo> Lista){
        System.out.println("----Lista de Vehiculos---");
        for (Vehiculo p : Lista) {
            System.out.println(p);
        }
    }
    public Vehiculo busquedaVehiculo(List<Vehiculo>vehiculos,String patente){
        Vehiculo vehiculo=vehiculos.stream()
        .filter(v->v.getPatente().equalsIgnoreCase(patente))
        .findFirst()
        .orElseThrow(()->new RuntimeException("Vehiculo no encontrado"));
        validarBateria(vehiculo);
        return vehiculo;
    } 
    public Vehiculo AlquilerVehiculo(List<Vehiculo>vehiculos,String patente){
        obtenerLista(vehiculos);
        Vehiculo vehiculo=busquedaVehiculo(vehiculos, patente);
        return vehiculo;
    }

}
