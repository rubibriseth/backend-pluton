package com.prueba.tecnica.backendpluton.service;

import com.prueba.tecnica.backendpluton.entity.Mascota;

import java.util.List;

public interface MascotaService {

    List<Mascota> listarMascota();

    Mascota buscarMascotaById(int idMascota);

    Mascota guardarMascota(Mascota mascota);

    void eliminarMascota(Mascota mascota);

}
