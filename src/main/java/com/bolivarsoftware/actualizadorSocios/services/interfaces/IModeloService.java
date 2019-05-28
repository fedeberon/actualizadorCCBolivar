package com.bolivarsoftware.actualizadorSocios.services.interfaces;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.Modelo;

import java.util.List;

/**
 * Created by federicoberon on 27/05/2019.
 */
public interface IModeloService {
    List<Modelo> findAll();
}
