package com.bolivarsoftware.actualizadorSocios.batch.socioRetributivo;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioRetributivo;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionSocioService;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.ISocioRetributivoService;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by Damian Saez on 17/5/2019.
 */
@Component
public class SociosReader implements ItemReader<SocioRetributivo> {

    @Autowired
    private ISocioRetributivoService socioRetributivoService;

    private Iterator<SocioRetributivo> socioDeudorIterator;

    @BeforeStep
    private void init() {
        List<SocioRetributivo> socioRetributivos = socioRetributivoService.findAll();
        this.socioDeudorIterator = socioRetributivos.iterator();
    }

    @Override
    public SocioRetributivo read() throws Exception{
        if(Objects.isNull(socioDeudorIterator)) return null;

        if (socioDeudorIterator.hasNext()) return this.socioDeudorIterator.next();
        else return null;
    }



}
