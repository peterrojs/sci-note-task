package com.peterrojs.scinotetask

import com.peterrojs.scinotetask.dto.PlateDTO
import com.peterrojs.scinotetask.services.PlateService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

private val log = KotlinLogging.logger {}

@RestController
@Component
class PlateController(
    @Autowired val plateService: PlateService
) {

    @Operation(summary = "Generate plate contents")
    @ResponseStatus(HttpStatus.CREATED, reason = "OK")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "OK"),
            ApiResponse(responseCode = "400", description = "Missing parameter")
        ]
    )
    @PostMapping(
        "/plate",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    suspend fun generatePlate(@RequestBody plateDTO: PlateDTO): MutableList<MutableList<List<String>?>> {
        log.info("Generating...")
        return plateService.generatePlateContents(plateDTO)
    }
}