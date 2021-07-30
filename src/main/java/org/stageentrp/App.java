package org.stageentrp;

import org.stageentrp.models.Etudiant;
import org.stageentrp.repositories.EtudiantRepository;

public class App {

    public static void main(String[] args) {

        EtudiantRepository etudiantRepository = new EtudiantRepository();
        Etudiant etudiant = etudiantRepository.get(1, Etudiant.class);
        System.out.println(etudiant.getPrenom() + " " + etudiant.getNom());
    }

}
