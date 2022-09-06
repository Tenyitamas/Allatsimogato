package hu.test.creatit.allatsimogato.data.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    val title: String? = null,
    val id: Int? = null,
    @SerializedName("time_create") val timeCreate: String? = null,
    @SerializedName("time_update") val timeUpdate: String? = null
)
