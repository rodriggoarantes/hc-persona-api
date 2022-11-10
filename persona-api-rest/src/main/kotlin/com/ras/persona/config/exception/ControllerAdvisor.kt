package com.ras.persona.config.exception

import com.ras.persona.domain.exception.AbstractBusinessException
import com.ras.persona.domain.exception.ResourceNotFoundException
import com.ras.persona.domain.exception.UnauthorizedException
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
    ): ResponseEntity<ErrorResponse> {
        val bodyOfResponse = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex?.message ?: "Parametro informado é invalido")
        return buildResponse(bodyOfResponse)
    }

    @ExceptionHandler(value = [ResourceNotFoundException::class])
    protected fun notFound(ex: ResourceNotFoundException, request: WebRequest?): ResponseEntity<ErrorResponse> {
        val bodyOfResponse = ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.message ?: "Recurso não encontrado")
        return buildResponse(bodyOfResponse)
    }

    @ExceptionHandler(value = [AbstractBusinessException::class])
    protected fun businessError(ex: AbstractBusinessException, request: WebRequest?): ResponseEntity<ErrorResponse> {
        val bodyOfResponse = ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.message ?: "Falha ao realizar operação desejada, verifique as exigencias de negocio")
        return buildResponse(bodyOfResponse)
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    protected fun unauthorizedError(ex: UnauthorizedException, request: WebRequest?): ResponseEntity<ErrorResponse> {
        val bodyOfResponse = ErrorResponse(
            HttpStatus.UNAUTHORIZED.value(),
            ex.message ?: "Usuario nao possui permissao necessaria")
        return buildResponse(bodyOfResponse)
    }

    private fun buildResponse(error: ErrorResponse): ResponseEntity<ErrorResponse> {
        return ResponseEntity<ErrorResponse>(error, HttpStatus.valueOf(error.code))
    }
}
