package br.curso.spring.cursospring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	@GetMapping(path = { "home" })
	public String ola() {
		return "Primeiro projeto spring";
	}
}
