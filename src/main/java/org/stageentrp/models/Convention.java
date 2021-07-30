package org.stageentrp.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "convention")
public class Convention {
    private int id;
    private BigDecimal remunerationFinale;
    private String sujetMemoire;
    private Timestamp dateDebut;
    private Timestamp dateSignature;
    private Timestamp derniereDateVisiteEnseignant;
    private Enseignant enseignant;
    private Etudiant etudiant;
    private PropositionStage propositionStage;

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
     * @return the remunerationFinale
     */
    @Basic
    @Column(name = "remuneration_finale")
    public BigDecimal getRemunerationFinale() {
        return remunerationFinale;
    }

    /**
     * @param remunerationFinale the remunerationFinale to set
     */
    public void setRemunerationFinale(BigDecimal remunerationFinale) {
        this.remunerationFinale = remunerationFinale;
    }

    /**
     * @return the sujetMemoire
     */
    @Basic
    @Column(name = "sujet_memoire")
    public String getSujetMemoire() {
        return sujetMemoire;
    }

    /**
     * @param sujetMemoire the sujetMemoire to set
     */
    public void setSujetMemoire(String sujetMemoire) {
        this.sujetMemoire = sujetMemoire;
    }

    /**
     * @return the dateDebut
     */
    @Basic
    @Column(name = "date_debut")
    public Timestamp getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateSignature
     */
    @Basic
    @Column(name = "date_signature")
    public Timestamp getDateSignature() {
        return dateSignature;
    }

    /**
     * @param dateSignature the dateSignature to set
     */
    public void setDateSignature(Timestamp dateSignature) {
        this.dateSignature = dateSignature;
    }

    /**
     * @return the derniereDateVisiteEnseignant
     */
    @Basic
    @Column(name = "derniere_date_visite_enseignant")
    public Timestamp getDerniereDateVisiteEnseignant() {
        return derniereDateVisiteEnseignant;
    }

    /**
     * @param derniereDateVisiteEnseignant the derniereDateVisiteEnseignant to set
     */
    public void setDerniereDateVisiteEnseignant(Timestamp derniereDateVisiteEnseignant) {
        this.derniereDateVisiteEnseignant = derniereDateVisiteEnseignant;
    }

    /**
     * @return the enseignant
     */
    @ManyToOne
    @JoinColumn(name= "enseignant_id")
    public Enseignant getEnseignant() {
        return enseignant;
    }

    /**
     * @param enseignant the enseignant to set
     */
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    /**
     * @return the etudiant
     */
    @ManyToOne
    @JoinColumn(name= "etudiant_id")
    public Etudiant getEtudiant() {
        return etudiant;
    }

    /**
     * @param etudiant the etudiant to set
     */
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    /**
     * @return the propositionStage
     */
    @ManyToOne
    @JoinColumn(name= "proposition_stage_id")
    public PropositionStage getPropositionStage() {
        return propositionStage;
    }

    /**
     * @param propositionStage the propositionStage to set
     */
    public void setPropositionStage(PropositionStage propositionStage) {
        this.propositionStage = propositionStage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convention that = (Convention) o;
        return id == that.id && Objects.equals(remunerationFinale, that.remunerationFinale) && Objects.equals(sujetMemoire, that.sujetMemoire) && Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateSignature, that.dateSignature) && Objects.equals(derniereDateVisiteEnseignant, that.derniereDateVisiteEnseignant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, remunerationFinale, sujetMemoire, dateDebut, dateSignature, derniereDateVisiteEnseignant);
    }
}
