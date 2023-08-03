package presentation.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.SignInScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import presentation.SignInScreenEvent

class SignInScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignInScreenState())
    val state = _state.asStateFlow()

    var email: String by mutableStateOf("")
        private set

    var password: String by mutableStateOf("")
        private set

    fun onEvent(event: SignInScreenEvent) {
        when (event) {
            is SignInScreenEvent.OnEmailChanged -> {
                _state.value = _state.value.copy(email = event.email)
            }
            is SignInScreenEvent.OnPasswordChanged -> {
                _state.value = _state.value.copy(password = event.password)
            }
           /* is SignInScreenEvent.OnPasswordVisibilityToggleClicked -> {
                _state.value = _state.value.copy(passwordVisibility = state.value.passwordVisibility)
            }*/

            else -> {
                //do nothing
            }
        }
    }

}