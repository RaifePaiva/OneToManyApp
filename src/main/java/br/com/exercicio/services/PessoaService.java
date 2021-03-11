package br.com.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exercicio.models.Pessoa;
import br.com.exercicio.models.Telefone;
import br.com.exercicio.repositories.PessoaRepository;
import br.com.exercicio.repositories.TelefoneRepository;

@Service
public class PessoaService {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TelefoneRepository telefoneReposiRepository;
	
	
	public Pessoa novaPessoa(Pessoa ps) {
		return pessoaRepository.save(ps);
	}
	
	public List<Pessoa> listarTodos(){
		return pessoaRepository.findAll();
	}
	
	public Telefone addContato(Long id, Telefone telefone) {
		Pessoa pessoa = pessoaRepository.findById(id).get();
		telefone.setPessoa(pessoa);
		return telefoneReposiRepository.save(telefone);
		
	}
	
}
