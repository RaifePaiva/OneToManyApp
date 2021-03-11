package br.com.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.exercicio.models.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	
	

}
