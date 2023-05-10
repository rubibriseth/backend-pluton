package com.prueba.tecnica.backendpluton.service;

import com.prueba.tecnica.backendpluton.entity.HistorialVacunas;
import com.prueba.tecnica.backendpluton.entity.Mascota;

import java.util.List;

public interface HistorialVacunasService {

    List<HistorialVacunas> listarHistorial();

    HistorialVacunas buscarHistorialById(int idHistorial);

    HistorialVacunas guardarHistorial(HistorialVacunas historial);

    void eliminarHistorial(HistorialVacunas historial);
}
