package com.ras.persona.domain.figure

import com.ras.persona.domain.data.Bio

class FigureDataBio(id: FigureId, data: Bio) : FigureData<Bio>(id, FigureType.BIO, data)
