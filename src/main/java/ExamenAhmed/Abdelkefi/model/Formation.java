package ExamenAhmed.Abdelkefi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Formation {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormation;
    private String titre;
    private Niveau niveau;
    @DateTimeFormat(pattern = "yyyy_MM_dd")
    private Date dateDebut;
    @DateTimeFormat(pattern = "yyyy_MM_dd")
    private Date dateFin;
    private Integer nbrHeure;
    private Integer nbrMaxParticipant;
    private Integer frais;
    @ManyToOne
    @JoinColumn(name = "formateur_id",referencedColumnName = "idFormateur")
    private Formateur formateur;
    @ManyToMany
  List<Apprenant> apprenantList;

}
