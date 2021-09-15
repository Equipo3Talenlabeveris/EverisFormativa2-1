package com.everis.formativa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.everis.formativa.models.Persona;
import com.everis.formativa.services.PersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	//Todos los metodos para agregar eliminar y actualizar los empleados
	//Agrega dependencia servicio
	private final PersonaService es;
	public PersonaController(PersonaService personaService) {
		this.es = personaService;
		
	}
	
	@RequestMapping("")
	public String index(@ModelAttribute("usuario") Persona persona, Model model) {
		System.out.println("formulario empleado");
		//Empleado empleado2 = new Empleado();
		//model.addAttribute(new Empleado());
		List<Persona> lista_persona = es.findAll();
		model.addAttribute("lista", lista_persona);
		
		return "usuario.jsp";
	}
	
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Persona persona, Model model) {
		System.out.println("Crear" + persona);
		//llamado a guardar el objeto
		
		System.out.println(persona.getId());
		System.out.println(persona.getEmail());
		System.out.println(persona.getApellido());
		
		if(persona.getNombre().length()>20||persona.getNombre().length()<3||persona.getApellido().length()>20||persona.getApellido().length()<3||persona.getEmail().length()<10||persona.getRut().isEmpty()) {
			model.addAttribute("error", "Los campos ingresados no cumplen las condiciones");
			List<Persona> lista_persona = es.findAll();
			model.addAttribute("lista", lista_persona);
			return "usuario.jsp";
		}
		else {
			es.crearPersona(persona); //va a service
			
			return "redirect:/persona";
		}
		
	}
	
	//METODOS DE ACTUALIZAR-----------------------------------
	@RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET) //un href de un hipertexto es metodo get
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("Se actualizará el ID" + id);
		
		Persona persona = es.findById(id);
		model.addAttribute("usuario", persona);
		return "editar_usuario.jsp";
	}
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Persona persona, Model model) {
		System.out.println(persona.getId());
		
		if(persona.getNombre().length()>20||persona.getNombre().length()<3||persona.getApellido().length()>20||persona.getApellido().length()<3||persona.getEmail().length()<10||persona.getRut().isEmpty()) {	
			model.addAttribute("error", "Los campos ingresados no cumplen las condiciones");
			model.addAttribute("usuario", persona);
			return "redirect:/persona/actualizar/"+persona.getId();
			
			
		}
		else {
			es.crearPersona(persona); //va a service
			
			return "redirect:/persona";
		}
	}
	
	//METODOS DE ELIMINAR-------------------------------
	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar2(@PathVariable("id") Long id) {
		System.out.println("Se eliminará (versión 2) el ID" + id);
		
		es.deletePersona(id); //va a service
		return "redirect:/persona";
	}
	
	


	
}
