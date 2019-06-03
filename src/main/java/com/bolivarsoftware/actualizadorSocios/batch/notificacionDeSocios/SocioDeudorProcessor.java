package com.bolivarsoftware.actualizadorSocios.batch.notificacionDeSocios;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domain.Socio;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by federicoberon on 29/05/2019.
 */
@Component
public class SocioDeudorProcessor implements ItemProcessor<SocioDeudor, NotificacionSocio> {


    @Autowired
    @Qualifier("nuevaNotificacion")
    private Notificacion notificacion;

    @Override
    public NotificacionSocio process(SocioDeudor socioDeudor) throws Exception {
        Socio socio = new Socio();
        socio.setId(socioDeudor.getId());
        return new NotificacionSocio(notificacion, socio);
    }
}
