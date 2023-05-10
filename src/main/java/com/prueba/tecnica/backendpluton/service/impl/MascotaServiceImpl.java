package com.prueba.tecnica.backendpluton.service.impl;

import com.prueba.tecnica.backendpluton.entity.Mascota;
import com.prueba.tecnica.backendpluton.repository.MascotaDAO;
import com.prueba.tecnica.backendpluton.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaDAO mascotaDAO;

    @Override
    public List<Mascota> listarMascota() {
        return mascotaDAO.findAll();
    }

    @Override
    public Mascota buscarMascotaById(int idMascota) {
        return mascotaDAO.findById(idMascota).orElse(null);
    }

    @Override
    public Mascota guardarMascota(Mascota mascota) {
        return mascotaDAO.save(mascota);
    }

    @Override
    public void eliminarMascota(Mascota mascota) {
        mascotaDAO.delete(mascota);
    }
}
