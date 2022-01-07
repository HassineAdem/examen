package ExamenAhmed.Abdelkefi.controller;

import ExamenAhmed.Abdelkefi.model.Formateur;
import ExamenAhmed.Abdelkefi.model.Formation;
import ExamenAhmed.Abdelkefi.repository.FormateurRepository;
import ExamenAhmed.Abdelkefi.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/formateur")
public class FormateurController {
    @Autowired
    private FormateurRepository formateurRepository;
    @Autowired
    private FormationRepository formationRepository;
    @PostMapping
    public void ajouterFormateur (@RequestBody Formateur formateur){

        this.formateurRepository.save(formateur);
    }
    @GetMapping ("/{id}/{dateDebut}/{dateFin}")
    public Integer getFormateurRemunurationByDate (@PathVariable Integer formateurId,
    @PathVariable Date dateDebut,@PathVariable Date dateFin){
        Integer sum= 0;
    Formateur formateur = formateurRepository.findById(formateurId).get();
        List<Formation> list =formateur.getFormation();
        for (Formation formation:list
             ) {
            if (formation.getDateDebut().after(dateDebut) && formation.getDateFin().before(dateFin)){
                sum += formateur.getTarifHoraire() * formation.getDateFin() - formation.getDateDebut();
            }

        }
    }

}
