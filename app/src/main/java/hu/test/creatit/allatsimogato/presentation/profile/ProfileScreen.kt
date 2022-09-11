package hu.test.creatit.allatsimogato.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import hu.test.creatit.allatsimogato.R
import hu.test.creatit.allatsimogato.ui.theme.LocalSpacing
import java.time.format.DateTimeFormatter

@Composable
fun ProfileScreen(
    onLogout: () -> Unit,
    onGoToPettingZoo: () -> Unit,
    onGoToOtherAnimals: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val profile = viewModel.state.profile
    val colors = hu.test.creatit.allatsimogato.ui.theme.LocalColors.current



    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(LocalSpacing.current.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier.size(
                LocalSpacing.current.spaceLarge
            ),
            imageVector = Icons.Default.Person,
            contentDescription = "profile_${profile.id}"
        )

        Spacer(modifier = Modifier.height(LocalSpacing.current.spaceMedium))

        Text(
           text = profile.title
        )

        Spacer(modifier = Modifier.height(LocalSpacing.current.spaceMedium))

        val timeCreateString = profile.timeCreate.format(
            DateTimeFormatter.ofPattern(
                "yyyy:MM:dd HH:mm:ss"
            )
        )
        Text(
            text = timeCreateString
        )

        Button(
            onClick = { onGoToPettingZoo() },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.loginButtonColor,
                contentColor = MaterialTheme.colors.primary
            )
        ) {
            Text(text = stringResource(R.string.petting_zoo))
        }

        Button(
            onClick = { onGoToOtherAnimals() },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.loginButtonColor,
                contentColor = MaterialTheme.colors.primary
            )
        ) {
            Text(text = stringResource(id = R.string.other_animals) )
        }

        Button(
            onClick = { onLogout() },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.loginButtonColor,
                contentColor = MaterialTheme.colors.primary
            )
        ) {
            Text(text = stringResource(R.string.logout))
        }

    }
}