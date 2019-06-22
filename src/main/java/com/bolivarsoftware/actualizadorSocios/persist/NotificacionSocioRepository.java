package com.bolivarsoftware.actualizadorSocios.persist;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface NotificacionSocioRepository extends JpaRepository<NotificacionSocio, Long>{

    @Transactional
    @Modifying
    @Query("Update NotificacionSocio set estado = 'INACTIVO' WHERE  notificacion.id = :idNotificacion AND socio.id = :idSocio")
    void update(@Param("idNotificacion") Long idNotificacion, @Param("idSocio") Long idSocio);

//    @Query("from NotificacionSocio where estado = 'INACTIVO' AND NOW() BETWEEN desde AND hasta")
//    List<NotificacionSocio> findActivos();

}
