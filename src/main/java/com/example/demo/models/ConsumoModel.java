package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consumo_diesel")
public class ConsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idconsumodiesel;
    /*@Column(name = "fecha")
    private LocalDateTime fecha;*/
    @Column(name = "operador")
    private String operador;
    @Column(name = "eco")
    private String eco;
    @Column(name = "capacidad")
    private Long capacidad;
    @Column(name = "destino")
    private String destino;
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "conf_vehicular")
    private String confvehicular;
    @Column(name = "plataforma")
    private String plataforma;
    @Column(name = "peso")
    private String peso;
    @Column(name = "diesel")
    private Long diesel;
    @Column(name = "carga_1")
    private Long carga1;
    @Column(name = "gasolinera_1")
    private String gasolinera1;
    @Column(name = "carga_2")
    private Long carga2;
    @Column(name = "gasolinera_2")
    private String gasolinera2;
    @Column(name = "carga_3")
    private Long carga3;
    @Column(name = "gasolinera_3")
    private String gasolinera3;
    @Column(name = "total_diesel")
    private Long totaldiesel;
    @Column(name = "regresa_cargado")
    private String regresacargado;
    @Column(name = "cliente_regreso")
    private String clienteregreso;
    @Column(name = "peso_regreso")
    private Long pesoregreso;
    @Column(name = "diesel_extra")
    private Long dieselextra;

    public Long getIdconsumodiesel() {
        return idconsumodiesel;
    }

    public void setIdconsumodiesel(Long idconsumodiesel) {
        this.idconsumodiesel = idconsumodiesel;
    }
    /*public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }*/
    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getEco() {
        return eco;
    }

    public void setEco(String eco) {
        this.eco = eco;
    }

    public Long getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getConfvehicular() {
        return confvehicular;
    }

    public void setConfvehicular(String confvehicular) {
        this.confvehicular = confvehicular;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Long getDiesel() {
        return diesel;
    }

    public void setDiesel(Long diesel) {
        this.diesel = diesel;
    }

    public Long getCarga1() {
        return carga1;
    }

    public void setCarga1(Long carga1) {
        this.carga1 = carga1;
    }

    public String getGasolinera1() {
        return gasolinera1;
    }

    public void setGasolinera1(String gasolinera1) {
        this.gasolinera1 = gasolinera1;
    }

    public Long getCarga2() {
        return carga2;
    }

    public void setCarga2(Long carga2) {
        this.carga2 = carga2;
    }

    public String getGasolinera2() {
        return gasolinera2;
    }

    public void setGasolinera2(String gasolinera2) {
        this.gasolinera2 = gasolinera2;
    }

    public Long getCarga3() {
        return carga3;
    }

    public void setCarga3(Long carga3) {
        this.carga3 = carga3;
    }

    public String getGasolinera3() {
        return gasolinera3;
    }

    public void setGasolinera3(String gasolinera3) {
        this.gasolinera3 = gasolinera3;
    }

    public Long getTotaldiesel() {
        return totaldiesel;
    }

    public void setTotaldiesel(Long totaldiesel) {
        this.totaldiesel = totaldiesel;
    }

    public String getRegresacargado() {
        return regresacargado;
    }

    public void setRegresacargado(String regresacargado) {
        this.regresacargado = regresacargado;
    }

    public String getClienteregreso() {
        return clienteregreso;
    }

    public void setClienteregreso(String clienteregreso) {
        this.clienteregreso = clienteregreso;
    }

    public Long getPesoregreso() {
        return pesoregreso;
    }

    public void setPesoregreso(Long pesoregreso) {
        this.pesoregreso = pesoregreso;
    }

    public Long getDieselextra() {
        return dieselextra;
    }

    public void setDieselextra(Long dieselextra) {
        this.dieselextra = dieselextra;
    }
}
