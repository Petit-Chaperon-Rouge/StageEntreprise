package org.stageentrp;

import org.stageentrp.models.Entreprise;
import org.stageentrp.models.Etudiant;
import org.stageentrp.models.PropositionStage;
import org.stageentrp.repositories.EntrepriseRepository;
import org.stageentrp.repositories.EtudiantRepository;
import org.stageentrp.repositories.PropositionStageRepository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {

//        EtudiantRepository etudiantRepository = new EtudiantRepository();
//        Etudiant etudiant = etudiantRepository.get(1, Etudiant.class);
//        System.out.println(etudiant.getPrenom() + " " + etudiant.getNom());

        EntrepriseRepository entrepriseRepository = new EntrepriseRepository();
//        Entreprise entreprise = new Entreprise();
//        entreprise.setNom("MacDo");
//        entreprise.setAdresse("3 rue de Lille");
//
//        entrepriseRepository.save(entreprise);

        List<Entreprise> entreprises = entrepriseRepository.getAll(Entreprise.class);

        entreprises.forEach(entrp -> {
            System.out.println(entrp.getNom() + " localisée " + entrp.getAdresse());
            if (!entrp.getPropositionStages().isEmpty()) {
                entrp.getPropositionStages().forEach(proposition -> {
                    System.out.println(" sujet du stage : " + proposition.getSujetPropose());
                });
            }
        });

//        PropositionStageRepository propositionStageRepository = new PropositionStageRepository();
//        PropositionStage propositionStage = new PropositionStage();
//        propositionStage.setSujetPropose("Un très long sujet, très très long");
//        propositionStage.setDateProposition(new Timestamp(System.currentTimeMillis()));
//        propositionStage.setDuree(45);
//        propositionStage.setRemuneration(new BigDecimal("752.47"));
//        propositionStage.setEntreprise(entreprises.get(1));
//
//        propositionStageRepository.save(propositionStage);


    }

}
