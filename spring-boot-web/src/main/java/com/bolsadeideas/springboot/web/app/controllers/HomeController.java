package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		
		//return "forward:/app/index"; no se muestra valores en la url: ej.http://localhost:8080/. Se aplica por abajo un RequestDispatcher.forward()
		return "redirect:/app/index";//muestra url, ante una pagina de inicio es mejor el forward
	}
}
