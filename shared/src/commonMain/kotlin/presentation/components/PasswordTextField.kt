package presentation.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import domain.SignInScreenState
import presentation.SignInScreenEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    state: SignInScreenState,
    onEvent: (SignInScreenEvent) -> Unit,
    modifier: Modifier = Modifier,
    validateStrengthPassword: Boolean = false,
    hasError: Boolean = false,
    onHasStrongPassword: (isStrong: Boolean) -> Unit = {},

    ) {
    val focusManager = LocalFocusManager.current // to hide keyboard
    var showPassword by rememberSaveable { mutableStateOf(false) }
    var isPasswordValid by rememberSaveable { mutableStateOf(false) }


    fun strengthChecker(password: String): Boolean {
        val REGEX_STRONG_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        return when {
            REGEX_STRONG_PASSWORD.toRegex().containsMatchIn(password) -> true
            else -> false
        }
    }

    fun validatePassword(password: String): Boolean {
        return when {
            password.isEmpty() -> false
            password.length < 8 -> false
            else -> strengthChecker(password)
        }
    }

    TextField(
        value = state.password,
        onValueChange = {
            onEvent(SignInScreenEvent.OnPasswordChanged(it))
            isPasswordValid = validatePassword(it)
        },
        //label = { Text(text = "Enter password") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                isPasswordValid = validatePassword(state.password)
                focusManager.clearFocus()
            }
        ),
        singleLine = true,
        isError = isPasswordValid,
        supportingText = {
            if (isPasswordValid) {
                Text(text = "Password is valid")
            } else {
                Text(text = "Invalid password")
            }
        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                val visibilityIcon = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                // localized description for accessibility services
                val description = if (showPassword) {
                    "Hide password"
                } else {
                    "Show password"
                }
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )

}


