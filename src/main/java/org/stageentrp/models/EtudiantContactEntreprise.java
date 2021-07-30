package org.stageentrp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "etudiant_contact_entreprise", schema = "stageentreprise")
public class EtudiantContactEntreprise implements Serializable {
    private int etudiantId;
    private int entrepriseId;
    private Timestamp datePriseContact;

    /**
     * @return the etudiantId
     */
    @Id
    @Column(name = "etudiant_id")
    public int getEtudiantId() {
        return etudiantId;
    }

    /**
     * @param etudiantId the etudiantId to set
     */
    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    /**
     * @return the entrepriseId
     */
    @Id
    @Column(name = "entreprise_id")
    public int getEntrepriseId() {
        return entrepriseId;
    }

    /**
     * @param entrepriseId the entrepriseId to set
     */
    public void setEntrepriseId(int entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    /**
     * @return the datePriseContact
     */
    @Basic
    @Column(name = "date_prise_contact")
    public Timestamp getDatePriseContact() {
        return datePriseContact;
    }

    /**
     * @param datePriseContact the datePriseContact to set
     */
    public void setDatePriseContact(Timestamp datePriseContact) {
        this.datePriseContact = datePriseContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtudiantContactEntreprise that = (EtudiantContactEntreprise) o;
        return etudiantId == that.etudiantId && entrepriseId == that.entrepriseId && Objects.equals(datePriseContact, that.datePriseContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etudiantId, entrepriseId, datePriseContact);
    }
}
