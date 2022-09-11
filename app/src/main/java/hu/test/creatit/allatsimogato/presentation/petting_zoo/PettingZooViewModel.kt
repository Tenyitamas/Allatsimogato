package hu.test.creatit.allatsimogato.presentation.petting_zoo

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.test.creatit.allatsimogato.R
import hu.test.creatit.allatsimogato.domain.model.Animal
import javax.inject.Inject

@HiltViewModel
class PettingZooViewModel @Inject constructor(

) : ViewModel() {

    var state by mutableStateOf(PettingZooState())
        private set

    fun onAnimalLongClick(animal: Animal) {
        state = state.copy(
            currentAnimalToShow = animal
        )
    }

    fun playSound(context: Context, animal: Animal) {
        val mp: MediaPlayer = MediaPlayer.create(context, animal.sound ?: R.raw.dog)
        mp.start()
    }
}