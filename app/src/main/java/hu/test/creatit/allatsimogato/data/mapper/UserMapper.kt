package hu.test.creatit.allatsimogato.data.mapper

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import hu.test.creatit.allatsimogato.data.dto.UserDto
import hu.test.creatit.allatsimogato.domain.model.User
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun UserDto.toUser() = User(
    title = title ?: "N/A",
    id = id ?: -1,
    timeCreate = timeStringToLocalDate(timeCreate ?: ""),
    timeUpdate = timeStringToLocalDate(timeUpdate ?: "")
)

private fun timeStringToLocalDate(timeString: String): LocalDate {
    // val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+'HH:mm")
    // val outputFormatter = DateTimeFormatter.ofPattern("yyyy.mm.dd HH:mm:ss")

    return LocalDate.parse(timeString)
}