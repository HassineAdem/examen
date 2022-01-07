package ExamenAhmed.Abdelkefi.repository;

import ExamenAhmed.Abdelkefi.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant,Integer> {
}
