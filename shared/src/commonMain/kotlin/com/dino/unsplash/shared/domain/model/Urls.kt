package com.dino.unsplash.shared.domain.model

import kotlinx.serialization.SerialName

data class Urls(
    val full: String = "",
    val raw: String = "",
    val regular: String = "",
    val small: String = "",
    val thumb: String = "'"
)
