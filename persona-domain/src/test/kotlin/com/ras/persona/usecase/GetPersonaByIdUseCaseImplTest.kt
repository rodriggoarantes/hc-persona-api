package com.ras.persona.usecase

import com.ras.persona.domain.persona.PersonaId
import com.ras.persona.domain.persona.UserId
import com.ras.persona.domain.persona.data.DataType
import com.ras.persona.usecase.boundary.converter.toPersonaIn
import com.ras.persona.usecase.boundary.data.commons.ContactData
import com.ras.persona.usecase.boundary.data.output.PersonaDataOut
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class GetPersonaByIdUseCaseImplTest {
    private val personaRepository: PersonaRepository = mock()

    private val useCase: FindPersonaByIdUseCase = FindPersonaByIdUseCaseImpl(personaRepository)

    @Test
    fun `retrieve persona`() {
        val personaId = PersonaId.generate()
        val userId = UserId("123456789")

        val personaOut = PersonaDataOut(
            personaId.toString(),
            userId.toString(),
            "Name",
            "email@test.com",
            mapOf(Pair(DataType.CONTACT.name, ContactData("123-456-789")))
        )

        whenever(personaRepository.findById(eq(personaId.toString()))).thenReturn(personaOut)

        val personaIn = useCase.execute(personaId.toString())

        assertEquals(personaIn, personaOut.toPersonaIn())

        verify(personaRepository).findById(eq(personaId.toString()))
    }

}