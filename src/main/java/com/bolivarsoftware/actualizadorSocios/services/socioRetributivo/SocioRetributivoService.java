package com.bolivarsoftware.actualizadorSocios.services.socioRetributivo;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioRetributivo;
import com.bolivarsoftware.actualizadorSocios.persistSoccam.SocioDeudorRepository;
import com.bolivarsoftware.actualizadorSocios.persistSoccam.SocioRetrbutivoRepository;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.ISocioRetributivoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian Saez on 29/5/2019.
 */
@Service
public class SocioRetributivoService implements ISocioRetributivoService {

    private SocioRetrbutivoRepository dao;

    public SocioRetributivoService (SocioRetrbutivoRepository dao) {
        this.dao = dao;
    }

    @Override
    public List<SocioRetributivo> findAll(){
        return dao.findAll();
    }


}