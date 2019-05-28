package com.bolivarsoftware.actualizadorSocios.services.interfaces;


import com.bolivarsoftware.actualizadorSocios.domain.Socio;

import java.util.List;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface ISocioService {


    List<Socio> findAll();
}
