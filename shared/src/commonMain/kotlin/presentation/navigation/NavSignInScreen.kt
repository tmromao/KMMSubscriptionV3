package presentation.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import presentation.ui.SignInScreen

object NavSignInScreen: Screen {

    @Composable
    override fun Content() {
        SignInScreen()
    }
}