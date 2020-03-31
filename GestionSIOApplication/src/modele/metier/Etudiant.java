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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author maxen
 */
@Entity
@Table(name = "etudiant")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findById", query = "SELECT e FROM Etudiant e WHERE e.id = :id"),
    @NamedQuery(name = "Etudiant.findByIdStage", query = "SELECT e FROM Etudiant e WHERE e.idStage = :idStage")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_stage")
    private int idStage;
    @JoinTable(name = "promotion", joinColumns = {
        @JoinColumn(name = "id_etudiant", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_annee", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Annee> anneeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtudiant")
    private Collection<Stage> stageCollection;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;
    @JoinColumn(name = "id_annee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Annee idAnnee;
    @JoinColumn(name = "id_option", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Option idOption;

    public Etudiant() {
    }

    public Etudiant(Integer id) {
        this.id = id;
    }

    public Etudiant(Integer id, int idStage) {
        this.id = id;
        this.idStage = idStage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdStage() {
        return idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }

    public Collection<Annee> getAnneeCollection() {
        return anneeCollection;
    }

    public void setAnneeCollection(Collection<Annee> anneeCollection) {
        this.anneeCollection = anneeCollection;
    }

    public Collection<Stage> getStageCollection() {
        return stageCollection;
    }

    public void setStageCollection(Collection<Stage> stageCollection) {
        this.stageCollection = stageCollection;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Annee getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(Annee idAnnee) {
        this.idAnnee = idAnnee;
    }

    public Option getIdOption() {
        return idOption;
    }

    public void setIdOption(Option idOption) {
        this.idOption = idOption;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Etudiant[ id=" + id + " ]";
    }
    
}
