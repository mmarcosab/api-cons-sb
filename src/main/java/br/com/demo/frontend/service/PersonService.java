package br.com.demo.frontend.service;


import java.util.NoSuchElementException;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.demo.frontend.model.Person;

@Service
public class PersonService {

	static final String URL_API_PERSONS = "http://localhost:8080/persons";
	
	RestTemplate restTemplate = new RestTemplate();
	
	public Person[] getPersons(){
		Person[] personResult = restTemplate.getForObject(URL_API_PERSONS, Person[].class);
	    System.out.println(personResult);
	    return personResult; 
	}
	
	public Person getById(int id) {
		Person person = new Person();
		try {
			person = restTemplate.getForObject(URL_API_PERSONS + "/" + id, Person.class);
		}catch(NoSuchElementException nsee) {
			return person;
		}
		return person;		
	}
	
	public void save(Person person) {
		HttpEntity<Person> requestBody = new HttpEntity<Person>(person);
		person = restTemplate.postForObject(URL_API_PERSONS, requestBody, Person.class);
	}
	
	public Person[] deleteById(int id) {
		restTemplate.delete(URL_API_PERSONS + "/" + id);
	    return getPersons(); 
	}
}
