package hu.test.creatit.allatsimogato.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import hu.test.creatit.allatsimogato.ui.theme.LocalSpacing

@Composable
fun ProfileScreen(
    onLogout: () -> Unit,
    onGoToPettingZoo: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val profile = viewModel.state.profile


    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            imageVector = Icons.Default.Person,
            contentDescription = "profile_${profile.id}"
        )

        Spacer(modifier = Modifier.height(LocalSpacing.current.spaceMedium))

        Text(
           text = profile.title
        )

        Spacer(modifier = Modifier.height(LocalSpacing.current.spaceMedium))

        Text(
            text = profile.timeCreate.toString()
        )

        Button(
            onClick = { onGoToPettingZoo() }
        ) {
            Text(text = stringResource(hu.test.creatit.allatsimogato.R.string.petting_zoo))
        }

        Button(
            onClick = { onLogout() }
        ) {
            Text(text = stringResource(hu.test.creatit.allatsimogato.R.string.logout))
        }

    }
}