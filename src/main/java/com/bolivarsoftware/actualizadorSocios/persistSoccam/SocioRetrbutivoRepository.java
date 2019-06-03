package com.bolivarsoftware.actualizadorSocios.persistSoccam;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioRetributivo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Damian Saez on 29/5/2019.
 */
public interface SocioRetrbutivoRepository extends JpaRepository<SocioRetributivo, Long> {
}
