package hu.test.creatit.allatsimogato.domain.repository

import hu.test.creatit.allatsimogato.domain.model.User
import hu.test.creatit.allatsimogato.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginWithUsernamePassword(
        username: String,
        password: String
    ) : Flow<Resource<User>>
}