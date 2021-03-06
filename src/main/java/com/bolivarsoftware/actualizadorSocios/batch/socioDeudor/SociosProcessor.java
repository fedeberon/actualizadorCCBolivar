package com.bolivarsoftware.actualizadorSocios.batch.socioDeudor;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domain.Socio;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.Modelo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Damian Saez on 17/5/2019.
 */
@Component
public class SociosProcessor implements ItemProcessor<Modelo, NotificacionSocio> {

    Logger logger = LoggerFactory.getLogger(SociosProcessor.class);

    @Override
    public NotificacionSocio process(Modelo modelo) throws Exception {
        logger.info(">>>>>>>>>>>>>> Socio: "  + modelo);
        Socio socio = new Socio();
        socio.setId(1l);
        Notificacion notificacion = new Notificacion(1l);
        return new NotificacionSocio(notificacion, socio);
    }
}
