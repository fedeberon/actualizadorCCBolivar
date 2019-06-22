package com.bolivarsoftware.actualizadorSocios.services.interfaces;


import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface INotificacionService {
    Notificacion save(Notificacion notificacion);

    Notificacion getDeudaCorrienteMes();

    Notificacion saveActive();
}
