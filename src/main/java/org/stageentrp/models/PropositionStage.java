package org.stageentrp.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "proposition_stage", schema = "stageentreprise")
public class PropositionStage {
    private int id;
    private String sujetPropose;
    private Timestamp dateProposition;
    private Integer duree;
    private BigDecimal remuneration;

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
     * @return the sujetPropose
     */
    @Basic
    @Column(name = "sujet_propose")
    public String getSujetPropose() {
        return sujetPropose;
    }

    /**
     * @param sujetPropose the sujetPropose to set
     */
    public void setSujetPropose(String sujetPropose) {
        this.sujetPropose = sujetPropose;
    }

    /**
     * @return the dateProposition
     */
    @Basic
    @Column(name = "date_proposition")
    public Timestamp getDateProposition() {
        return dateProposition;
    }

    /**
     * @param dateProposition the dateProposition to set
     */
    public void setDateProposition(Timestamp dateProposition) {
        this.dateProposition = dateProposition;
    }

    /**
     * @return the duree
     */
    @Basic
    @Column(name = "duree")
    public Integer getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    /**
     * @return the remuneration
     */
    @Basic
    @Column(name = "remuneration")
    public BigDecimal getRemuneration() {
        return remuneration;
    }

    /**
     * @param remuneration the remuneration to set
     */
    public void setRemuneration(BigDecimal remuneration) {
        this.remuneration = remuneration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropositionStage that = (PropositionStage) o;
        return id == that.id && Objects.equals(sujetPropose, that.sujetPropose) && Objects.equals(dateProposition, that.dateProposition) && Objects.equals(duree, that.duree) && Objects.equals(remuneration, that.remuneration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sujetPropose, dateProposition, duree, remuneration);
    }
}
