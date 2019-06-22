package com.bolivarsoftware.actualizadorSocios.services.notificacion;

import com.bolivarsoftware.actualizadorSocios.domain.Notificacion;
import com.bolivarsoftware.actualizadorSocios.domain.TipoNotificacionEnum;
import com.bolivarsoftware.actualizadorSocios.persist.NotificacionRepository;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by federicoberon on 15/05/2019.
 */

@Service
public class NotificacionService implements INotificacionService {

    private NotificacionRepository dao;

    @Autowired
    public NotificacionService(NotificacionRepository dao) {
        this.dao = dao;
    }

    @Override
    public Notificacion save(Notificacion notificacion){
        return dao.save(notificacion);
    }

    @Override
    public Notificacion getDeudaCorrienteMes(){
        return dao.getDeudaCorrienteMes();
    }

    @Override
    public Notificacion saveActive(){
        return this.save(new Notificacion("Deuda del mes" , java.sql.Date.valueOf(desde()), java.sql.Date.valueOf(hasta()), TipoNotificacionEnum.DEUDA));

    }

    private LocalDate desde(){
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        return start;
    }

    private LocalDate hasta(){
        LocalDate end = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        return end;
    }
}
