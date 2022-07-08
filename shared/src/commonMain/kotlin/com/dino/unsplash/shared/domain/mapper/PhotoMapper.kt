package com.dino.unsplash.shared.domain.mapper

import com.dino.unsplash.shared.data.model.response.PhotoItem
import com.dino.unsplash.shared.data.model.response.UrlsItem
import com.dino.unsplash.shared.domain.model.Photo
import com.dino.unsplash.shared.domain.model.Urls

fun PhotoItem.map(): Photo {
    return Photo(
        blurHash = blurHash.orEmpty(),
        color = color.orEmpty(),
        createdAt = createdAt.orEmpty(),
        description = description.orEmpty(),
        height = height.orZero(),
        id = id.orEmpty(),
        likedByUser = likedByUser.orFalse(),
        likes = likes.orZero(),
        updatedAt = updatedAt.orEmpty(),
        urls = urls?.map() ?: Urls(),
        width = width.orZero()
    )
}

fun UrlsItem.map(): Urls {
    return Urls(
        full = full.orEmpty(),
        raw = raw.orEmpty(),
        regular = regular.orEmpty(),
        small = small.orEmpty(),
        thumb = thumb.orEmpty()
    )
}

fun Boolean?.orFalse(): Boolean = this ?: false

fun Int?.orZero(): Int = this ?: 0