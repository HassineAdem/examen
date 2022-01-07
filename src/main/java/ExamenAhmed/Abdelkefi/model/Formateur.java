package ExamenAhmed.Abdelkefi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idFormateur;
    private String nom;
    private String prenom;
    private String tarifHoraire;
    private String email;
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "formateur")
    private List<Formation> formation;
}
