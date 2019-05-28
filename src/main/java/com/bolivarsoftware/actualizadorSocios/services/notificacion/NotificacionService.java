package com.bolivarsoftware.actualizadorSocios.services.notificacion;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.persist.NotificacionRepository;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by federicoberon on 15/05/2019.
 */

@Service
public class NotificacionService implements INotificacionService {

    private NotificacionRepository dao;

    @Autowired
    public NotificacionService(NotificacionRepository dao) {
        this.dao = dao;
    }

    @Override
    public Notificacion save(Notificacion notificacion){
        return dao.save(notificacion);
    }

}
