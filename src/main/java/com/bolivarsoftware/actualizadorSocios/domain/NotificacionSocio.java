package com.bolivarsoftware.actualizadorSocios.domain;

import javax.persistence.*;

/**
 * Created by federicoberon on 15/05/2019.
 */
@Entity
@Table(name = "NOTIFICACIONES_SOCIOS")
public class NotificacionSocio {

    @Id
    @Column(name = "ID_NOT_SOC")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NOT", nullable = false)
    private Notificacion notificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOCIO_ID", nullable = false)
    private Socio socio;

    @Enumerated(EnumType.STRING)
    @Column(name = "NOT_SOC_ESTADO")
    private EstadoNotificacionSocio estado = EstadoNotificacionSocio.ACTIVO;

    public NotificacionSocio() {}

    public NotificacionSocio(Notificacion notificacion, Socio socio) {
        this.notificacion = notificacion;
        this.socio = socio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public EstadoNotificacionSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoNotificacionSocio estado) {
        this.estado = estado;
    }
}
