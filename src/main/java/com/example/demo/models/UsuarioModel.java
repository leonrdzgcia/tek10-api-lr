package com.example.demo.models;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String paterno;
    private String materno;
    private String telefono;
    private String correo;
    private String password;
    private String confirmarPassword;
    private String estatus;
    private String perfil;
    private boolean terminos;
    private String tekid;
    private LocalDateTime fechaalta;
    private String direccion;
    private String nombreFiscal;
    private String rfc;
    private String codigopostal;
    private String direccionFiscal;
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
    public String getPaterno() {
        return paterno;
    }
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    public String getMaterno() {
        return materno;
    }
    public void setMaterno(String materno) {
        this.materno = materno;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmarPassword() {
        return confirmarPassword;
    }
    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public boolean isTerminos() {
        return terminos;
    }
    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }
    public LocalDateTime getFechaalta() {
        return fechaalta;
    }
    public void setFechaalta(LocalDateTime fechaalta) {
        this.fechaalta = fechaalta;
    }
    public String getTekid() {
        return tekid;
    }
    public void setTekid(String tekid) {
        this.tekid = tekid;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNombreFiscal() {
        return nombreFiscal;
    }
    public void setNombreFiscal(String nombreFiscal) {
        this.nombreFiscal = nombreFiscal;
    }
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public String getCodigopostal() {
        return codigopostal;
    }
    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }
    public String getDireccionFiscal() {
        return direccionFiscal;
    }
    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }
}
