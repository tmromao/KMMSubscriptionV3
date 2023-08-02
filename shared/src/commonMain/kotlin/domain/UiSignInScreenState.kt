package domain

data class UiSignInScreenState(
    val email: String,
    val password: String,
    val isSignInButtonEnabled: Boolean
)
