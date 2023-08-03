package core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import presentation.ui.DarkColorScheme
import presentation.ui.LightColorScheme
import presentation.ui.Typography

@Composable
actual fun SubscriptionTheme(
    darktheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darktheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )

}