package com.bolivarsoftware.actualizadorSocios.services.notificacionSocio;

import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.persist.NotificacionSocioRepository;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionSocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by federicoberon on 15/05/2019.
 */
@Service
public class NotificacionSocioService implements INotificacionSocioService {

    private NotificacionSocioRepository dao;

    @Autowired
    public NotificacionSocioService(NotificacionSocioRepository dao) {
        this.dao = dao;
    }

    @Override
    public NotificacionSocio save(NotificacionSocio notificacionSocio) {
        return dao.save(notificacionSocio);
    }
}
