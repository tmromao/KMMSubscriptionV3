package core.presentation

import androidx.compose.runtime.Composable

@Composable
expect fun SubscriptionTheme(
    darktheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit,
)