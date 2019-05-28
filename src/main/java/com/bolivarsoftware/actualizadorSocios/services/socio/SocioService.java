package com.bolivarsoftware.actualizadorSocios.services.socio;

import com.bolivarsoftware.actualizadorSocios.domain.Socio;
import com.bolivarsoftware.actualizadorSocios.persist.SocioRepository;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.ISocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by federicoberon on 15/05/2019.
 */
@Service
public class SocioService implements ISocioService {

    private SocioRepository dao;

    @Autowired
    public SocioService(SocioRepository dao) {
        this.dao = dao;
    }


    @Override
    public List<Socio> findAll() {
        return dao.findAll();
    }
}
