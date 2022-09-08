package hu.test.creatit.allatsimogato.data.mapper

import android.util.Log
import hu.test.creatit.allatsimogato.data.dto.UserDto
import hu.test.creatit.allatsimogato.domain.model.User
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun UserDto.toUser() = User(
    title = title ?: "N/A",
    id = id ?: -1,
    timeCreate = timeStringToZonedDateTime(timeCreate ?: ""),
    timeUpdate = timeStringToZonedDateTime(timeUpdate ?: "")
)

private fun timeStringToZonedDateTime(timeString: String): ZonedDateTime {
    Log.d("TIMEFORMATTER: ", "timeStringToLocalDate: $timeString")

    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+'HH:mm")
    // val outputFormatter = DateTimeFormatter.ofPattern("yyyy.mm.dd HH:mm:ss")

    return ZonedDateTime.parse(timeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
}