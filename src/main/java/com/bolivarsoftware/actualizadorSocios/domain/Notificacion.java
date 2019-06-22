package com.bolivarsoftware.actualizadorSocios.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by federicoberon on 15/05/2019.
 */
@Entity
@Table(name = "NOTIFICACIONES")
public class Notificacion {
    @Id
    @Column(name = "ID_NOT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MENSAJE_NOT")
    private String mensaje;

    @Column(name = "DESDE_NOT")
    private Date desde;

    @Column(name = "HASTA_NOT")
    private Date hasta;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_NOT")
    private TipoNotificacionEnum tipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notificacion")
    private List<NotificacionSocio> notificacionSocio;

    public Notificacion() {}

    public Notificacion(String mensaje, Date desde, Date hasta, TipoNotificacionEnum tipo) {
        this.mensaje = mensaje;
        this.desde = desde;
        this.hasta = hasta;
        this.tipo = tipo;
    }

    public Notificacion(Long i) {
        this.id = i;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public TipoNotificacionEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotificacionEnum tipo) {
        this.tipo = tipo;
    }

    public List<NotificacionSocio> getNotificacionSocio() {
        return notificacionSocio;
    }

    public void setNotificacionSocio(List<NotificacionSocio> notificacionSocio) {
        this.notificacionSocio = notificacionSocio;
    }
}
