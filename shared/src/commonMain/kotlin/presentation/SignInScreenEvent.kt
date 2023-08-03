package presentation

sealed interface SignInScreenEvent {
    object SignInButtonClicked : SignInScreenEvent
    data class OnEmailChanged(val email: String) : SignInScreenEvent
    data class OnPasswordChanged(val password: String) : SignInScreenEvent
    object OnPasswordVisibilityToggleClicked : SignInScreenEvent
}