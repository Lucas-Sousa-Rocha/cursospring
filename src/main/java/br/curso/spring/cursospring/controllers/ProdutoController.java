package br.curso.spring.cursospring.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.curso.spring.cursospring.models.entities.Produto;
import br.curso.spring.cursospring.models.repositories.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

    /*@PostMapping
    public @ResponseBody Produto novoProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }*/
    
    //Obtém todos os dados de uma tabela
    @GetMapping
    public Iterable<Produto> obterProdutos() {
    	return produtoRepository.findAll();
    }
    
    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
    	//return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    	return produtoRepository.searchByNameLike(parteNome);
    }
    
    @GetMapping(path = "/pagina/{numeroPagina}")
    public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina){
    	PageRequest page = PageRequest.of(numeroPagina,3);
    	return produtoRepository.findAll(page);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorID(@PathVariable int id) {
    	return produtoRepository.findById(id);
    }
    
    /*@PutMapping
    public Produto alterarProduto(@Valid Produto produto) {
    	 produtoRepository.save(produto);
    	 return produto;
    }*/
    
    //Faz o POST é o PUT em um metodo só
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
    	produtoRepository.save(produto);
    	return produto;
    }
    
    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id){
    	produtoRepository.deleteById(id);
    }
    
    
    
}
