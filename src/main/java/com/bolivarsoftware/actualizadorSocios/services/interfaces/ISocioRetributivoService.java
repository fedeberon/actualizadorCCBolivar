package com.bolivarsoftware.actualizadorSocios.services.interfaces;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioRetributivo;

import java.util.List;

/**
 * Created by Damian Saez on 29/5/2019.
 */
public interface ISocioRetributivoService {
    List<SocioRetributivo> findAll();
}
