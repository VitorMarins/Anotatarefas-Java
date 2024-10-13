package com.api.anotaTarefas.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.anotaTarefas.dtos.TarefaRecordDto;
import com.api.anotaTarefas.models.TarefaModel;
import com.api.anotaTarefas.repositories.TarefaRepository;

import jakarta.validation.Valid;

@RestController
public class TarefaController {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@PostMapping("/tarefa")
	public ResponseEntity <TarefaModel> saveTarefa(@RequestBody @Valid TarefaRecordDto tarefaRecordDto) {
		var tarefaModel = new TarefaModel();
		BeanUtils.copyProperties(tarefaRecordDto, tarefaModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));
	}
	
	@GetMapping("/tarefa")
	public ResponseEntity <List<TarefaModel>> getAllTarefas(){
		return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findAll());
	}
	
	@GetMapping("/tarefa/{id}")
	public ResponseEntity <Object> getOneTarefa(@PathVariable UUID id){
		Optional<TarefaModel> tarefa0 = tarefaRepository.findById(id);
		if(tarefa0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(tarefa0.get());
	}
	
	@PutMapping("/tarefa/{id}")
	public ResponseEntity<Object> updateTarefa(@PathVariable UUID id, @RequestBody @Valid TarefaRecordDto tarefaRecordDto) {
		Optional<TarefaModel> tarefa0 = tarefaRepository.findById(id);
		if(tarefa0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
		}
		var tarefaModel = tarefa0.get();
		BeanUtils.copyProperties(tarefaRecordDto, tarefaModel);
		return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.save(tarefaModel));
	}
	
	@DeleteMapping("/tarefa/{id}")
	public ResponseEntity<Object> deleteTarefa(@PathVariable UUID id) {
		Optional<TarefaModel> tarefa0 = tarefaRepository.findById(id);
		if(tarefa0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
		}
		tarefaRepository.delete(tarefa0.get());
		return ResponseEntity.status(HttpStatus.OK).body("Tarefa deletada com sucesso.");
	}
}
