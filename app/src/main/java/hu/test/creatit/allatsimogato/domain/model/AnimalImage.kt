package hu.test.creatit.allatsimogato.domain.model

import androidx.annotation.DrawableRes

sealed class AnimalImage {
    data class Resource(@DrawableRes val resId: Int): AnimalImage()
    data class Url(val url: String): AnimalImage()
    object None: AnimalImage()
}
