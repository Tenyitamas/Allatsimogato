package hu.test.creatit.allatsimogato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import hu.test.creatit.allatsimogato.navigation.Route
import hu.test.creatit.allatsimogato.presentation.login.LoginScreen
import hu.test.creatit.allatsimogato.presentation.profile.ProfileScreen
import hu.test.creatit.allatsimogato.ui.theme.AllatsimogatoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllatsimogatoTheme {
                val scaffoldState = rememberScaffoldState()
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.LOGIN
                    ) {
                        composable(Route.LOGIN) {
                            LoginScreen(
                                modifier = Modifier.fillMaxSize(),
                                onLogin = { user ->
                                    navController.navigate(
                                        Route.PROFILE
                                            .plus("/${user.id}")
                                            .plus("/${user.title}")
                                            .plus("/${user.timeCreate}")
                                            .plus("/${user.timeCreate}")
                                    )
                                }
                            )
                        }

                        composable(
                            route = Route.PROFILE
                                .plus("/{id}")
                                .plus("/{title}")
                                .plus("/{time_create}")
                                .plus("/{time_update}"),
                            arguments = listOf(
                                navArgument("id") {
                                    type = NavType.IntType
                                },
                                navArgument("title") {
                                    type = NavType.StringType
                                },
                                navArgument("time_create") {
                                    type = NavType.StringType
                                },
                                navArgument("time_update") {
                                    type = NavType.StringType
                                },
                            )
                        ) {
                            ProfileScreen(
                                modifier = Modifier.fillMaxSize(),
                                onLogout = {
                                    navController.navigate(Route.LOGIN)
                                },
                                onGoToPettingZoo = {}
                            )
                        }
                    }

                }
            }
        }
    }
}

