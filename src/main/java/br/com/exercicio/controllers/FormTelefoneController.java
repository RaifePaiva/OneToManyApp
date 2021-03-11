package br.com.exercicio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.exercicio.models.Telefone;
import br.com.exercicio.services.PessoaService;

@Controller
@RequestMapping("telefone")
public class FormTelefoneController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@GetMapping("form/{id}")
	public ModelAndView formTelefone(@PathVariable("id") Long id) {
		
		ModelAndView mview = new ModelAndView("telefone/formtelefone");
		mview.addObject("pessoa", id);
		return mview;
	}
	
	@PostMapping("novo/{id}")
	public String novotelefone(@PathVariable("id") Long id, Telefone telefone) {
		// é necessário criar essa instancia para que os regitros não sejem sobrescritos.
		telefone = new Telefone(null, telefone.getTelefone());
		pessoaService.addContato(id, telefone);
		
		return "redirect:/pessoa/form";
	}
	

}
