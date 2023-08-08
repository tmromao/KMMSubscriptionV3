import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorContent
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.transitions.FadeTransition
import core.presentation.SubscriptionTheme
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import presentation.navigation.NavSignInScreen
import presentation.navigation.tabNavigation.FavoritesTab
import presentation.navigation.tabNavigation.HomeTab
import presentation.navigation.tabNavigation.ProfileTab
import presentation.ui.SignInScreen
import presentation.ui.SignInScreenViewModel

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {

    SubscriptionTheme(
        darktheme = darkTheme,
        dynamicColor = dynamicColor
    ) {

        //Content()

        /* Surface(
             modifier = Modifier.fillMaxSize(),
             color = MaterialTheme.colorScheme.background
         ) {
         SignInScreen()
         }*/

        Navigator(
            screen = NavSignInScreen,
        )

       /* TabNavigator(HomeTab){
            Scaffold  (

                bottomBar = {
                            NavigationBar(
                                containerColor = Color.Red,
                            ){
                                TabNavigationItem(HomeTab)
                                TabNavigationItem(FavoritesTab)
                                TabNavigationItem(ProfileTab)
                            }


                *//*{
                    BottomNavigation{
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(FavoritesTab)
                        TabNavigationItem(ProfileTab)

                    }*//*
                },

                content = { CurrentTab() },
            )
        }*/

    }


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
