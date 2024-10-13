package com.api.anotaTarefas.dtos;

import jakarta.validation.constraints.NotBlank;

public record TarefaRecordDto (@NotBlank String name, @NotBlank String priority) {

}
