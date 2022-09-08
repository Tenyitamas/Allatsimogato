package hu.test.creatit.allatsimogato.presentation.login

import android.util.Log
import hu.test.creatit.allatsimogato.domain.model.User

data class LoginState(
    val loginResult: LoginResult = LoginResult.NotInitiated,
    val userName: String = "",
    val password: String = "",
    val loginButtonDisabled: Boolean = false
)

sealed class LoginResult() {
    data class Error(val message: String) : LoginResult()
    data class Success(val user: User?) : LoginResult()
    object Loading : LoginResult()
    object NotInitiated : LoginResult()
}
