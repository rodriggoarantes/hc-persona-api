package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.input.CreatePersonaDataIn
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class CreatePersonaUseCaseImplTest {
    private val personaRepository: PersonaRepository = mock()

    private val useCase: CreatePersonaUseCase = CreatePersonaUseCaseImpl(personaRepository)

    @Test
    fun `create persona`() {
        whenever(personaRepository.isExistingEmail(any())).thenReturn(false)

        val cmd = CreatePersonaDataIn("Persona Teste 001",  "teste@teste.com")

        val personaIn = useCase.execute(cmd)

        assertEquals(personaIn.name, cmd.name)
        assertEquals(personaIn.email, cmd.email)
        assertTrue(personaIn.data.isEmpty())

        verify(personaRepository).isExistingEmail(any())
        verify(personaRepository).save(any())
    }
}