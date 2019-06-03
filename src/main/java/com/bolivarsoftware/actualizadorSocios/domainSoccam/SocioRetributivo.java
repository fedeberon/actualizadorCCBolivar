package com.bolivarsoftware.actualizadorSocios.domainSoccam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Damian Saez on 29/5/2019.
 */

@Entity
@Table(name = "VW_SOCIOS_RETRIBUTIVOS")
public class SocioRetributivo {

    @Id
    @Column(name = "ID_SOC")
    private Long id;

    @Column(name = "SOR_ESTADO")
    private Integer estado;

    @Column(name = "SOR_FECHA_VENCIMIENTO")
    private Date fecha_vencimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
}

