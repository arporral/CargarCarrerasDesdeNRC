/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.tablas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arpor
 */
@Entity
@Table(name = "carrerasnrc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrerasnrc.findAll", query = "SELECT c FROM Carrerasnrc c"),
    @NamedQuery(name = "Carrerasnrc.findByNumSec", query = "SELECT c FROM Carrerasnrc c WHERE c.numSec = :numSec"),
    @NamedQuery(name = "Carrerasnrc.findByFecha", query = "SELECT c FROM Carrerasnrc c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Carrerasnrc.findByDuracion", query = "SELECT c FROM Carrerasnrc c WHERE c.duracion = :duracion"),
    @NamedQuery(name = "Carrerasnrc.findByKms", query = "SELECT c FROM Carrerasnrc c WHERE c.kms = :kms"),
    @NamedQuery(name = "Carrerasnrc.findByTipoDeEjercicio", query = "SELECT c FROM Carrerasnrc c WHERE c.tipoDeEjercicio = :tipoDeEjercicio"),
    @NamedQuery(name = "Carrerasnrc.findByPeso", query = "SELECT c FROM Carrerasnrc c WHERE c.peso = :peso"),
    @NamedQuery(name = "Carrerasnrc.findByCalorias", query = "SELECT c FROM Carrerasnrc c WHERE c.calorias = :calorias"),
    @NamedQuery(name = "Carrerasnrc.findByPasos", query = "SELECT c FROM Carrerasnrc c WHERE c.pasos = :pasos"),
    @NamedQuery(name = "Carrerasnrc.findBySensaciones", query = "SELECT c FROM Carrerasnrc c WHERE c.sensaciones = :sensaciones"),
    @NamedQuery(name = "Carrerasnrc.findByCalzado", query = "SELECT c FROM Carrerasnrc c WHERE c.calzado = :calzado"),
    @NamedQuery(name = "Carrerasnrc.findByTerreno", query = "SELECT c FROM Carrerasnrc c WHERE c.terreno = :terreno"),
    @NamedQuery(name = "Carrerasnrc.findByClima", query = "SELECT c FROM Carrerasnrc c WHERE c.clima = :clima"),
    @NamedQuery(name = "Carrerasnrc.findByTemperatura", query = "SELECT c FROM Carrerasnrc c WHERE c.temperatura = :temperatura")})
public class Carrerasnrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_sec")
    private Integer numSec;
    @Basic(optional = false)
    @Column(name = "fecha")   
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
//    private LocalDate fecha;
    @Column(name = "duracion")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kms")
    private Double kms;
    @Lob
    @Column(name = "recorrido")
    private String recorrido;
    @Column(name = "tipo_de_ejercicio")
    private String tipoDeEjercicio;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "calorias")
    private Double calorias;
    @Column(name = "pasos")
    private Integer pasos;
    @Column(name = "sensaciones")
    private String sensaciones;
    @Column(name = "calzado")
    private String calzado;
    @Column(name = "terreno")
    private String terreno;
    @Column(name = "clima")
    private String clima;
    @Column(name = "temperatura")
    private Double temperatura;

    public Carrerasnrc() {        
    }

    public Carrerasnrc(Integer numSec) {
        this.numSec = numSec;
    }

    public Carrerasnrc(Integer numSec, Date fecha) {
        this.numSec = numSec;
        this.fecha = fecha;
    }

    public Integer getNumSec() {
        return numSec;
    }

    public void setNumSec(Integer numSec) {
        this.numSec = numSec;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public Double getKms() {
        return kms;
    }

    public void setKms(Double kms) {
        this.kms = kms;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public String getTipoDeEjercicio() {
        return tipoDeEjercicio;
    }

    public void setTipoDeEjercicio(String tipoDeEjercicio) {
        this.tipoDeEjercicio = tipoDeEjercicio;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Integer getPasos() {
        return pasos;
    }

    public void setPasos(Integer pasos) {
        this.pasos = pasos;
    }

    public String getSensaciones() {
        return sensaciones;
    }

    public void setSensaciones(String sensaciones) {
        this.sensaciones = sensaciones;
    }

    public String getCalzado() {
        return calzado;
    }

    public void setCalzado(String calzado) {
        this.calzado = calzado;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSec != null ? numSec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrerasnrc)) {
            return false;
        }
        Carrerasnrc other = (Carrerasnrc) object;
        return !((this.numSec == null && other.numSec != null) || (this.numSec != null && !this.numSec.equals(other.numSec)));
    }

    @Override
    public String toString() {
        return "com.titus.tablas.Carrerasnrc[ numSec=" + numSec + " ]";
    }
    
}
