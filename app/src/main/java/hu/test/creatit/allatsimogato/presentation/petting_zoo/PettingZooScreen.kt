package hu.test.creatit.allatsimogato.presentation.petting_zoo

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import hu.test.creatit.allatsimogato.domain.model.AnimalImage
import hu.test.creatit.allatsimogato.ui.theme.LocalSpacing

@Composable
fun PettingZooScreen(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PettingZooViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val colors = hu.test.creatit.allatsimogato.ui.theme.LocalColors.current


    val isEnabled = remember { mutableStateOf(true) }
    val isRotated = remember { mutableStateOf(false) }

    val angle: Float by animateFloatAsState(
        targetValue = if (isRotated.value) 360F else 0F,
        animationSpec = tween(
            durationMillis = 2000, // duration
            easing = FastOutSlowInEasing
        ),
        finishedListener = {
            // disable the button
            isEnabled.value = true
        }
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = spacing.spaceMedium,
                end = spacing.spaceMedium,
                top = spacing.spaceMedium
            )
    ) {

        LazyColumn(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            items(state.animals) { animal ->
                Button(
                    onClick = { viewModel.onAnimalLongClick(animal) },
                    modifier = Modifier.fillMaxWidth(0.6f),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colors.loginButtonColor,
                        contentColor = MaterialTheme.colors.primary
                    )
                ) {
                    Text(text = animal.name)
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(0.2f)
                .aspectRatio(1f)

        ) {


            state.currentAnimalToShow?.let { animal ->
                when (animal.image) {
                    AnimalImage.None -> {
                        // Do nothing
                    }
                    is AnimalImage.Resource -> {
                        Image(
                            painter = painterResource(id = animal.image.resId),
                            contentDescription = animal.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = isEnabled.value) {
                                    viewModel.playSound(context, animal)
                                    isRotated.value = !isRotated.value
                                    isEnabled.value = false


                                }
                                .rotate(angle),
                            contentScale = ContentScale.Inside

                        )
                    }
                    is AnimalImage.Url -> {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(animal.image.url)
                                .crossfade(1000)
                                .error(hu.test.creatit.allatsimogato.R.drawable.ic_launcher_foreground)
                                .fallback(hu.test.creatit.allatsimogato.R.drawable.ic_launcher_foreground)
                                .build(),
                            contentDescription = animal.name,
                            placeholder = painterResource(id = hu.test.creatit.allatsimogato.R.drawable.ic_launcher_foreground),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable(enabled = isEnabled.value) {
                                    viewModel.playSound(context, animal)
                                    isRotated.value = !isRotated.value
                                    isEnabled.value = false

                                }
                                .rotate(angle)
                        )
                    }
                }
            }

        }

        IconButton(
            onClick = {
                onGoBack()
            },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
        }

    }

}