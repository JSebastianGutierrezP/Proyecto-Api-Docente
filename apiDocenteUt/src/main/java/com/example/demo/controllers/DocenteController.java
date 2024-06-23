package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.DocenteModel;
import com.example.demo.models.common.RequestDocenteDto;
import com.example.demo.models.common.Response;
import com.example.demo.services.DocenteService;


@RestController
@RequestMapping("/docente")
public class DocenteController {
	@Autowired
	private DocenteService DocenteService;
	
	@PostMapping
	public ResponseEntity<DocenteModel> save(@RequestBody RequestDocenteDto docente){
		
		return ResponseEntity.ok(DocenteService.save(docente));	
	}
	
	@GetMapping
	public ResponseEntity<List<DocenteModel>> getAll() {
		return ResponseEntity.ok(DocenteService.getAll());
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody DocenteModel docente){
		
		var docenteActualizado = DocenteService.update(docente);
		
		if(docenteActualizado == null) {
			return ResponseEntity.ok(new Response<>("No se encontro docente")); 
		}
		return ResponseEntity.ok(new Response<>("Docente actualizado", docenteActualizado)); 
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<Object> delete(@PathVariable("Id") int Id){
		var docenteEliminado = DocenteService.delete(Id);
		if(docenteEliminado) {
			return ResponseEntity.ok(new Response<>("Docente eliminado"));
		}else {
			return ResponseEntity.ok(new Response<>("Docente no encontrado"));
		}
	}
}