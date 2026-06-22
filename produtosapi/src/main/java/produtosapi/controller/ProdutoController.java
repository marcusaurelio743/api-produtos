package produtosapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
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
}
