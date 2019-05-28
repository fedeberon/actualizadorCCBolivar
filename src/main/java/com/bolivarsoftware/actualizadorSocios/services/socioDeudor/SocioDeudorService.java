package com.bolivarsoftware.actualizadorSocios.services.socioDeudor;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.ISocioDeudorService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by federicoberon on 15/05/2019.
 */
@Service
public class SocioDeudorService implements ISocioDeudorService {



    @Override
    public List<SocioDeudor> findAll(){
        return Arrays.asList(new SocioDeudor());
    }


}
