/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maxen
 */
@Entity
@Table(name = "stage")
@NamedQueries({
    @NamedQuery(name = "Stage.findAll", query = "SELECT s FROM Stage s"),
    @NamedQuery(name = "Stage.findById", query = "SELECT s FROM Stage s WHERE s.id = :id"),
    @NamedQuery(name = "Stage.findByDebut", query = "SELECT s FROM Stage s WHERE s.debut = :debut"),
    @NamedQuery(name = "Stage.findByFin", query = "SELECT s FROM Stage s WHERE s.fin = :fin"),
    @NamedQuery(name = "Stage.findBySujet", query = "SELECT s FROM Stage s WHERE s.sujet = :sujet")})
public class Stage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "debut")
    @Temporal(TemporalType.DATE)
    private Date debut;
    @Basic(optional = false)
    @Column(name = "fin")
    @Temporal(TemporalType.DATE)
    private Date fin;
    @Basic(optional = false)
    @Column(name = "sujet")
    private String sujet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStage")
    private Collection<Visite> visiteCollection;
    @JoinColumn(name = "id_etudiant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Etudiant idEtudiant;
    @JoinColumn(name = "id_professionnel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Professionnel idProfessionnel;
    @JoinColumn(name = "id_organisation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Organisation idOrganisation;

    public Stage() {
    }

    public Stage(Integer id) {
        this.id = id;
    }

    public Stage(Integer id, Date debut, Date fin, String sujet) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
        this.sujet = sujet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Collection<Visite> getVisiteCollection() {
        return visiteCollection;
    }

    public void setVisiteCollection(Collection<Visite> visiteCollection) {
        this.visiteCollection = visiteCollection;
    }

    public Etudiant getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Etudiant idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Professionnel getIdProfessionnel() {
        return idProfessionnel;
    }

    public void setIdProfessionnel(Professionnel idProfessionnel) {
        this.idProfessionnel = idProfessionnel;
    }

    public Organisation getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(Organisation idOrganisation) {
        this.idOrganisation = idOrganisation;
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
        if (!(object instanceof Stage)) {
            return false;
        }
        Stage other = (Stage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Stage[ id=" + id + " ]";
    }
    
}
