package com.peterrojs.scinotetask

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(info = Info(title = "sci-note-task", version = "1.0"))
@SpringBootApplication
class SciNoteTaskApplication

fun main(args: Array<String>) {
	runApplication<SciNoteTaskApplication>(*args)
}
