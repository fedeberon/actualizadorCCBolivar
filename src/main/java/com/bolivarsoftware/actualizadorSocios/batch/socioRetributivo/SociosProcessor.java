package com.bolivarsoftware.actualizadorSocios.batch.socioRetributivo;

import com.bolivarsoftware.actualizadorSocios.domain.EstadoNotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domain.Socio;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioRetributivo;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Damian Saez on 17/5/2019.
 */
@Component
public class SociosProcessor implements ItemProcessor<SocioRetributivo, NotificacionSocio> {

    Logger logger = LoggerFactory.getLogger(SociosProcessor.class);

    @Autowired
    private INotificacionService notificacionService;

    @Override
    public NotificacionSocio process(SocioRetributivo socioRetributivo) throws Exception {
        logger.info(">>>>>>>>>>>>>> Socio: "  + socioRetributivo);
        Socio socio = new Socio();
        socio.setId(socioRetributivo.getId());
        NotificacionSocio notificacionSocio = new NotificacionSocio(getNotificacion(), socio);
        notificacionSocio.setEstado(EstadoNotificacionSocio.INACTIVO);

        return notificacionSocio;
    }

    public Notificacion getNotificacion(){
        Notificacion notificacionActiva = notificacionService.getDeudaCorrienteMes();
        if(Objects.isNull(notificacionActiva)){
            notificacionActiva = notificacionService.saveActive();
        }

        return notificacionActiva;
    }
}