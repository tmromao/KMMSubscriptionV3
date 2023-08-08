package presentation.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import presentation.navigation.tabNavigation.FavoritesTab
import presentation.navigation.tabNavigation.HomeTab
import presentation.navigation.tabNavigation.ProfileTab

@OptIn(ExperimentalMaterial3Api::class, ExperimentalVoyagerApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    //Text("HomeScreen")

    TabNavigator(HomeTab,
        tabDisposable = {
            TabDisposable(
                navigator = it,
                tabs = listOf(HomeTab, FavoritesTab, ProfileTab)
            )
        }
    )
    { tabNavigator ->
        Scaffold(
           /* contentWindowInsets = WindowInsets(0,0,0,0),
            topBar = {
                TopAppBar(
                    title = { Text(text = tabNavigator.current.options.title) }
                )

            },*/
            content = {
                tabNavigator.current.Content()
                //CurrentTab()
            },
            bottomBar = {
                NavigationBar(
                    containerColor = Color.Red,
                ) {
                    TabNavigationItem(HomeTab)
                    TabNavigationItem(FavoritesTab)
                    TabNavigationItem(ProfileTab)
                }
            }
        )
    }
}


@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = it,
                    contentDescription = tab.options.title)
            }
        },
    )
}