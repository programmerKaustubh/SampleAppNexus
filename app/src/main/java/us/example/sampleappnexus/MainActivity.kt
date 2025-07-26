package us.example.sampleappnexus

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.contentDataType
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import us.example.sampleappnexus.ui.theme.SampleAppNexusTheme
import androidx.compose.ui.text.input.ImeAction

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppNexusTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    UserPersonalInfoForm(modifier = Modifier.padding(innerPadding)){ userInfo ->
                        Log.d("MainActivity", "User Info: $userInfo")
                    }
                }
            }
        }
    }
}

@Composable
fun UserPersonalInfoForm(
    modifier: Modifier = Modifier,
    onSubmit: (UserInfo) -> Unit
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    // State for each field
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var street by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var ssn by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // First Name
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") },
            placeholder = { Text("First Name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.FirstName).semantics{
                this.contentType = ContentType.PersonFirstName
            }
        )

        // Last Name
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.LastName).semantics{
                this.contentType = ContentType.PersonLastName
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )

        // Mobile Number
        OutlinedTextField(
            value = mobile,
            onValueChange = { mobile = it },
            label = { Text("Mobile Number") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.PhoneNumber).semantics{
                this.contentType = ContentType.PhoneNumber
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Phone
            )
        )

        // Email Address
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.EmailAddress).semantics{
                this.contentType = ContentType.EmailAddress
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            )
        )

        // Street Address
        OutlinedTextField(
            value = street,
            onValueChange = { street = it },
            label = { Text("Street Address") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.StreetAddressLine1).semantics{
                this.contentType = ContentType.AddressStreet
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )

        // City
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("City") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.AddressLocality).semantics{
                this.contentType = ContentType.AddressLocality
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )

        // State/Region
        OutlinedTextField(
            value = state,
            onValueChange = { state = it },
            label = { Text("State/Region") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.AddressRegion).semantics{
                this.contentType = ContentType.AddressRegion
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )

        // Postal Code
        OutlinedTextField(
            value = postalCode,
            onValueChange = { postalCode = it },
            label = { Text("Postal Code") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.PostalCode).semantics{
                this.contentType = ContentType.PostalCode
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            )
        )

        // Country
        OutlinedTextField(
            value = country,
            onValueChange = { country = it },
            label = { Text("Country") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.CountryName).semantics{
                this.contentType = ContentType.AddressCountry
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )

        // CPF Number
        OutlinedTextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = { Text("CPF Number") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.IDENTITY_NUMBER).semantics{
                this.contentDescription = "IDENTITY NUMBER"
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            )
        )

        // SSN
        OutlinedTextField(
            value = ssn,
            onValueChange = { ssn = it },
            label = { Text("SSN") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().autofill(AutofillType.IDENTITY_NUMBER).semantics{
                this.contentDescription = "IDENTITY NUMBER"
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )

        Button(
            onClick = {
                onSubmit(
                    UserInfo(
                        firstName, lastName, mobile, email, street, city, state, postalCode, country, cpf, ssn
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

// AutofillType extension (Compose doesn't have all hints mapped yet; you'll need an Interop if you want full support)
enum class AutofillType {
    FirstName, LastName, PhoneNumber, EmailAddress,
    StreetAddressLine1, AddressLocality, AddressRegion,
    PostalCode, CountryName, IDENTITY_NUMBER
}

fun Modifier.autofill(type: AutofillType): Modifier = this // No-op, stub for code clarity
// See: https://developer.android.com/jetpack/compose/text/autofill for interop details

// Data class to hold user info
data class UserInfo(
    val firstName: String,
    val lastName: String,
    val mobile: String,
    val email: String,
    val street: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
    val cpf: String,
    val ssn: String
)


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleAppNexusTheme {
        Greeting("Android")
    }
}