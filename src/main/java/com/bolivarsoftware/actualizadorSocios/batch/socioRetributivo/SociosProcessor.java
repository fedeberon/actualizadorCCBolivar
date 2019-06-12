package com.bolivarsoftware.actualizadorSocios.batch.socioRetributivo;

import com.bolivarsoftware.actualizadorSocios.domain.EstadoNotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domain.Socio;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioRetributivo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Damian Saez on 17/5/2019.
 */
@Component
public class SociosProcessor implements ItemProcessor<SocioRetributivo, NotificacionSocio> {

    Logger logger = LoggerFactory.getLogger(SociosProcessor.class);

    @Autowired
    @Qualifier("notificacionSocioDeDeudaCorrienteMes")
    private Notificacion notificacion;

    @Override
    public NotificacionSocio process(SocioRetributivo socioRetributivo) throws Exception {
        logger.info(">>>>>>>>>>>>>> Socio: "  + socioRetributivo);
        Socio socio = new Socio();
        socio.setId(socioRetributivo.getId());
        NotificacionSocio notificacionSocio = new NotificacionSocio(notificacion, socio);
        notificacionSocio.setEstado(EstadoNotificacionSocio.INACTIVO);

        return notificacionSocio;
    }
}
