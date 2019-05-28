package com.bolivarsoftware.actualizadorSocios.domainSoccam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by federicoberon on 27/05/2019.
 */
@Entity
@Table(name = "ART_MODELO")
public class Modelo {

    @Id
    @Column(name = "ID_MODELO")
    private Integer id;
    @Column(name = "DESCRIPCION1")
    private String descripcion1;
    @Column(name = "DESCRIPCION2")
    private String descripcion2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion1() {
        return descripcion1;
    }

    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }
}
