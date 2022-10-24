package com.ras.persona.domain.persona.exception

import com.ras.persona.commons.Email

class EmailAlreadyExistsException(email: String): IllegalArgumentException("E-mail {$email} já cadastrado")