package com.bolivarsoftware.actualizadorSocios.persist;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface NotificacionSocioRepository extends JpaRepository<NotificacionSocio, Long>{

    //// TODO: 31/5/2019 Agragar Filtro del  mes corriente
    @Query("FROM Notificacion where tipo = 'DEUDA'")
    Notificacion getDeudaCorrienteMes();

}
