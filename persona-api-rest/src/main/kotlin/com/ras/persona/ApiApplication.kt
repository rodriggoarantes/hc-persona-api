package com.ras.persona

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersonaApplication

fun main(args: Array<String>) {
    runApplication<PersonaApplication>(*args)
}
