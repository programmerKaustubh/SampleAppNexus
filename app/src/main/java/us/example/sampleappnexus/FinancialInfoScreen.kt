package us.example.sampleappnexus

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

/**
 * FinancialInfoScreen demonstrates autofill for financial data including:
 * - Credit card information (number, CVV, expiration, cardholder name)
 * - Banking information (account number, routing number, account holder)
 * This screen shows proper use of ContentType for financial autofill hints.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinancialInfoScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    // Credit Card Fields
    var cardholderName by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expirationMonth by remember { mutableStateOf("") }
    var expirationYear by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    // Banking Fields
    var accountHolderName by remember { mutableStateOf("") }
    var bankName by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    var routingNumber by remember { mutableStateOf("") }
    var accountType by remember { mutableStateOf("") }

    // Billing Address
    var billingStreet by remember { mutableStateOf("") }
    var billingCity by remember { mutableStateOf("") }
    var billingState by remember { mutableStateOf("") }
    var billingZip by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Financial Information") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Credit Card Information",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Cardholder Name
            OutlinedTextField(
                value = cardholderName,
                onValueChange = { cardholderName = it },
                label = { Text("Cardholder Name") },
                placeholder = { Text("John Doe") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.PersonFullName
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )

            // Card Number
            OutlinedTextField(
                value = cardNumber,
                onValueChange = { cardNumber = it },
                label = { Text("Card Number") },
                placeholder = { Text("1234 5678 9012 3456") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.CreditCardNumber
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Expiration Month
                OutlinedTextField(
                    value = expirationMonth,
                    onValueChange = { if (it.length <= 2) expirationMonth = it },
                    label = { Text("Exp Month") },
                    placeholder = { Text("MM") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentType = ContentType.CreditCardExpirationMonth
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    )
                )

                // Expiration Year
                OutlinedTextField(
                    value = expirationYear,
                    onValueChange = { if (it.length <= 4) expirationYear = it },
                    label = { Text("Exp Year") },
                    placeholder = { Text("YYYY") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentType = ContentType.CreditCardExpirationYear
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    )
                )

                // CVV/Security Code
                OutlinedTextField(
                    value = cvv,
                    onValueChange = { if (it.length <= 4) cvv = it },
                    label = { Text("CVV") },
                    placeholder = { Text("123") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentType = ContentType.CreditCardSecurityCode
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.NumberPassword
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Billing Address",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Billing Street
            OutlinedTextField(
                value = billingStreet,
                onValueChange = { billingStreet = it },
                label = { Text("Street Address") },
                placeholder = { Text("123 Main St") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.AddressStreet
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Billing City
                OutlinedTextField(
                    value = billingCity,
                    onValueChange = { billingCity = it },
                    label = { Text("City") },
                    placeholder = { Text("New York") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(2f)
                        .semantics {
                            contentType = ContentType.AddressLocality
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    )
                )

                // Billing State
                OutlinedTextField(
                    value = billingState,
                    onValueChange = { billingState = it },
                    label = { Text("State") },
                    placeholder = { Text("NY") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentType = ContentType.AddressRegion
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    )
                )
            }

            // Billing Zip
            OutlinedTextField(
                value = billingZip,
                onValueChange = { billingZip = it },
                label = { Text("ZIP Code") },
                placeholder = { Text("10001") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.PostalCode
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Bank Account Information",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Account Holder Name
            OutlinedTextField(
                value = accountHolderName,
                onValueChange = { accountHolderName = it },
                label = { Text("Account Holder Name") },
                placeholder = { Text("John Doe") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Account holder name"
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )

            // Bank Name
            OutlinedTextField(
                value = bankName,
                onValueChange = { bankName = it },
                label = { Text("Bank Name") },
                placeholder = { Text("Bank of America") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Bank name"
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )

            // Account Number
            OutlinedTextField(
                value = accountNumber,
                onValueChange = { accountNumber = it },
                label = { Text("Account Number") },
                placeholder = { Text("0123456789") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Account number"
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                )
            )

            // Routing Number
            OutlinedTextField(
                value = routingNumber,
                onValueChange = { routingNumber = it },
                label = { Text("Routing Number") },
                placeholder = { Text("021000021") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Routing number"
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                )
            )

            // Account Type
            OutlinedTextField(
                value = accountType,
                onValueChange = { accountType = it },
                label = { Text("Account Type") },
                placeholder = { Text("Checking or Savings") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Account type"
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                )
            )

            Button(
                onClick = {
                    Log.d("FinancialInfo", "Card: $cardNumber, Bank: $accountNumber")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}
