package com.ras.persona.domain.exception

class ResourceNotFoundException(resourceId: String): RuntimeException("O recurso nao foi encontrado para o id {$resourceId}")