package org.stageentrp.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "entreprise")
public class Entreprise {
    private int id;
    private String nom;
    private String adresse;
    private List<PropositionStage> propositionStages;

    /**
     * @return the id
     */
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the adresse
     */
    @Basic
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the propositionStages
     */
    @OneToMany(mappedBy = "entreprise", fetch = FetchType.EAGER)
    public List<PropositionStage> getPropositionStages() {
        return propositionStages;
    }

    /**
     * @param propositionStages the propositionStages to set
     */
    public void setPropositionStages(List<PropositionStage> propositionStages) {
        this.propositionStages = propositionStages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entreprise that = (Entreprise) o;
        return id == that.id && Objects.equals(nom, that.nom) && Objects.equals(adresse, that.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, adresse);
    }
}
