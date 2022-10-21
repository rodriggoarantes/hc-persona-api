package com.ras.persona.domain.persona

import com.ras.persona.commons.Email
import com.ras.persona.domain.persona.data.Data
import com.ras.persona.domain.persona.data.DataType

class Persona(
    val id: PersonaId,
    val name: String,
    val email: Email
) {
    private val _data: MutableMap<DataType, Data> = mutableMapOf()
    val data: Map<DataType, Data>
        get() = _data.toMap()

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
    }

    fun addData(dataValue: Data) {
        this._data[dataValue.type] = dataValue
    }

}
