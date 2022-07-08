package com.dino.unsplash.shared.domain.model

data class ApiError(
    val error: List<String>
): Exception()
