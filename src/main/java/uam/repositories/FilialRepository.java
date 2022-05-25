package uam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uam.entities.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long>{

}
