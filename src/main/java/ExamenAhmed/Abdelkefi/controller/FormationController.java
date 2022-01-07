package ExamenAhmed.Abdelkefi.controller;

import ExamenAhmed.Abdelkefi.model.Apprenant;
import ExamenAhmed.Abdelkefi.model.Formation;
import ExamenAhmed.Abdelkefi.repository.ApprenantRepository;
import ExamenAhmed.Abdelkefi.repository.FormateurRepository;
import ExamenAhmed.Abdelkefi.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationController {
    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private FormateurRepository formateurRepository;
    @Autowired
    private ApprenantRepository apprenantRepository;
    @PostMapping
    public void ajouterEtAffecterFormationAFormateur(@RequestBody Formation formation, @RequestParam Integer idFormateur){
        formation.setFormateur(formateurRepository.findById(idFormateur).get());

        this.formationRepository.save(formation);
    }
    @PostMapping
    public void affecterApprenantFormation(@RequestParam Integer idApprenant,@RequestParam Integer idFormation){
        Formation formation= this.formationRepository.findById(idFormation).get();
        Apprenant apprenant= this.apprenantRepository.findById(idApprenant).get();
        if (formation.getNbrMaxParticipant() < formation.getApprenantList().size()){
             throw new RuntimeException("You cannot add anymore");
        }
        formation.getApprenantList().add(apprenant);
        this.formationRepository.save(formation);
    }
    @PostConstruct
    public void getNbrApprenantByFormation () throws InterruptedException {
        List<Formation> formationList= formationRepository.findAll();
        while(true) {
            for (Formation formation :
                    formationList) {
                System.out.println("la formation :" + formation.getTitre() + " contient" + formation.getApprenantList().size()+ " apprenant");
            }
            Thread.sleep(30000);
        }
    }
    @GetMapping("/revenu")
    public Integer getRevenuByFormation (@RequestParam Integer formationId){
        Formation formation = formationRepository.findById(formationId).get();
        return formation.getFrais() * formation.getApprenantList().size();

    }

}
