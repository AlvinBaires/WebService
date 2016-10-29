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
import javax.persistence.Lob;
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
@Table(name = "empleados", catalog = "webservices", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByCodi", query = "SELECT e FROM Empleados e WHERE e.codi = :codi"),
    @NamedQuery(name = "Empleados.findByNomb", query = "SELECT e FROM Empleados e WHERE e.nomb = :nomb"),
    @NamedQuery(name = "Empleados.findByApel", query = "SELECT e FROM Empleados e WHERE e.apel = :apel"),
    @NamedQuery(name = "Empleados.findByMail", query = "SELECT e FROM Empleados e WHERE e.mail = :mail"),
    @NamedQuery(name = "Empleados.findByTipoEmpl", query = "SELECT e FROM Empleados e WHERE e.tipoEmpl = :tipoEmpl"),
    @NamedQuery(name = "Empleados.findByTipoDoce", query = "SELECT e FROM Empleados e WHERE e.tipoDoce = :tipoDoce"),
    @NamedQuery(name = "Empleados.findByGrupGuia", query = "SELECT e FROM Empleados e WHERE e.grupGuia = :grupGuia"),
    @NamedQuery(name = "Empleados.findByEsta", query = "SELECT e FROM Empleados e WHERE e.esta = :esta")})
public class Empleados implements Serializable {

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
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 100)
    @Column(name = "mail")
    private String mail;
    @Column(name = "tipo_empl")
    private Integer tipoEmpl;
    @Column(name = "tipo_doce")
    private Integer tipoDoce;
    @Size(max = 50)
    @Column(name = "grup_guia")
    private String grupGuia;
    @Column(name = "esta")
    private Integer esta;
    @OneToMany(mappedBy = "codiEmpl", fetch = FetchType.EAGER)
    private List<Seccempl> seccemplList;
    @OneToMany(mappedBy = "codiEmpl", fetch = FetchType.EAGER)
    private List<Usuarios> usuariosList;

    public Empleados() {
    }

    public Empleados(Integer codi) {
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

    public String getApel() {
        return apel;
    }

    public void setApel(String apel) {
        this.apel = apel;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTipoEmpl() {
        return tipoEmpl;
    }

    public void setTipoEmpl(Integer tipoEmpl) {
        this.tipoEmpl = tipoEmpl;
    }

    public Integer getTipoDoce() {
        return tipoDoce;
    }

    public void setTipoDoce(Integer tipoDoce) {
        this.tipoDoce = tipoDoce;
    }

    public String getGrupGuia() {
        return grupGuia;
    }

    public void setGrupGuia(String grupGuia) {
        this.grupGuia = grupGuia;
    }

    public Integer getEsta() {
        return esta;
    }

    public void setEsta(Integer esta) {
        this.esta = esta;
    }

    @XmlTransient
    public List<Seccempl> getSeccemplList() {
        return seccemplList;
    }

    public void setSeccemplList(List<Seccempl> seccemplList) {
        this.seccemplList = seccemplList;
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
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.codi == null && other.codi != null) || (this.codi != null && !this.codi.equals(other.codi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Empleados[ codi=" + codi + " ]";
    }
    
}
