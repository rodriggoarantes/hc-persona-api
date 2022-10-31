package com.ras.persona.domain.persona.exception

class EmailAlreadyExistsException(email: String): IllegalArgumentException("E-mail {$email} já cadastrado")