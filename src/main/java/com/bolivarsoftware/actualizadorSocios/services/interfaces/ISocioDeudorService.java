package com.bolivarsoftware.actualizadorSocios.services.interfaces;


import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;

import java.util.List;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface ISocioDeudorService {
    List<SocioDeudor> findAll();
}
