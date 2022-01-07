package ExamenAhmed.Abdelkefi.repository;

import ExamenAhmed.Abdelkefi.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur,Integer> {
}
