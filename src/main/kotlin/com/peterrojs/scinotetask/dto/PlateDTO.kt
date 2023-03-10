package com.peterrojs.scinotetask.dto

data class PlateDTO(
    var plateSize: Int = 0,
    var sampleArrays: MutableList<List<String>> = mutableListOf(),
    var reagentArrays: MutableList<List<String>> = mutableListOf(),
    var replicateNumbers: List<Int> = listOf()
)