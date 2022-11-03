package com.ras.persona.config.exception

import com.ras.persona.domain.exception.ResourceNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ControllerAdvisor : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [IllegalArgumentException::class, IllegalStateException::class])
    protected fun handleConflict(
        ex: RuntimeException?, request: WebRequest?
    ): ResponseEntity<Error> {
        val bodyOfResponse = Error(
            HttpStatus.BAD_REQUEST.value(),
            ex?.message ?: "Parametro informado é invalido")
        return buildResponse(bodyOfResponse)
    }

    @ExceptionHandler(value = [ResourceNotFoundException::class])
    protected fun notFound(ex: ResourceNotFoundException, request: WebRequest?): ResponseEntity<Error> {
        val bodyOfResponse = Error(HttpStatus.NOT_FOUND.value(), ex.message ?: "Recurso não encontrado")
        return buildResponse(bodyOfResponse)
    }

    private fun buildResponse(error: Error): ResponseEntity<Error> {
        return ResponseEntity<Error>(error, HttpStatus.valueOf(error.code))
    }
}
