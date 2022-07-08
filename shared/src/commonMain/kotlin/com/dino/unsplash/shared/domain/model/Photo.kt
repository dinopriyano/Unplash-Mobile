package com.dino.unsplash.shared.domain.model

data class Photo(
    val blurHash: String,
    val color: String,
    val createdAt: String,
    val description: String,
    val height: Int,
    val id: String,
    val likedByUser: Boolean,
    val likes: Int,
    val updatedAt: String,
    val urls: Urls,
    val width: Int
)
