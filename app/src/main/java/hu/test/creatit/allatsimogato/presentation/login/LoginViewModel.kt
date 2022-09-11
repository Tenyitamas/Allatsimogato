package hu.test.creatit.allatsimogato.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.test.creatit.allatsimogato.domain.use_case.LoginWithUsernamePasswordUseCase
import hu.test.creatit.allatsimogato.util.Resource
import hu.test.creatit.allatsimogato.util.network_status.NetworkStatus
import hu.test.creatit.allatsimogato.util.network_status.NetworkStatusTracker
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithUsernamePasswordUseCase: LoginWithUsernamePasswordUseCase,
    networkStatusTracker: NetworkStatusTracker
) : ViewModel() {


    private var loginJob: Job? = null


    var state by mutableStateOf(LoginState())
        private set



    init {
        viewModelScope.launch {
            networkStatusTracker.networkStatus
                .collectLatest { status ->
                    state = when(status) {
                        NetworkStatus.Available -> {
                            state.copy(
                                loginButtonDisabled = false
                            )
                        }
                        NetworkStatus.Unavailable -> {
                            state.copy(
                                loginButtonDisabled = true
                            )
                        }
                    }
                }
        }
    }







    fun onEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.OnLoginButtonClick -> {
                onLoginButtonClick()
            }
            is LoginEvent.OnPasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
            is LoginEvent.OnUsernameChange -> {
                state = state.copy(
                    userName = event.username
                )
            }
        }
    }

    private fun onLoginButtonClick() {
        loginJob?.cancel()

        loginJob = viewModelScope.launch {
            loginWithUsernamePasswordUseCase(
                username = state.userName,
                password = state.password
            ).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        state = state.copy(
                            loginResult = LoginResult.Error(result.message ?: "Unknown error")
                        )
                    }
                    is Resource.Loading -> {
                        state = state.copy(
                            loginResult = LoginResult.Loading
                        )
                    }
                    is Resource.Success -> {
                        state = state.copy(
                            loginResult = LoginResult.Success(result.data),
                        )
                    }
                }
            }.launchIn(this)
        }
    }


}