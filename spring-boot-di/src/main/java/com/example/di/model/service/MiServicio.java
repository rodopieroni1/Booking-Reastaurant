package com.example.di.model.service;

import org.springframework.stereotype.Component;

@Component("miServicioSimple")  //con esto lo podemos acceder mediante dependencias
public class MiServicio implements IServicio{
	
	@Override
	public String operacion() {	
		return "ejecutando algun proceso importante...";
	}

}
