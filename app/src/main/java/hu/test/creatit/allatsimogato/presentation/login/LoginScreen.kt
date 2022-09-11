package hu.test.creatit.allatsimogato.presentation.login

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import hu.test.creatit.allatsimogato.R
import hu.test.creatit.allatsimogato.domain.model.User
import hu.test.creatit.allatsimogato.ui.theme.LocalSpacing

@Composable
fun LoginScreen(
    onLogin: (User) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val colors = hu.test.creatit.allatsimogato.ui.theme.LocalColors.current
    val state = viewModel.state


    BackHandler(true) {
        
    }

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = state.userName,
                onValueChange = { viewModel.onEvent(LoginEvent.OnUsernameChange(it)) },
                label = {
                    Text(
                        text = stringResource(id = R.string.username)
                    )
                }
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            TextField(
                value = state.password,
                onValueChange = { viewModel.onEvent(LoginEvent.OnPasswordChange(it)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                label = {
                    Text(
                        text = stringResource(id = R.string.password)
                    )
                }
            )

        }

        Button(
            onClick = {
                viewModel.onEvent(LoginEvent.OnLoginButtonClick)
            },
            enabled = !state.loginButtonDisabled,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .align(Alignment.BottomCenter)
                .padding(vertical = spacing.spaceLarge),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.loginButtonColor,
                contentColor = MaterialTheme.colors.primary
            )
        ) {
            Text(stringResource(id = R.string.login))
        }

        when (state.loginResult) {
            is LoginResult.Error -> {
                Toast.makeText(
                    LocalContext.current,
                    state.loginResult.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            LoginResult.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            LoginResult.NotInitiated -> {

            }
            is LoginResult.Success -> {
                LaunchedEffect(Unit) {
                    state.loginResult.user?.let { onLogin(it) }
                }
            }
        }
    }

}