package ExamenAhmed.Abdelkefi.repository;

import ExamenAhmed.Abdelkefi.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Integer> {
}
