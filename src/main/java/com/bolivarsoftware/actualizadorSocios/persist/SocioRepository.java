package com.bolivarsoftware.actualizadorSocios.persist;

import com.bolivarsoftware.actualizadorSocios.domain.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface SocioRepository extends JpaRepository<Socio, Long> {
}
