package br.curso.spring.cursospring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Passando o parametro que será o controlador
@RestController
// Passando a URL
@RequestMapping("/calculadora")
public class CalculadoraController {

    // -> /somar/valor1/valor2 <-- retornará na pagina
    @GetMapping("/somar/{a}/{b}")
    public int somar(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    // -> /subtrair/valor1/valor2 <-- retornará na pagina
    @GetMapping(path = "/subtrair/{a}/{b}")
    public int subtrair(@PathVariable int a, @PathVariable int b) {
        return a - b;
    }

    // -> /multiplicar?a=valor1&b=valor2 <-- retornará na pagina
    @GetMapping("/multiplicar")
    public int multiplicar(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
        return a * b;
    }

    // -> /dividir?a=valor1&b=valor2 <-- retornará na pagina
    @GetMapping("/dividir")
    public int duvidir(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
        return a / b;
    }
}
