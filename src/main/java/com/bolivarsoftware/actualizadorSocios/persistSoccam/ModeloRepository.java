package com.bolivarsoftware.actualizadorSocios.persistSoccam;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by federicoberon on 27/05/2019.
 */
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
