package com.prueba.tecnica.backendpluton.service.impl;

import com.prueba.tecnica.backendpluton.entity.HistorialVacunas;
import com.prueba.tecnica.backendpluton.repository.HistorialVacunasDAO;
import com.prueba.tecnica.backendpluton.service.HistorialVacunasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialVacunasServiceImpl implements HistorialVacunasService {

    @Autowired
    private HistorialVacunasDAO historialDAO;

    @Override
    public List<HistorialVacunas> listarHistorial() {
        return historialDAO.findAll();
    }

    @Override
    public HistorialVacunas buscarHistorialById(int idHistorial) {
        return historialDAO.findById(idHistorial).orElse(null);
    }

    @Override
    public HistorialVacunas guardarHistorial(HistorialVacunas historial) {
        return historialDAO.save(historial);
    }

    @Override
    public void eliminarHistorial(HistorialVacunas historial) {
        historialDAO.delete(historial);
    }
}
