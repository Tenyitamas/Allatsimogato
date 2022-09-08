package hu.test.creatit.allatsimogato.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import hu.test.creatit.allatsimogato.data.dto.UserDto
import hu.test.creatit.allatsimogato.data.dto.response.UserResponse
import hu.test.creatit.allatsimogato.data.mapper.toUser
import hu.test.creatit.allatsimogato.data.response.correctAuthJsonResponse
import hu.test.creatit.allatsimogato.domain.model.User
import hu.test.creatit.allatsimogato.domain.repository.AuthRepository
import hu.test.creatit.allatsimogato.util.JsonParser
import hu.test.creatit.allatsimogato.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.internal.wait


class AuthRepositoryImpl(
    private val jsonParser: JsonParser
) : AuthRepository {
    override fun loginWithUsernamePassword(
        username: String,
        password: String
    ): Flow<Resource<User>> = flow<Resource<User>> {
        emit(Resource.Loading())

        if(username == "user" && password == "pass") {

            delay(200)
            val user = jsonParser.fromJson<UserResponse>(correctAuthJsonResponse, UserResponse::class.java)?.user?.toUser()
            if(user == null) {
                emit(Resource.Error("Couldn't parse user"))
            } else {
                emit(Resource.Success(user))
            }

        } else {
            emit(Resource.Error("Wrong username or password"))
        }


    }.flowOn(
        Dispatchers.IO
    )
}