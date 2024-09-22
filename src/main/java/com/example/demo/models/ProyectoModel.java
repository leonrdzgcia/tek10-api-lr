package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "proyectos")
public class ProyectoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Long clienteId;
    private String tekid;
    private String nombreproyecto;
    private String estatus;
    private String descripcion;
    private String contactogeneral;
    private String contactotecnico;
    private String tipoproyecto;
    private String teminopago;
    private Long piezasoriginales;
    private Long piezasespejo;
    private Long totalpiezas;
    @Column(name = "fechaalta")
    private LocalDateTime fechaalta;
    private LocalDateTime fechalimite;
    private Long total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getTekid() {
        return tekid;
    }

    public void setTekid(String tekid) {
        this.tekid = tekid;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContactogeneral() {
        return contactogeneral;
    }

    public void setContactogeneral(String contactogeneral) {
        this.contactogeneral = contactogeneral;
    }

    public String getContactotecnico() {
        return contactotecnico;
    }

    public void setContactotecnico(String contactotecnico) {
        this.contactotecnico = contactotecnico;
    }

    public String getTipoproyecto() {
        return tipoproyecto;
    }

    public void setTipoproyecto(String tipoproyecto) {
        this.tipoproyecto = tipoproyecto;
    }

    public String getTeminopago() {
        return teminopago;
    }

    public void setTeminopago(String teminopago) {
        this.teminopago = teminopago;
    }

    public Long getPiezasoriginales() {
        return piezasoriginales;
    }

    public void setPiezasoriginales(Long piezasoriginales) {
        this.piezasoriginales = piezasoriginales;
    }

    public Long getPiezasespejo() {
        return piezasespejo;
    }

    public void setPiezasespejo(Long piezasespejo) {
        this.piezasespejo = piezasespejo;
    }

    public Long getTotalpiezas() {
        return totalpiezas;
    }

    public void setTotalpiezas(Long totalpiezas) {
        this.totalpiezas = totalpiezas;
    }

    public LocalDateTime getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(LocalDateTime fechaalta) {
        this.fechaalta = fechaalta;
    }

    public LocalDateTime getFechalimite() {
        return fechalimite;
    }

    public void setFechalimite(LocalDateTime fechalimite) {
        this.fechalimite = fechalimite;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}

