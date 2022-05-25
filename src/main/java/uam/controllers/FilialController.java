package uam.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uam.dto.endereco.EnderecoDTO;
import uam.dto.filial.ConsultaFilialDTO;
import uam.dto.filial.FilialMapper;
import uam.dto.filial.RegistroFilialDTO;
import uam.entities.Filial;
import uam.services.FilialService;

@RestController
@RequestMapping("v1/filiais")
public class FilialController {
	private final FilialService filialService;
	
	public FilialController(FilialService filialService) {
		this.filialService = filialService;
	}


	@GetMapping
	public ResponseEntity<List<ConsultaFilialDTO>> buscarTodasFiliais() {		
		return ResponseEntity.ok(filialService.listaTodasAsFiliais()
				.stream().map(FilialMapper::fromEntity).collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<ConsultaFilialDTO> salvarFilial(@RequestBody RegistroFilialDTO dto) {
		Filial filial = filialService.salvarFilial(FilialMapper.fromDTO(dto));
		return ResponseEntity.ok(FilialMapper.fromEntity(filial));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaFilialDTO> buscarFilial(@PathVariable Long id) {
		try {
			Filial filial = filialService.buscarFilial(id);
			return ResponseEntity.ok(FilialMapper.fromEntity(filial));
		} catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaFilialDTO> alterarFilial(@RequestBody RegistroFilialDTO dto, @PathVariable Long id) {
		try {
			Filial filial = filialService.atualizarFilial(FilialMapper.fromDTO(dto), id);
			return ResponseEntity.ok(FilialMapper.fromEntity(filial));
		} catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaFilialDTO> deletarFilial(@PathVariable Long id) {
		try {
			filialService.excluirFilial(id);
			return ResponseEntity.ok().build();
		} catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}		
	}
	
}
