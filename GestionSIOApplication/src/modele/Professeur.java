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
@Table(name = "professeur")
@NamedQueries({
    @NamedQuery(name = "Professeur.findAll", query = "SELECT p FROM Professeur p"),
    @NamedQuery(name = "Professeur.findById", query = "SELECT p FROM Professeur p WHERE p.id = :id")})
public class Professeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesseur")
    private Collection<Visite> visiteCollection;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;

    public Professeur() {
    }

    public Professeur(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Visite> getVisiteCollection() {
        return visiteCollection;
    }

    public void setVisiteCollection(Collection<Visite> visiteCollection) {
        this.visiteCollection = visiteCollection;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
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
        if (!(object instanceof Professeur)) {
            return false;
        }
        Professeur other = (Professeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Professeur[ id=" + id + " ]";
    }
    
}
