package com.bolivarsoftware.actualizadorSocios.batch.socioDeudor;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.Modelo;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.IModeloService;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionService;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.ISocioDeudorService;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by Damian Saez on 17/5/2019.
 */
@Component
public class SociosReader implements ItemReader<Modelo> {


    @Autowired
    private ISocioDeudorService socioDeudorService;

    @Autowired
    private INotificacionService notificacionService;

    @Autowired
    private IModeloService modeloService;

    private Iterator<Modelo> notificacionPadronIterator;

    @BeforeStep
    private void init() {
        List<Modelo> socioDeudores = modeloService.findAll();
        this.notificacionPadronIterator = socioDeudores.iterator();


    }

    @Override
    public Modelo read() throws Exception{
        if(Objects.isNull(notificacionPadronIterator)) return null;

        if (notificacionPadronIterator.hasNext()) return this.notificacionPadronIterator.next();
        else return null;
    }



    private Notificacion nuevaNotification(){
        return notificacionService.save(new Notificacion("Deuda del mes" , new Date(), new Date()));
    }
}
