/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "alumnos", catalog = "webservices", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a"),
    @NamedQuery(name = "Alumnos.findByCodi", query = "SELECT a FROM Alumnos a WHERE a.codi = :codi"),
    @NamedQuery(name = "Alumnos.findByCarn", query = "SELECT a FROM Alumnos a WHERE a.carn = :carn"),
    @NamedQuery(name = "Alumnos.findByNomb", query = "SELECT a FROM Alumnos a WHERE a.nomb = :nomb"),
    @NamedQuery(name = "Alumnos.findByApel", query = "SELECT a FROM Alumnos a WHERE a.apel = :apel"),
    @NamedQuery(name = "Alumnos.findByMail", query = "SELECT a FROM Alumnos a WHERE a.mail = :mail"),
    @NamedQuery(name = "Alumnos.findByGrad", query = "SELECT a FROM Alumnos a WHERE a.grad = :grad"),
    @NamedQuery(name = "Alumnos.findByEspe", query = "SELECT a FROM Alumnos a WHERE a.espe = :espe"),
    @NamedQuery(name = "Alumnos.findByGrup", query = "SELECT a FROM Alumnos a WHERE a.grup = :grup"),
    @NamedQuery(name = "Alumnos.findBySeccAcad", query = "SELECT a FROM Alumnos a WHERE a.seccAcad = :seccAcad"),
    @NamedQuery(name = "Alumnos.findBySeccTecn", query = "SELECT a FROM Alumnos a WHERE a.seccTecn = :seccTecn"),
    @NamedQuery(name = "Alumnos.findByDire", query = "SELECT a FROM Alumnos a WHERE a.dire = :dire"),
    @NamedQuery(name = "Alumnos.findByTele", query = "SELECT a FROM Alumnos a WHERE a.tele = :tele"),
    @NamedQuery(name = "Alumnos.findByLugaNaci", query = "SELECT a FROM Alumnos a WHERE a.lugaNaci = :lugaNaci"),
    @NamedQuery(name = "Alumnos.findByFechNaci", query = "SELECT a FROM Alumnos a WHERE a.fechNaci = :fechNaci"),
    @NamedQuery(name = "Alumnos.findByFina", query = "SELECT a FROM Alumnos a WHERE a.fina = :fina"),
    @NamedQuery(name = "Alumnos.findByInstOrig", query = "SELECT a FROM Alumnos a WHERE a.instOrig = :instOrig"),
    @NamedQuery(name = "Alumnos.findByEsta", query = "SELECT a FROM Alumnos a WHERE a.esta = :esta")})
public class Alumnos implements Serializable {

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi")
    private Integer codi;
    @Size(max = 100)
    @Column(name = "carn")
    private String carn;
    @Size(max = 100)
    @Column(name = "nomb")
    private String nomb;
    @Size(max = 100)
    @Column(name = "apel")
    private String apel;
    @Size(max = 100)
    @Column(name = "mail")
    private String mail;
    @Size(max = 10)
    @Column(name = "grad")
    private String grad;
    @Size(max = 50)
    @Column(name = "espe")
    private String espe;
    @Size(max = 10)
    @Column(name = "grup")
    private String grup;
    @Size(max = 10)
    @Column(name = "secc_acad")
    private String seccAcad;
    @Size(max = 10)
    @Column(name = "secc_tecn")
    private String seccTecn;
    @Size(max = 100)
    @Column(name = "dire")
    private String dire;
    @Size(max = 100)
    @Column(name = "reli")
    private String reli;
    @Size(max = 9)
    @Column(name = "tele")
    private String tele;
    @Size(max = 100)
    @Column(name = "luga_naci")
    private String lugaNaci;
    @Column(name = "fech_naci")
    @Temporal(TemporalType.DATE)
    private Date fechNaci;
    @Size(max = 100)
    @Column(name = "fina")
    private String fina;
    @Size(max = 100)
    @Column(name = "inst_orig")
    private String instOrig;
    @Column(name = "esta")
    private Integer esta;
    @OneToMany(mappedBy = "codiAlum", fetch = FetchType.EAGER)
    private List<Seccalum> seccalumList;
    @OneToMany(mappedBy = "codiAlum", fetch = FetchType.EAGER)
    private List<Famialum> famialumList;
    @OneToMany(mappedBy = "codiAlum", fetch = FetchType.EAGER)
    private List<Usuarios> usuariosList;

    public Alumnos() {
    }

    public Alumnos(Integer codi) {
        this.codi = codi;
    }

    public Integer getCodi() {
        return codi;
    }

    public void setCodi(Integer codi) {
        this.codi = codi;
    }

    public String getCarn() {
        return carn;
    }

    public void setCarn(String carn) {
        this.carn = carn;
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


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getEspe() {
        return espe;
    }

    public void setEspe(String espe) {
        this.espe = espe;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public String getSeccAcad() {
        return seccAcad;
    }

    public void setSeccAcad(String seccAcad) {
        this.seccAcad = seccAcad;
    }

    public String getSeccTecn() {
        return seccTecn;
    }

    public void setSeccTecn(String seccTecn) {
        this.seccTecn = seccTecn;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getReli() {
        return reli;
    }

    public void setReli(String reli) {
        this.reli = reli;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getLugaNaci() {
        return lugaNaci;
    }

    public void setLugaNaci(String lugaNaci) {
        this.lugaNaci = lugaNaci;
    }

    public Date getFechNaci() {
        return fechNaci;
    }

    public void setFechNaci(Date fechNaci) {
        this.fechNaci = fechNaci;
    }

    public String getFina() {
        return fina;
    }

    public void setFina(String fina) {
        this.fina = fina;
    }

    public String getInstOrig() {
        return instOrig;
    }

    public void setInstOrig(String instOrig) {
        this.instOrig = instOrig;
    }

    public Integer getEsta() {
        return esta;
    }

    public void setEsta(Integer esta) {
        this.esta = esta;
    }

    @XmlTransient
    public List<Seccalum> getSeccalumList() {
        return seccalumList;
    }

    public void setSeccalumList(List<Seccalum> seccalumList) {
        this.seccalumList = seccalumList;
    }

    @XmlTransient
    public List<Famialum> getFamialumList() {
        return famialumList;
    }

    public void setFamialumList(List<Famialum> famialumList) {
        this.famialumList = famialumList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
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
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.codi == null && other.codi != null) || (this.codi != null && !this.codi.equals(other.codi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Alumnos[ codi=" + codi + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
