package br.com.demo.frontend.resource;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.demo.frontend.model.Person;
import br.com.demo.frontend.service.PersonService;

@Controller
public class PersonResource {

	private PersonService personService;
		
	public PersonResource(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/lista-pessoas")
    private String listaPessoas(Model model){
		Person[] persons = personService.getPersons();
        model.addAttribute("persons", persons);
		return "lista-pessoas";
    }
	
	@GetMapping("/cadastra-pessoas")
    private String cadastraPessoas(Model model){
		return "cadastra-pessoas";
    }
	
	@PostMapping(value="salvar")
	public String save(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
		Person person = new Person(name, age);
		personService.save(person);	    
		Person[] persons = personService.getPersons();
        model.addAttribute("persons", persons);
		return "/lista-pessoas";
	}

	@PostMapping(value="deletar")
	public String delete(@RequestParam("id") int id, Model model) {
		personService.deleteById(id);
		Person[] persons = personService.getPersons();
        model.addAttribute("persons", persons);
		return "/lista-pessoas";
	}


    @PostMapping(value = "atualizar")
    public String update(@RequestParam("id") int id, Model model) {
        Person person = personService.getById(id);
        model.addAttribute("person", person);
        return "cadastra-pessoas";
    }
    
}
