package hu.test.creatit.allatsimogato.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.test.creatit.allatsimogato.domain.model.User
import hu.test.creatit.allatsimogato.util.PROFILE_PATH
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(ProfileState())
        private set

    init {
        state = state.copy(
            profile = User(
                id = savedStateHandle.get<Int>("id") ?: 0,
                title = savedStateHandle.get<String>("title") ?: "N/A",
                timeCreate = ZonedDateTime.parse(
                    savedStateHandle.get<String>("time_create"),
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME
                ),
                timeUpdate = ZonedDateTime.parse(
                    savedStateHandle.get<String>("time_update"),
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME
                )
            )
        )

    }
}
