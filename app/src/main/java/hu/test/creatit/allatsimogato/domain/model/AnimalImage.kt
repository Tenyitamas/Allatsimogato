package hu.test.creatit.allatsimogato.domain.model

import androidx.annotation.IdRes

sealed class AnimalImage {
    data class Resource(@IdRes val resId: Long): AnimalImage()
    data class Url(val url: String): AnimalImage()
    object None: AnimalImage()
}
