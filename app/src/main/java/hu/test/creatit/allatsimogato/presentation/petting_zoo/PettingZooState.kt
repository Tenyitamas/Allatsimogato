package hu.test.creatit.allatsimogato.presentation.petting_zoo

import hu.test.creatit.allatsimogato.domain.model.Animal

data class PettingZooState(
    val animals: List<Animal> = Animal.basicAnimals,
    val currentAnimalToShow: Animal? = null,
    val shouldRotate: Boolean = false,
    val shouldPlaySound: Boolean = false
)
