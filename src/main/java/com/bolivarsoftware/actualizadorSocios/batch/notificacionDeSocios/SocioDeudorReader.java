package com.bolivarsoftware.actualizadorSocios.batch.notificacionDeSocios;

import com.bolivarsoftware.actualizadorSocios.domain.EstadoNotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.TipoNotificacionEnum;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionService;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.ISocioDeudorService;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by federicoberon on 28/05/2019.
 */
@Component
public class SocioDeudorReader implements ItemReader<SocioDeudor> {

    @Autowired
    private ISocioDeudorService socioDeudorService;

    @Autowired
    private INotificacionService notificacionService;


    private Iterator<SocioDeudor> notificacionPadronIterator;

    @BeforeStep
    private void init() {
        List<SocioDeudor> socioDeudores = socioDeudorService.findAll();
        this.notificacionPadronIterator = socioDeudores.iterator();
    }

    @Override
    public SocioDeudor read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(Objects.isNull(notificacionPadronIterator)) return null;

        if (notificacionPadronIterator.hasNext()) return this.notificacionPadronIterator.next();
        else return null;
    }

    @Bean("nuevaNotificacion")
    private Notificacion nuevaNotification(){
        return notificacionService.save(new Notificacion("Deuda del mes" , new Date(), new Date(), TipoNotificacionEnum.DEUDA));
    }
}
