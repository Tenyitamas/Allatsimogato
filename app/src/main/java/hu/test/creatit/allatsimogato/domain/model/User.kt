package hu.test.creatit.allatsimogato.domain.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import java.time.ZonedDateTime

data class User(
    val title: String,
    val id: Int,
    val timeCreate: ZonedDateTime,
    val timeUpdate: ZonedDateTime
)
