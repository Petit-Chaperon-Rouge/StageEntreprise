package org.stageentrp.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "enseignant")
public class Enseignant {
    private int id;
    private String nom;
    private List<Convention> conventions;

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
     * @return the conventions
     */
    @OneToMany(mappedBy = "enseignant", fetch = FetchType.EAGER)
    public List<Convention> getConventions() {
        return conventions;
    }

    /**
     * @param conventions the conventions to set
     */
    public void setConventions(List<Convention> conventions) {
        this.conventions = conventions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignant that = (Enseignant) o;
        return id == that.id && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }
}
