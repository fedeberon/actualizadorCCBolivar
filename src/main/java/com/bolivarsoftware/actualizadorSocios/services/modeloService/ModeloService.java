package com.bolivarsoftware.actualizadorSocios.services.modeloService;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.Modelo;
import com.bolivarsoftware.actualizadorSocios.persistSoccam.ModeloRepository;
import com.bolivarsoftware.actualizadorSocios.services.interfaces.IModeloService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by federicoberon on 27/05/2019.
 */
@Service
public class ModeloService implements IModeloService {

    private ModeloRepository dao;


    public ModeloService(ModeloRepository dao) {
        this.dao = dao;
    }


    @Override
    public List<Modelo> findAll(){
        return dao.findAll();
    }
}
