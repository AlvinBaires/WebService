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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "seccempl", catalog = "webservices", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccempl.findAll", query = "SELECT s FROM Seccempl s"),
    @NamedQuery(name = "Seccempl.findByCodi", query = "SELECT s FROM Seccempl s WHERE s.codi = :codi")})
public class Seccempl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi")
    private Integer codi;
    @JoinColumn(name = "codi_secc", referencedColumnName = "codi")
    @ManyToOne(fetch = FetchType.EAGER)
    private Secciones codiSecc;
    @JoinColumn(name = "codi_empl", referencedColumnName = "codi")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empleados codiEmpl;

    public Seccempl() {
    }

    public Seccempl(Integer codi) {
        this.codi = codi;
    }

    public Integer getCodi() {
        return codi;
    }

    public void setCodi(Integer codi) {
        this.codi = codi;
    }

    public Secciones getCodiSecc() {
        return codiSecc;
    }

    public void setCodiSecc(Secciones codiSecc) {
        this.codiSecc = codiSecc;
    }

    public Empleados getCodiEmpl() {
        return codiEmpl;
    }

    public void setCodiEmpl(Empleados codiEmpl) {
        this.codiEmpl = codiEmpl;
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
        if (!(object instanceof Seccempl)) {
            return false;
        }
        Seccempl other = (Seccempl) object;
        if ((this.codi == null && other.codi != null) || (this.codi != null && !this.codi.equals(other.codi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Seccempl[ codi=" + codi + " ]";
    }
    
}
