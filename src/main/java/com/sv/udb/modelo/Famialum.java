/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "famialum", catalog = "webservices", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Famialum.findAll", query = "SELECT f FROM Famialum f"),
    @NamedQuery(name = "Famialum.findByCodi", query = "SELECT f FROM Famialum f WHERE f.codi = :codi"),
    @NamedQuery(name = "Famialum.findByNomb", query = "SELECT f FROM Famialum f WHERE f.nomb = :nomb"),
    @NamedQuery(name = "Famialum.findByApel", query = "SELECT f FROM Famialum f WHERE f.apel = :apel"),
    @NamedQuery(name = "Famialum.findByPare", query = "SELECT f FROM Famialum f WHERE f.pare = :pare"),
    @NamedQuery(name = "Famialum.findByEsta", query = "SELECT f FROM Famialum f WHERE f.esta = :esta")})
public class Famialum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi")
    private Integer codi;
    @Size(max = 100)
    @Column(name = "nomb")
    private String nomb;
    @Size(max = 100)
    @Column(name = "apel")
    private String apel;
    @Size(max = 100)
    @Column(name = "pare")
    private String pare;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta")
    private int esta;
    @JoinColumn(name = "codi_alum", referencedColumnName = "codi")
    @ManyToOne(fetch = FetchType.EAGER)
    private Alumnos codiAlum;

    public Famialum() {
    }

    public Famialum(Integer codi) {
        this.codi = codi;
    }

    public Famialum(Integer codi, int esta) {
        this.codi = codi;
        this.esta = esta;
    }

    public Integer getCodi() {
        return codi;
    }

    public void setCodi(Integer codi) {
        this.codi = codi;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getApel() {
        return apel;
    }

    public void setApel(String apel) {
        this.apel = apel;
    }

    public String getPare() {
        return pare;
    }

    public void setPare(String pare) {
        this.pare = pare;
    }

    public int getEsta() {
        return esta;
    }

    public void setEsta(int esta) {
        this.esta = esta;
    }

    public Alumnos getCodiAlum() {
        return codiAlum;
    }

    public void setCodiAlum(Alumnos codiAlum) {
        this.codiAlum = codiAlum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codi != null ? codi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famialum)) {
            return false;
        }
        Famialum other = (Famialum) object;
        if ((this.codi == null && other.codi != null) || (this.codi != null && !this.codi.equals(other.codi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Famialum[ codi=" + codi + " ]";
    }
    
}
