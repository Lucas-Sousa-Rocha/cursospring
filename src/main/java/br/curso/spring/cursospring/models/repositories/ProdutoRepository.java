package br.curso.spring.cursospring.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.curso.spring.cursospring.models.entities.Produto;
import jakarta.validation.Valid;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto , Integer>{

	Iterable<Produto> findAll();

	Optional<Produto> findById(int id);

	void save(@Valid Produto produto);

	void deleteById(int id);
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
	
	//public Iterable<Produto> findByNomeContainingIgnoreCase(String nome);
    
}
