package produtosapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import produtosapi.model.Produto;
import produtosapi.repository.ProdutoRepository;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	private ProdutoRepository produtoRepository;
	
	
	
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}



	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		System.out.println("Produto Salvo: "+produto);
		produtoRepository.save(produto);
		return produto;
	}
	
	@GetMapping("/{id}")
	public Produto buscaPorId(@PathVariable("id") Long id) {
		
		return produtoRepository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void deletaPorId(@PathVariable("id") Long id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Produto atualizaPorId(@PathVariable("id") Long id, @RequestBody Produto produto) {
		Produto obj = produtoRepository.findById(id).get();
		
		obj.setNome(produto.getNome());
		obj.setPreco(produto.getPreco());
		obj.setDescricao(produto.getDescricao());
		
		return produtoRepository.save(obj);
	}
	
}
