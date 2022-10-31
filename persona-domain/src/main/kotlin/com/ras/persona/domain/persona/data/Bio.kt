package com.ras.persona.domain.persona.data

import com.ras.persona.domain.commons.Height
import com.ras.persona.domain.commons.Weight

data class Bio(val weight: Weight, val height: Height): Data(DataType.BIO)
