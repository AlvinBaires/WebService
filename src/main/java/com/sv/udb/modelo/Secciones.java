/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "secciones", catalog = "webservices", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secciones.findAll", query = "SELECT s FROM Secciones s"),
    @NamedQuery(name = "Secciones.findByCodi", query = "SELECT s FROM Secciones s WHERE s.codi = :codi"),
    @NamedQuery(name = "Secciones.findByNomb", query = "SELECT s FROM Secciones s WHERE s.nomb = :nomb"),
    @NamedQuery(name = "Secciones.findByDesc", query = "SELECT s FROM Secciones s WHERE s.desc = :desc"),
    @NamedQuery(name = "Secciones.findByGrad", query = "SELECT s FROM Secciones s WHERE s.grad = :grad")})
public class Secciones implements Serializable {

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
    @Column(name = "\"desc\"")
    private String desc;
    @Size(max = 100)
    @Column(name = "grad")
    private String grad;
    @OneToMany(mappedBy = "codiSecc", fetch = FetchType.EAGER)
    private List<Seccalum> seccalumList;
    @OneToMany(mappedBy = "codiSecc", fetch = FetchType.EAGER)
    private List<Seccempl> seccemplList;

    public Secciones() {
    }

    public Secciones(Integer codi) {
        this.codi = codi;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    @XmlTransient
    public List<Seccalum> getSeccalumList() {
        return seccalumList;
    }

    public void setSeccalumList(List<Seccalum> seccalumList) {
        this.seccalumList = seccalumList;
    }

    @XmlTransient
    public List<Seccempl> getSeccemplList() {
        return seccemplList;
    }

    public void setSeccemplList(List<Seccempl> seccemplList) {
        this.seccemplList = seccemplList;
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
        if (!(object instanceof Secciones)) {
            return false;
        }
        Secciones other = (Secciones) object;
        if ((this.codi == null && other.codi != null) || (this.codi != null && !this.codi.equals(other.codi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Secciones[ codi=" + codi + " ]";
    }
    
}
