package com.everis.formativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.everis.formativa.models.Persona;
import com.everis.formativa.repositories.PersonaRepository;

@Service
public class PersonaService {
	private final PersonaRepository pr;
	public PersonaService(PersonaRepository pr) {
		this.pr = pr;
	}
	
	public List<Persona> findAll(){
		return (List<Persona>) pr.findAll();
	}
	
	public Persona crearPersona(Persona persona) {
		return pr.save(persona);
	}
	
	public Persona findById(Long id) {
		Optional<Persona> persona = pr.findById(id);
		if(persona.isPresent()) return persona.get();
		else return null;
	}
	
	public void deletePersona(Long id) {
		this.pr.deleteById(id);
	}
	
	
}
