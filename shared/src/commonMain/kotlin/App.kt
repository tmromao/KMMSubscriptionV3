
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import presentation.ui.SignInScreen
import presentation.ui.SignInScreenViewModel

@Composable
fun App() {

    val viewModel = getViewModel(
        key = "sign-in-screen",
        factory = viewModelFactory {
            SignInScreenViewModel()
        }
    )
    val state by viewModel.state.collectAsState()

        SignInScreen(
            state = state,
            onEvent = viewModel::onEvent
        )
  /*  var currentScreen: Route by rememberSaveable { mutableStateOf(Route.Welcome) }

    MaterialTheme {
        when (currentScreen) {
            Route.Welcome -> WelcomeScreen(
                route = { currentScreen = it }
            )

            Route.Resources -> ResourcesScreen(
                backAction = { currentScreen = Route.Welcome }
            )

            Route.ViewModel -> ViewModelScreen(
                backAction = { currentScreen = Route.Welcome }
            )

            Route.Permissions -> PermissionsScreen(
                backAction = { currentScreen = Route.Welcome }
            )

            Route.Media -> MediaScreen(
                backAction = { currentScreen = Route.Welcome }
            )

            Route.Biometry -> BiometryScreen(
                backAction = { currentScreen = Route.Welcome }
            )

            Route.Geo -> GeoScreen(
                backAction = { currentScreen = Route.Welcome }
            )
        }
    }*/
}

expect fun getPlatformName(): String
