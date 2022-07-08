package com.dino.unsplash.shared.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoItem(
    @SerialName("blur_hash")
    val blurHash: String,
    @SerialName("color")
    val color: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("description")
    val description: String,
    @SerialName("height")
    val height: Int,
    @SerialName("id")
    val id: String,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    @SerialName("likes")
    val likes: Int,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("urls")
    val urls: UrlsItem?,
    @SerialName("width")
    val width: Int
)