package com.prueba.tecnica.backendpluton.repository;

import com.prueba.tecnica.backendpluton.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaDAO extends JpaRepository<Mascota, Integer> {

}
