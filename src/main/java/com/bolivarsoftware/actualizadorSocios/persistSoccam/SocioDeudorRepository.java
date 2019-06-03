package com.bolivarsoftware.actualizadorSocios.persistSoccam;

import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by federicoberon on 15/05/2019.
 */
public interface SocioDeudorRepository extends JpaRepository<SocioDeudor, Long> {



}
