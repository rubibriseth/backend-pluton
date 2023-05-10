package com.prueba.tecnica.backendpluton.controller;

import com.prueba.tecnica.backendpluton.entity.Mascota;
import com.prueba.tecnica.backendpluton.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping(value="/lista")
    public ResponseEntity<List<Mascota>> listaMascota(){
        return new ResponseEntity<>(mascotaService.listarMascota(), HttpStatus.OK);
    }

    @GetMapping(value="/lista/{id}")
    public ResponseEntity<Mascota> buscarMascotaById(@PathVariable("id") int id){
        return new ResponseEntity<>(mascotaService.buscarMascotaById(id), HttpStatus.OK);
    }

    @PostMapping(value="/guardar")
    public ResponseEntity<?> guardar(@RequestBody Mascota mascota){
        Map<String, Object> response = new HashMap<>();

        try {
            Mascota res = mascotaService.guardarMascota(mascota);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Error al insertar Mascota en la base de datos");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Mascota mascota, @PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        try {

            Mascota updateMascota = mascotaService.buscarMascotaById(id);

            updateMascota.setNombre(mascota.getNombre());
            updateMascota.setRaza(mascota.getRaza());
            updateMascota.setEdad(mascota.getEdad());
            updateMascota.setPeso(mascota.getPeso());
            updateMascota.setEdad(mascota.getEdad());

            Mascota res = mascotaService.guardarMascota(updateMascota);

            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>( response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        try {
            Mascota eliminarMascota = mascotaService.buscarMascotaById(id);
            mascotaService.eliminarMascota(eliminarMascota);
            response.put("eliminado", true);
            return new ResponseEntity<Object>(response,HttpStatus.OK);
        }
        catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>( response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
