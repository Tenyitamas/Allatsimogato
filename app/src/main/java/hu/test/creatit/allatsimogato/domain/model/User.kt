package hu.test.creatit.allatsimogato.domain.model

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


data class User(
    val title: String,
    val id: Int,
    val timeCreate: LocalDate,
    val timeUpdate: LocalDate
)
