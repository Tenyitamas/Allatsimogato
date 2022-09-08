package hu.test.creatit.allatsimogato.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColors(
    val loginButtonColor: Color = Color(0xFFFF9F0A)
)

val LocalColors = compositionLocalOf { AppColors() }