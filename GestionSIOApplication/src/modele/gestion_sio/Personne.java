/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.gestion_sio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author maxen
 */
@Entity
@Table(name = "personne")
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findById", query = "SELECT p FROM Personne p WHERE p.id = :id"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personne.findByEmail", query = "SELECT p FROM Personne p WHERE p.email = :email"),
    @NamedQuery(name = "Personne.findByTelephone", query = "SELECT p FROM Personne p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Personne.findByCivilite", query = "SELECT p FROM Personne p WHERE p.civilite = :civilite"),
    @NamedQuery(name = "Personne.findByVille", query = "SELECT p FROM Personne p WHERE p.ville = :ville"),
    @NamedQuery(name = "Personne.findByAdresse", query = "SELECT p FROM Personne p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Personne.findByCodePostal", query = "SELECT p FROM Personne p WHERE p.codePostal = :codePostal")})
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @Column(name = "civilite")
    private String civilite;
    @Basic(optional = false)
    @Column(name = "ville")
    private String ville;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "codePostal")
    private int codePostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Professionnel> professionnelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Utilisateur> utilisateurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Professeur> professeurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Etudiant> etudiantCollection;

    public Personne() {
    }

    public Personne(Integer id) {
        this.id = id;
    }

    public Personne(Integer id, String nom, String prenom, String email, String telephone, String civilite, String ville, String adresse, int codePostal) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.civilite = civilite;
        this.ville = ville;
        this.adresse = adresse;
        this.codePostal = codePostal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public Collection<Professionnel> getProfessionnelCollection() {
        return professionnelCollection;
    }

    public void setProfessionnelCollection(Collection<Professionnel> professionnelCollection) {
        this.professionnelCollection = professionnelCollection;
    }

    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    public Collection<Professeur> getProfesseurCollection() {
        return professeurCollection;
    }

    public void setProfesseurCollection(Collection<Professeur> professeurCollection) {
        this.professeurCollection = professeurCollection;
    }

    public Collection<Etudiant> getEtudiantCollection() {
        return etudiantCollection;
    }

    public void setEtudiantCollection(Collection<Etudiant> etudiantCollection) {
        this.etudiantCollection = etudiantCollection;
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
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Personne[ id=" + id + " ]";
    }
    
}
