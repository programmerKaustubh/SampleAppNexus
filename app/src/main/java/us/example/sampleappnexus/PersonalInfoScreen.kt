package us.example.sampleappnexus

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * PersonalInfoScreen wraps the UserPersonalInfoForm with navigation support.
 * This screen demonstrates autofill for personal information fields.
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
