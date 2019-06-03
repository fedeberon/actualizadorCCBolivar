package com.bolivarsoftware.actualizadorSocios.domainSoccam;

import javax.persistence.*;

/**
 * Created by federicoberon on 15/05/2019.
 */
@Entity
@Table(name = "VW_SOCIOS_DEUDORES")
public class SocioDeudor {

    @Id
    @Column(name = "ID_SOC")
    private Long id;

    @Column(name = "SOD_ESTADO")
    private Integer estado;

    @Transient
    private String nombre;

    @Transient
    private String apellido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
