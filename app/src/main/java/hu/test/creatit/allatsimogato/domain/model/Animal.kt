package hu.test.creatit.allatsimogato.domain.model

import androidx.annotation.RawRes
import hu.test.creatit.allatsimogato.R

data class Animal(
    val name: String,
    val image: AnimalImage = AnimalImage.None,
    @RawRes val sound: Int? = null
) {
    companion object {
        val basicAnimals = listOf(
            Animal(
                name = "Marha",
                image = AnimalImage.Resource(resId = R.drawable.cow),
                sound = R.raw.cow
            ),
            Animal(
                name = "Kacsa",
                image = AnimalImage.Resource(resId = R.drawable.duck),
                sound = R.raw.duck
            ),
            Animal(
                name = "Kutya",
                image = AnimalImage.Resource(resId = R.drawable.dog),
                sound = R.raw.dog
            ),
        )

        val otherAnimals = listOf(
            Animal(
                name = "Mantis Shrimp",
                image = AnimalImage.Url(
                    url = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/OdontodactylusScyllarus2.jpg/1200px-OdontodactylusScyllarus2.jpg"
                )
            ),
            Animal(
                "Wolf Fish",
                image = AnimalImage.Url(
                    url = "https://www.americanoceans.org/wp-content/uploads/2021/04/wilffish-face.jpg"
                )
            ),
            Animal(
                "Kangaroo Rat",
                image = AnimalImage.Url(
                    url = "https://upload.wikimedia.org/wikipedia/commons/5/50/Kangaroo-rat.jpg"
                )
            ),
            Animal(
                "Raccoon Dog"
            ),
            Animal(
                "Elephant Seal"
            ),
            Animal(
                "American Bulldog"
            ),
            Animal(
                "Angora Goat"
            ),
            Animal(
                "Cactus Mouse"
            ),
            Animal(
                "Common Furniture Beetle"
            ),
            Animal(
                "Crested Penguin"
            ),
            Animal(
                "English Shepherd"
            ),
            Animal(
                "Formosan Mountain Dog"
            ),
            Animal(
                "Hooded Seal"
            ),
            Animal(
                "Humboldt Squid"
            ),
            Animal(
                "Kiko Goat"
            ),
            Animal(
                "Long-Haired Rottweiler"
            ),
            Animal(
                "Longnose Gar"
            ),
            Animal(
                "Macaroni Penguin"
            ),
            Animal(
                "Mandarin Rat Snake"
            ),
            Animal(
                "Mandarin Rat Snake"
            ),
            Animal(
                "Pygmy python"
            ),
            Animal(
                "White-Eyed Vireo"
            )
        )
    }
}