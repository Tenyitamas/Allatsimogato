package hu.test.creatit.allatsimogato.presentation.other_animals.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import coil.compose.AsyncImage
import coil.request.ImageRequest
import hu.test.creatit.allatsimogato.R
import hu.test.creatit.allatsimogato.domain.model.Animal
import hu.test.creatit.allatsimogato.domain.model.AnimalImage
import hu.test.creatit.allatsimogato.ui.theme.LocalSpacing

@Composable
fun OtherAnimalItem(
    animal: Animal,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier
            .background(MaterialTheme.colors.surface)
            .size(LocalSpacing.current.spaceLarge),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {


        when (animal.image) {
            AnimalImage.None -> {
                // Do nothing
            }
            is AnimalImage.Resource -> {
                Image(
                    painter = painterResource(id = animal.image.resId),
                    contentDescription = animal.name,
                    modifier = Modifier
                        .size(LocalSpacing.current.spaceLarge)
                )
            }
            is AnimalImage.Url -> {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(animal.image.url)
                        .crossfade(1000)
                        .error(R.drawable.ic_launcher_foreground)
                        .fallback(R.drawable.ic_launcher_foreground)
                        .build(),
                    contentDescription = animal.name,
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(LocalSpacing.current.spaceLarge)


                )
            }
        }

        val words = animal.name.split(' ')
        val annotatedNameString: AnnotatedString = if (words.size > 1) {
            val builder = AnnotatedString.Builder()
            builder.append(animal.name)
            val segment = words[1]
            val start = animal.name.indexOf(segment)
            val end = start + segment.length
            val underlinedStyle = SpanStyle(textDecoration = TextDecoration.Underline)
            builder.addStyle(underlinedStyle, start, end)
            builder.toAnnotatedString()
        } else {
            val builder = AnnotatedString.Builder()
            builder.append(animal.name)
            builder.toAnnotatedString()
        }

        Text(
            text = annotatedNameString,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(start = LocalSpacing.current.spaceExtraSmall)
        )

    }

}