/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

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
@Table(name = "carreiras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carreiras.findAll", query = "SELECT c FROM Carreiras c"),
    @NamedQuery(name = "Carreiras.findByNumSec", query = "SELECT c FROM Carreiras c WHERE c.numSec = :numSec"),
    @NamedQuery(name = "Carreiras.findByFecha", query = "SELECT c FROM Carreiras c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Carreiras.findByDuracion", query = "SELECT c FROM Carreiras c WHERE c.duracion = :duracion"),
    @NamedQuery(name = "Carreiras.findByKms", query = "SELECT c FROM Carreiras c WHERE c.kms = :kms"),
    @NamedQuery(name = "Carreiras.findByTipoDeEjercicio", query = "SELECT c FROM Carreiras c WHERE c.tipoDeEjercicio = :tipoDeEjercicio"),
    @NamedQuery(name = "Carreiras.findByPeso", query = "SELECT c FROM Carreiras c WHERE c.peso = :peso")})
public class Carreiras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_sec")
    private Integer numSec;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
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

    public Carreiras() {
    }

    public Carreiras(Integer numSec) {
        this.numSec = numSec;
    }

    public Carreiras(Integer numSec, Date fecha) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSec != null ? numSec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carreiras)) {
            return false;
        }
        Carreiras other = (Carreiras) object;
        if ((this.numSec == null && other.numSec != null) || (this.numSec != null && !this.numSec.equals(other.numSec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.titus.carreras.Carreiras[ numSec=" + numSec + " ]";
    }
    
}
