package us.example.sampleappnexus

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * PersonalInfoScreen acts as a high-level container for the personal information form.
 *
 * It provides the standard scaffold layout with a top app bar and a back navigation action.
 * This screen is intended to be used as a destination within a [NavHost].
 *
 * @param onNavigateBack Callback used to navigate back to the previous screen (typically home).
 * @param modifier Modifier applied to the root scaffold of the screen.
 *
 * @see UserPersonalInfoForm
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInfoScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Personal Information") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        UserPersonalInfoForm(
            modifier = Modifier.padding(innerPadding)
        ) { userInfo ->
            // Handle form submission
            android.util.Log.d("PersonalInfo", "User Info: $userInfo")
        }
    }
}
