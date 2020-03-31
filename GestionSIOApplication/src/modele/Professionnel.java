/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

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
@Table(name = "professionnel")
@NamedQueries({
    @NamedQuery(name = "Professionnel.findAll", query = "SELECT p FROM Professionnel p"),
    @NamedQuery(name = "Professionnel.findById", query = "SELECT p FROM Professionnel p WHERE p.id = :id"),
    @NamedQuery(name = "Professionnel.findByAncienEleve", query = "SELECT p FROM Professionnel p WHERE p.ancienEleve = :ancienEleve"),
    @NamedQuery(name = "Professionnel.findByFonction", query = "SELECT p FROM Professionnel p WHERE p.fonction = :fonction")})
public class Professionnel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ancien_eleve")
    private boolean ancienEleve;
    @Basic(optional = false)
    @Column(name = "fonction")
    private String fonction;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfessionnel")
    private Collection<Stage> stageCollection;

    public Professionnel() {
    }

    public Professionnel(Integer id) {
        this.id = id;
    }

    public Professionnel(Integer id, boolean ancienEleve, String fonction) {
        this.id = id;
        this.ancienEleve = ancienEleve;
        this.fonction = fonction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAncienEleve() {
        return ancienEleve;
    }

    public void setAncienEleve(boolean ancienEleve) {
        this.ancienEleve = ancienEleve;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Collection<Stage> getStageCollection() {
        return stageCollection;
    }

    public void setStageCollection(Collection<Stage> stageCollection) {
        this.stageCollection = stageCollection;
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
        if (!(object instanceof Professionnel)) {
            return false;
        }
        Professionnel other = (Professionnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Professionnel[ id=" + id + " ]";
    }
    
}
