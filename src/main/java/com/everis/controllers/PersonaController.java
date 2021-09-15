package com.everis.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Empleado;
import com.example.demo.services.EmpleadoService;

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
	public String crear(@Valid @ModelAttribute("usuario") Persona persona) {
		System.out.println("Crear" + persona);
		//llamado a guardar el objeto
		
		es.crearPersona(persona); //va a service
		
		return "redirect:/persona";
	}
	
	//METODOS DE ACTUALIZAR-----------------------------------
	@RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET) //un href de un hipertexto es metodo get
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("Se actualizará el ID" + id);
		
		Persona persona = es.buscarPersona(id);
		model.addAttribute("usuario", persona);
		return "editar_usuario.jsp";
	}
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Persona persona) {
		System.out.println(persona.getId());
		
		es.modificarPersona(persona); //va a service
		
		return "redirect:/persona";
	}
	
	//METODOS DE ELIMINAR-------------------------------
	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar2(@PathVariable("id") Long id) {
		System.out.println("Se eliminará (versión 2) el ID" + id);
		
		es.eliminarPersona(id); //va a service
		
		return "redirect:/persona";
	}
	
	


	
}