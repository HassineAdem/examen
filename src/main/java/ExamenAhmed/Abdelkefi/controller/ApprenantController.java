package ExamenAhmed.Abdelkefi.controller;

import ExamenAhmed.Abdelkefi.model.Apprenant;
import ExamenAhmed.Abdelkefi.repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apprenant")
public class ApprenantController {
    @Autowired
    private ApprenantRepository apprenantRepository;
    @PostMapping
    public void ajouterApprenante(@RequestBody Apprenant apprenant){
        this.apprenantRepository.save(apprenant);
    }

}
