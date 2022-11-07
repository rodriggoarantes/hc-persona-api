package com.ras.persona.usecase.boundary.converter

import com.ras.persona.domain.commons.Height
import com.ras.persona.domain.commons.Weight
import com.ras.persona.domain.persona.data.Bio
import com.ras.persona.domain.persona.data.Contact
import com.ras.persona.domain.persona.data.Data
import com.ras.persona.domain.persona.data.DataType
import com.ras.persona.usecase.boundary.data.commons.BioData
import com.ras.persona.usecase.boundary.data.commons.ContactData
import com.ras.persona.usecase.boundary.data.commons.DataOfPersonaDataIn

fun dataPersonaToDomain(type: DataType, value: DataOfPersonaDataIn): Data =
    when (type) {
        DataType.CONTACT -> (value as ContactData).toContact()
        DataType.BIO -> (value as BioData).toBio()
    }

// BIO
fun Bio.toDataIn(): BioData = BioData(weight.kg, height.cm)

fun BioData.toBio(): Bio = Bio(Weight(weightKg), Height(heightCm.toDouble()))


// CONTACT
fun Contact.toDataIn(): ContactData = ContactData(mainPhone)

fun ContactData.toContact(): Contact = Contact(mainPhone)
