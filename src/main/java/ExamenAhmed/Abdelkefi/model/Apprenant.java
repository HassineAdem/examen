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

public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApprenant;
    private String nom;
    private Integer telephone;
    private String email;
    @ManyToMany (mappedBy = "apprenantList")
    private List <Formation> formationList;
}
