package com.ras.persona.domain.data

data class Bio(val weight: Double, val heightCm: Int, val shoeSize: Int) {
    init {
        require(weight > 0) { "weight cannot be blank" }
        require(heightCm > 0) { "height cannot be blank" }
        require(shoeSize > 0) { "shoeSize cannot be blank" }
    }
}
