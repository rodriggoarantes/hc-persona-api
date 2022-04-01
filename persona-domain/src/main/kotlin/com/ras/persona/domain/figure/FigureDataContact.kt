package com.ras.persona.domain.figure

import com.ras.persona.domain.data.Contact

class FigureDataContact(id: FigureId, data: Contact) : FigureData<Contact>(id, FigureType.CONTACT, data)
