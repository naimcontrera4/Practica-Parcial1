package unlar.edu.ar.isi.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Getter;
import lombok.Setter;
import unlar.edu.ar.isi.model.Estacion;
import unlar.edu.ar.isi.model.Vehiculo;
import unlar.edu.ar.isi.service.EstacionService;
import unlar.edu.ar.isi.service.ProcesamientoPagoService;
@Getter
@Setter
class RequestDatos{
    private UUID idUsuario;
    private String nombre;
    private String patente;
    private String metodoPago;
    private String tipoUsuario;
}
@RestController
@RequestMapping("/api/sistema")
public class AlquilerController {
    private EstacionService estacionService=new EstacionService();
    private ProcesamientoPagoService metodoPago=new ProcesamientoPagoService();
    @PostMapping("/alquilar")
    public ResponseEntity<String>alquilar(@RequestBody RequestDatos requestDatos){
       try{
        Estacion estacion=new Estacion("Mexico");
       Vehiculo vehiculo=estacionService.AlquilerVehiculo(estacion.getListaVehiculos(), requestDatos.getPatente());
       String pagoRealizado=metodoPago.finalizarCompra(vehiculo, requestDatos.getMetodoPago(), requestDatos.getTipoUsuario());
       return ResponseEntity.ok(pagoRealizado);
       }catch( RuntimeException e){
            return ResponseEntity.badRequest().body("Error al alquilar: "+e.getMessage());
       }
    }
     private Estacion estacion=new Estacion("Mexico");
    @GetMapping("/vehiculos")
    public List<Vehiculo> garaje() {
        return estacion.getListaVehiculos();
    }
}

