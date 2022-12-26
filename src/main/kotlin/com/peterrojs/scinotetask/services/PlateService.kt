package com.peterrojs.scinotetask.services

import com.peterrojs.scinotetask.dto.PlateDTO
import org.springframework.stereotype.Service

@Service
class PlateService {

    fun generatePlateContents(plateDTO: PlateDTO): MutableList<MutableList<List<String>?>> {
        val plates = mutableListOf<MutableList<List<String>?>>()
        var currentPlate: MutableList<List<String>?> = MutableList(plateDTO.plateSize) { null }

        var wellIndex = 0

        // For each experiment
        plateDTO.sampleArrays.forEachIndexed { numberOfExperiments, sampleArray ->

            // Sort sample list
            val sortedSampleArray = sampleArray.sorted()
            // Sort reagent list
            val sortedReagentArray = plateDTO.reagentArrays[numberOfExperiments].sorted()

            sortedSampleArray.forEach { sample ->
                sortedReagentArray.forEach { reagent ->
                    val replicateNumber = plateDTO.replicateNumbers[numberOfExperiments]
                    for (i in 1..replicateNumber) {
                        // Set the value
                        val pairList = listOf(sample, reagent)
                        currentPlate[wellIndex] = pairList
                        wellIndex++
                        if (wellIndex == plateDTO.plateSize) {
                            plates.add(currentPlate)
                            currentPlate = mutableListOf()
                            wellIndex = 0
                        }
                    }
                }
            }

        }
        if (currentPlate.isNotEmpty()) {
            plates.add(currentPlate)
        }
        return plates
    }
}

