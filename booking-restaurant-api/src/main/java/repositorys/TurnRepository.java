package repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entityes.Turn;

public interface TurnRepository extends JpaRepository<Turn, Long>{
	
	Optional<Turn> findById(Long id);

}
