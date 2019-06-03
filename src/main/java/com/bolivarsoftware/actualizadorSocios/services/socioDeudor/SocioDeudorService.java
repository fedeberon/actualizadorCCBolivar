package com.bolivarsoftware.actualizadorSocios.services.socioDeudor;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;
import com.bolivarsoftware.actualizadorSocios.persistSoccam.SocioDeudorRepository;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.ISocioDeudorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by federicoberon on 15/05/2019.
 */
@Service
public class SocioDeudorService implements ISocioDeudorService {

    private SocioDeudorRepository dao;

    public SocioDeudorService(SocioDeudorRepository dao) {
        this.dao = dao;
    }

    @Override
    public List<SocioDeudor> findAll(){
        return dao.findAll();
    }


}
