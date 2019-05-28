package com.bolivarsoftware.actualizadorSocios.persist;

import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface NotificacionSocioRepository extends JpaRepository<NotificacionSocio, Long>{
}
