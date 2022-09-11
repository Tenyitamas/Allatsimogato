package hu.test.creatit.allatsimogato.presentation.other_animals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import hu.test.creatit.allatsimogato.domain.model.Animal
import hu.test.creatit.allatsimogato.presentation.other_animals.components.OtherAnimalItem
import hu.test.creatit.allatsimogato.ui.theme.LocalSpacing

@Composable
fun OtherAnimalsScreen(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        item {
            IconButton(
                onClick = {
                    onGoBack()
                },
                modifier = Modifier.size(spacing.spaceLarge)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
            }
            
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }

        items(Animal.otherAnimals) {animal ->
            OtherAnimalItem(animal = animal, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(spacing.spaceSmall))
        }
    }


}