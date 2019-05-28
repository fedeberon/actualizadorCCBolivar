package com.bolivarsoftware.actualizadorSocios.batch;

import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionSocioService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Damian Saez on 17/5/2019.
 */
@Component
public class SocioWriter implements ItemWriter<NotificacionSocio> {

    @Autowired
    private INotificacionSocioService notificacionSocioService;

    @Override
    public void write(List<? extends NotificacionSocio> socios) throws Exception {
        for (NotificacionSocio socio : socios){
            notificacionSocioService.save(socio);
        }
    }
}
