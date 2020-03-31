/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author maxen
 */
@Entity
@Table(name = "annee")
@NamedQueries({
    @NamedQuery(name = "Annee.findAll", query = "SELECT a FROM Annee a")
    ,
    @NamedQuery(name = "Annee.findById", query = "SELECT a FROM Annee a WHERE a.id = :id")
    ,
    @NamedQuery(name = "Annee.findByAnnee", query = "SELECT a FROM Annee a WHERE a.annee = :annee")})
public class Annee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "annee")
    private String annee;
    @ManyToMany(mappedBy = "anneeCollection")
    private Collection<Etudiant> etudiantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnnee")
    private Collection<Etudiant> etudiantCollection1;

    public Annee() {
    }

    public Annee(Integer id) {
        this.id = id;
    }

    public Annee(Integer id, String annee) {
        this.id = id;
        this.annee = annee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Collection<Etudiant> getEtudiantCollection() {
        return etudiantCollection;
    }

    public void setEtudiantCollection(Collection<Etudiant> etudiantCollection) {
        this.etudiantCollection = etudiantCollection;
    }

    public Collection<Etudiant> getEtudiantCollection1() {
        return etudiantCollection1;
    }

    public void setEtudiantCollection1(Collection<Etudiant> etudiantCollection1) {
        this.etudiantCollection1 = etudiantCollection1;
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
        if (!(object instanceof Annee)) {
            return false;
        }
        Annee other = (Annee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Annee[ id=" + id + " ]";
    }

}
