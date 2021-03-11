package br.com.exercicio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.exercicio.models.Pessoa;
import br.com.exercicio.repositories.PessoaRepository;
import br.com.exercicio.services.PessoaService;

@Controller
@RequestMapping("pessoa")
public class FormPessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@GetMapping("form")
	public ModelAndView formPessoa() {
		
		ModelAndView mview = new ModelAndView("pessoa/formpessoa");
		List<Pessoa> pessoas = pessoaService.listarTodos();
		mview.addObject("pessoas", pessoas);
		return mview;
	}
	
	@PostMapping("novo")
	public String novaPessoa(Pessoa pessoa) {
		pessoaService.novaPessoa(pessoa);
		//ModelAndView mview = new ModelAndView("redirect:/pessoa/formpessoa");
		return "redirect:/pessoa/form";
	}
	
	@GetMapping("detalhes/{id}")
	public ModelAndView detalhes(@PathVariable("id") Long id) {
		ModelAndView mview = new ModelAndView("pessoa/detalhe");
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		mview.addObject("pessoa", pessoa.get());
		return mview;
		
	}
	
	

}
