package com.example.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.di.model.service.IServicio;

@Controller
public class IndexController {
	//private MiServicio servicio = new MiServicio();//manejando sin injeccion de dependencia
	
	@Autowired //con esta anotacion inyectamos MiServicio
	private IServicio servicio; //empezando con la inyeccion
	@GetMapping({"/","","/index"})
	public String index(Model model) {	
		model.addAttribute("objeto", servicio.operacion());//sin injeccion de dependencia
		return "index"; 	
	}
}

// la idea es que el contenerdor nos entrege la instancia
//no crees la instancia, sino te lo enviamos

//el problema de esta dependencia es que despues podremos tener otra clase servicios con otra 
// se deberia modificar los new y sus atributos
//por ende dificulta el mantenimeinto y escalabilidad