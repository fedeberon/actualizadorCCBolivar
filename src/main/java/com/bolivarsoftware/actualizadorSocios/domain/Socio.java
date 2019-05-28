package com.bolivarsoftware.actualizadorSocios.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by federicoberon on 15/05/2019.
 */

@Entity
@Table(name = "SOCIO")
public class Socio {

    @Id
    @Column(name = "SOCIOS_ID")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
    private List<NotificacionSocio> notificacionSocio;

    public Socio() { }

    public Socio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NotificacionSocio> getNotificacionSocio() {
        return notificacionSocio;
    }

    public void setNotificacionSocio(List<NotificacionSocio> notificacionSocio) {
        this.notificacionSocio = notificacionSocio;
    }
}
