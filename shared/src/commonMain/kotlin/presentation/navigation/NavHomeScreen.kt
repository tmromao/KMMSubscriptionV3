package presentation.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import presentation.ui.HomeScreen

object NavHomeScreen: Screen {

        @Composable
        override fun Content() {
            HomeScreen()
        }
}