package br.curso.spring.cursospring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.curso.spring.cursospring.models.entities.Cliente;

@RestController
@RequestMapping(path = "clientes")
public class ClienteController {

    @GetMapping(path = "/exibir")
    public Cliente obterCliente() {
        return new Cliente(1, "Lucas", "607.864.573-09");
    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId(@PathVariable int id){
        return new Cliente(id,"Flavia","076.282.543-60");
    }

    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name="id") int id){
        return new Cliente(id, "Pedro", "080.100.698-75");
    }
}
