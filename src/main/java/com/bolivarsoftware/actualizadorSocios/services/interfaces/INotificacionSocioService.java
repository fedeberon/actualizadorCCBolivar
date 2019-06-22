package com.bolivarsoftware.actualizadorSocios.services.interfaces;


import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface INotificacionSocioService {
    NotificacionSocio save(NotificacionSocio notificacionSocio);

    void update(NotificacionSocio notificacionSocio);
}
