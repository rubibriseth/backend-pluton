package com.prueba.tecnica.backendpluton.controller;

import com.prueba.tecnica.backendpluton.entity.HistorialVacunas;
import com.prueba.tecnica.backendpluton.service.HistorialVacunasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/historialvacunas")
public class HistorialVacunasController {

    @Autowired
    private HistorialVacunasService historialService;

    @GetMapping(value="/lista")
    public ResponseEntity<List<HistorialVacunas>> listaHistorialVacunas(){
        return new ResponseEntity<>(historialService.listarHistorial(), HttpStatus.OK);
    }

    @GetMapping(value="/lista/{id}")
    public ResponseEntity<HistorialVacunas> buscarHistorialVacunasById(@PathVariable("id") int id){
        return new ResponseEntity<>(historialService.buscarHistorialById(id), HttpStatus.OK);
    }

    @PostMapping(value="/guardar")
    public ResponseEntity<?> guardar(@RequestBody HistorialVacunas historial){
        Map<String, Object> response = new HashMap<>();
        try {
            HistorialVacunas res = historialService.guardarHistorial(historial);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Error al insertar HistorialVacunas en la base de datos");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@RequestBody HistorialVacunas historial, @PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        try {

            HistorialVacunas updateHistorial = historialService.buscarHistorialById(id);

            updateHistorial.setIdMascota(historial.getIdMascota());
            updateHistorial.setTipoVacuna(historial.getTipoVacuna());
            updateHistorial.setFecha(historial.getFecha());
            updateHistorial.setObservacion(historial.getObservacion());
            updateHistorial.setEstado(historial.getEstado());

            HistorialVacunas res = historialService.guardarHistorial(updateHistorial);

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
            HistorialVacunas eliminarHistorial = historialService.buscarHistorialById(id);
            historialService.eliminarHistorial(eliminarHistorial);
            response.put("eliminado", true);
            return new ResponseEntity<Object>(response,HttpStatus.OK);
        }
        catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>( response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
