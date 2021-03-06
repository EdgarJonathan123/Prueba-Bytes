package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empresa;
import com.example.demo.service.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

	private EmpresaService empresaService;

	public EmpresaController(EmpresaService empresaService) {
		super();
		this.empresaService = empresaService;
	}
	
	@PostMapping
	public ResponseEntity<Empresa> guardarEmpresa(@RequestBody Empresa empresa){
		return new ResponseEntity<>(empresaService.guardarEmpresa(empresa),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Empresa> getallEmpresas(){
		return empresaService.getAllEmpresas();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Empresa> getEmpresaById(@PathVariable("id")long empresaId){ 
		return new ResponseEntity<Empresa>(empresaService.findById(empresaId),HttpStatus.OK);
	}
	 
	@PutMapping("{id}")
	public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable("id")long id, @RequestBody Empresa empresa) { 
		return new ResponseEntity<Empresa>(empresaService.actualizarEmpresa(empresa, id),HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> eliminarEmpresa(@PathVariable("id")long id){
		empresaService.eliminarEmpresa(id);
		return new ResponseEntity<String>("Empresa eliminada exitosamente!",HttpStatus.OK);
	}
	
	
	

}


