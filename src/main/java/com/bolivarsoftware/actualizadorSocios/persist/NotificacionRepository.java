package com.bolivarsoftware.actualizadorSocios.persist;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    @Query("FROM Notificacion where tipo = 'DEUDA' AND NOW() BETWEEN desde AND hasta")
    Notificacion getDeudaCorrienteMes();
}
