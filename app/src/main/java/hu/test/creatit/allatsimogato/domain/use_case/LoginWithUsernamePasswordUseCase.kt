package hu.test.creatit.allatsimogato.domain.use_case

import hu.test.creatit.allatsimogato.domain.model.User
import hu.test.creatit.allatsimogato.domain.repository.AuthRepository
import hu.test.creatit.allatsimogato.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginWithUsernamePasswordUseCase(
    private val repository: AuthRepository
) {
    operator fun invoke(
        username: String,
        password: String
    ) : Flow<Resource<User>> {
        if(username.isBlank() || password.isBlank()) {
            return flow {  }
        }

        return repository.loginWithUsernamePassword(
            username = username,
            password = password
        )
    }
}