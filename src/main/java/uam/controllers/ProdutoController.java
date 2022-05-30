package uam.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uam.dto.produto.ConsultaProdutoDTO;
import uam.dto.produto.ProdutoMapper;
import uam.dto.produto.RegistroProdutoDTO;
import uam.entities.Produto;
import uam.services.ProdutoService;

@RestController
@RequestMapping("v1/estoque")
public class ProdutoController {
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}


	@GetMapping
	public ResponseEntity<List<ConsultaProdutoDTO>> buscarTodasFiliais() {		
		return ResponseEntity.ok(produtoService.listarEstoque()
				.stream().map(ProdutoMapper::fromEntity).collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<ConsultaProdutoDTO> salvarProduto(@RequestBody RegistroProdutoDTO dto) {
		Produto produto = produtoService.salvarProduto(ProdutoMapper.fromDTO(dto));
		return ResponseEntity.ok(ProdutoMapper.fromEntity(produto));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaProdutoDTO> buscarProduto(@PathVariable Long id) {
		try {
			Produto produto = produtoService.buscarProduto(id);
			return ResponseEntity.ok(ProdutoMapper.fromEntity(produto));
		} catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaProdutoDTO> alterarProduto(@RequestBody RegistroProdutoDTO dto, @PathVariable Long id) {
		try {
			Produto produto = produtoService.atualizarProduto(ProdutoMapper.fromDTO(dto), id);
			return ResponseEntity.ok(ProdutoMapper.fromEntity(produto));
		} catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaProdutoDTO> deletarProduto(@PathVariable Long id) {
		try {
			produtoService.excluirProduto(id);
			return ResponseEntity.ok().build();
		} catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}		
	}
	
}
