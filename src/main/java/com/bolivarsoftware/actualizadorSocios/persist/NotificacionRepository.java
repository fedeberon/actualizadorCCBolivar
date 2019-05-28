package com.bolivarsoftware.actualizadorSocios.persist;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
