package hu.test.creatit.allatsimogato.presentation.profile

import hu.test.creatit.allatsimogato.domain.model.User
import java.time.ZonedDateTime

data class ProfileState(
    val profile: User = User("", 1, ZonedDateTime.now(), ZonedDateTime.now())
)
