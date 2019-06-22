package com.bolivarsoftware.actualizadorSocios.batch.notificacionDeSocios;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.ISocioDeudorService;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    private Iterator<SocioDeudor> notificacionSocioDedudor;

    @BeforeStep
    private void init() {
        List<SocioDeudor> socioDeudores = socioDeudorService.findAll();
        this.notificacionSocioDedudor = socioDeudores.iterator();
    }

    @Override
    public SocioDeudor read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(Objects.isNull(notificacionSocioDedudor)) return null;

        if (notificacionSocioDedudor.hasNext()) return this.notificacionSocioDedudor.next();
        else return null;
    }

}
