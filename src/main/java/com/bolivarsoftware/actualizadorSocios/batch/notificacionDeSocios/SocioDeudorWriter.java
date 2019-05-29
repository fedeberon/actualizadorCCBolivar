package com.bolivarsoftware.actualizadorSocios.batch.notificacionDeSocios;

import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionSocioService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by federicoberon on 29/05/2019.
 */
@Component
public class SocioDeudorWriter  implements ItemWriter<NotificacionSocio> {

    private INotificacionSocioService notificacionSocioService;

    @Autowired
    public SocioDeudorWriter(INotificacionSocioService notificacionSocioService) {
        this.notificacionSocioService = notificacionSocioService;
    }

    @Override
    public void write(List<? extends NotificacionSocio> sociosDeudores) throws Exception {
        for (NotificacionSocio socio : sociosDeudores){
            notificacionSocioService.save(socio);
        }
    }
}
