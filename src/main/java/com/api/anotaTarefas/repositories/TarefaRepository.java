package com.api.anotaTarefas.repositories;

import com.api.anotaTarefas.models.TarefaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel,UUID> {
	
}
