package com.bolivarsoftware.actualizadorSocios.batch.notificacionDeSocios;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domain.Socio;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by federicoberon on 29/05/2019.
 */
@Component
public class SocioDeudorProcessor implements ItemProcessor<SocioDeudor, NotificacionSocio> {

    @Autowired
    private INotificacionService notificacionService;

    @Override
    public NotificacionSocio process(SocioDeudor socioDeudor) throws Exception {
        Notificacion notificacion = getNotificacion();
        Socio socio = new Socio();
        socio.setId(socioDeudor.getId());
        return new NotificacionSocio(notificacion, socio);
    }


    public Notificacion getNotificacion(){
        Notificacion notificacionActiva = notificacionService.getDeudaCorrienteMes();
        if(Objects.isNull(notificacionActiva)){
            notificacionActiva = notificacionService.saveActive();
        }

        return notificacionActiva;
    }
}
