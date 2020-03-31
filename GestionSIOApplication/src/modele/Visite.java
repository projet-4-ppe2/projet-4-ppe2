/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maxen
 */
@Entity
@Table(name = "visite")
@NamedQueries({
    @NamedQuery(name = "Visite.findAll", query = "SELECT v FROM Visite v"),
    @NamedQuery(name = "Visite.findById", query = "SELECT v FROM Visite v WHERE v.id = :id"),
    @NamedQuery(name = "Visite.findByDate", query = "SELECT v FROM Visite v WHERE v.date = :date"),
    @NamedQuery(name = "Visite.findByJury", query = "SELECT v FROM Visite v WHERE v.jury = :jury"),
    @NamedQuery(name = "Visite.findByStage1", query = "SELECT v FROM Visite v WHERE v.stage1 = :stage1"),
    @NamedQuery(name = "Visite.findByStage2", query = "SELECT v FROM Visite v WHERE v.stage2 = :stage2")})
public class Visite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "jury")
    private boolean jury;
    @Basic(optional = false)
    @Column(name = "stage1")
    private boolean stage1;
    @Basic(optional = false)
    @Column(name = "stage2")
    private boolean stage2;
    @JoinColumn(name = "id_stage", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stage idStage;
    @JoinColumn(name = "id_professeur", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Professeur idProfesseur;

    public Visite() {
    }

    public Visite(Integer id) {
        this.id = id;
    }

    public Visite(Integer id, Date date, boolean jury, boolean stage1, boolean stage2) {
        this.id = id;
        this.date = date;
        this.jury = jury;
        this.stage1 = stage1;
        this.stage2 = stage2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getJury() {
        return jury;
    }

    public void setJury(boolean jury) {
        this.jury = jury;
    }

    public boolean getStage1() {
        return stage1;
    }

    public void setStage1(boolean stage1) {
        this.stage1 = stage1;
    }

    public boolean getStage2() {
        return stage2;
    }

    public void setStage2(boolean stage2) {
        this.stage2 = stage2;
    }

    public Stage getIdStage() {
        return idStage;
    }

    public void setIdStage(Stage idStage) {
        this.idStage = idStage;
    }

    public Professeur getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Professeur idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visite)) {
            return false;
        }
        Visite other = (Visite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Visite[ id=" + id + " ]";
    }
    
}
