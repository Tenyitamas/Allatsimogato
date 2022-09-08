package hu.test.creatit.allatsimogato.presentation.login

sealed class LoginEvent {
    data class OnUsernameChange(val username: String): LoginEvent()
    data class OnPasswordChange(val password: String): LoginEvent()
    object OnLoginButtonClick: LoginEvent()


}