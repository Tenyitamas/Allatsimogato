package hu.test.creatit.allatsimogato.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.test.creatit.allatsimogato.data.repository.AuthRepositoryImpl
import hu.test.creatit.allatsimogato.domain.repository.AuthRepository
import hu.test.creatit.allatsimogato.domain.use_case.LoginWithUsernamePasswordUseCase
import hu.test.creatit.allatsimogato.util.GsonParser
import hu.test.creatit.allatsimogato.util.JsonParser
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PettingZooModule {

    @Singleton
    @Provides
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(jsonParser = GsonParser(Gson()))
    }

    @Singleton
    @Provides
    fun provideLoginWithUsernamePasswordUseCase(repository: AuthRepository)
            : LoginWithUsernamePasswordUseCase {
        return LoginWithUsernamePasswordUseCase(repository = repository)
    }
}