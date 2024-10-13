package com.api.anotaTarefas.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_TAREFAS")
public class TarefaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID idTarefa;
	private String name;
	private String priority;
	
	public UUID getIdTarefa() {
		return idTarefa;
	}
	
	public void setIdTarefa(UUID idTarefa) {
		this.idTarefa = idTarefa;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
}
