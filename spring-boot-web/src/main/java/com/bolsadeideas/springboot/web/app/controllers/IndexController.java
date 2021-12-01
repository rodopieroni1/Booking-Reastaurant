package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.model.Usuarios;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	//tambien se puede hacerce asi@RequestMapping(value="/index", method = RequestMethod.GET)
	@GetMapping({"/index","/","/home"})
	public String index(Map<String, Object> map) {
		map.put("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping({"/perfil"})
	public String perfil(Model model) {
		Usuarios usuario = new Usuarios();
		usuario.setApellido("Perez");
		usuario.setNombre("Pablo");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil .concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping({"/listar"})
	public String listar(Model model) {
		//otra forma de hacer
		/*List<Usuarios> usuarios= new ArrayList<>();
		usuarios.add(new Usuarios("Andres", "Perez", "perez@gmail.com"));
		usuarios.add(new Usuarios("Carlos", "Carrizo", "carrizo@gmail.com"));
		usuarios.add(new Usuarios("Martin", "Vega", "vega@gmail.com"));*/
		List<Usuarios> usuarios= 
				Arrays.asList(new Usuarios("Andres", "Perez", "perez@gmail.com"),
				new Usuarios("Carlos", "Carrizo", "carrizo@gmail.com"),
				new Usuarios("Martin", "Vega", "vega@gmail.com"));
		
		model.addAttribute("titulo", textoListar);
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	

}
