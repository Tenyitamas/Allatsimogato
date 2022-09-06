package hu.test.creatit.allatsimogato.domain.model

import androidx.annotation.IdRes

data class Animal(
    val name: String,
    val image: AnimalImage,
    @IdRes val sound: Long
)