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
 * JobApplicationScreen demonstrates autofill for employment-related information including:
 * - Personal contact information
 * - Current employment details
 * - Previous employment history
 * - Educational background
 * - Professional references
 * This screen shows comprehensive use of ContentType for job application autofill.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobApplicationScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    // Personal Information
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var addressStreet by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var zipCode by remember { mutableStateOf("") }

    // Current Employment
    var currentEmployer by remember { mutableStateOf("") }
    var currentJobTitle by remember { mutableStateOf("") }
    var currentStartDate by remember { mutableStateOf("") }
    var currentSalary by remember { mutableStateOf("") }

    // Previous Employment
    var previousEmployer by remember { mutableStateOf("") }
    var previousJobTitle by remember { mutableStateOf("") }
    var previousStartDate by remember { mutableStateOf("") }
    var previousEndDate by remember { mutableStateOf("") }

    // Education
    var university by remember { mutableStateOf("") }
    var degree by remember { mutableStateOf("") }
    var major by remember { mutableStateOf("") }
    var graduationYear by remember { mutableStateOf("") }

    // References
    var referenceName by remember { mutableStateOf("") }
    var referenceEmail by remember { mutableStateOf("") }
    var referencePhone by remember { mutableStateOf("") }
    var referenceRelationship by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Job Application") },
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
                text = "Personal Information",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // First Name
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text("First Name") },
                    placeholder = { Text("John") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentType = ContentType.PersonFirstName
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    )
                )

                // Last Name
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = { Text("Last Name") },
                    placeholder = { Text("Doe") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentType = ContentType.PersonLastName
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    )
                )
            }

            // Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                placeholder = { Text("john.doe@example.com") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.EmailAddress
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                )
            )

            // Phone Number
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone Number") },
                placeholder = { Text("(555) 123-4567") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.PhoneNumber
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone
                )
            )

            // Address Street
            OutlinedTextField(
                value = addressStreet,
                onValueChange = { addressStreet = it },
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
                // City
                OutlinedTextField(
                    value = city,
                    onValueChange = { city = it },
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

                // State
                OutlinedTextField(
                    value = state,
                    onValueChange = { state = it },
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

                // ZIP Code
                OutlinedTextField(
                    value = zipCode,
                    onValueChange = { zipCode = it },
                    label = { Text("ZIP") },
                    placeholder = { Text("10001") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentType = ContentType.PostalCode
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Current Employment",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Current Employer
            OutlinedTextField(
                value = currentEmployer,
                onValueChange = { currentEmployer = it },
                label = { Text("Current Employer") },
                placeholder = { Text("ABC Corporation") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Current Employer"
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )

            // Current Job Title
            OutlinedTextField(
                value = currentJobTitle,
                onValueChange = { currentJobTitle = it },
                label = { Text("Job Title") },
                placeholder = { Text("Software Engineer") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Job Title"
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
                // Start Date
                OutlinedTextField(
                    value = currentStartDate,
                    onValueChange = { currentStartDate = it },
                    label = { Text("Start Date") },
                    placeholder = { Text("MM/YYYY") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentDescription = "Start Date"
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    )
                )

                // Current Salary
                OutlinedTextField(
                    value = currentSalary,
                    onValueChange = { currentSalary = it },
                    label = { Text("Current Salary") },
                    placeholder = { Text("$75,000") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentDescription = "Current Salary"
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Previous Employment",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Previous Employer
            OutlinedTextField(
                value = previousEmployer,
                onValueChange = { previousEmployer = it },
                label = { Text("Previous Employer") },
                placeholder = { Text("XYZ Company") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Previous Employer"
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )

            // Previous Job Title
            OutlinedTextField(
                value = previousJobTitle,
                onValueChange = { previousJobTitle = it },
                label = { Text("Job Title") },
                placeholder = { Text("Junior Developer") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Previous Job Title"
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
                // Previous Start Date
                OutlinedTextField(
                    value = previousStartDate,
                    onValueChange = { previousStartDate = it },
                    label = { Text("Start Date") },
                    placeholder = { Text("MM/YYYY") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentDescription = "Previous Start Date"
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    )
                )

                // Previous End Date
                OutlinedTextField(
                    value = previousEndDate,
                    onValueChange = { previousEndDate = it },
                    label = { Text("End Date") },
                    placeholder = { Text("MM/YYYY") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentDescription = "Previous End Date"
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Education",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // University
            OutlinedTextField(
                value = university,
                onValueChange = { university = it },
                label = { Text("University/College") },
                placeholder = { Text("State University") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "University"
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
                // Degree
                OutlinedTextField(
                    value = degree,
                    onValueChange = { degree = it },
                    label = { Text("Degree") },
                    placeholder = { Text("Bachelor's") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentDescription = "Degree"
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    )
                )

                // Major
                OutlinedTextField(
                    value = major,
                    onValueChange = { major = it },
                    label = { Text("Major") },
                    placeholder = { Text("Computer Science") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentDescription = "Major"
                        },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    )
                )
            }

            // Graduation Year
            OutlinedTextField(
                value = graduationYear,
                onValueChange = { graduationYear = it },
                label = { Text("Graduation Year") },
                placeholder = { Text("2020") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Graduation Year"
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Professional Reference",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Reference Name
            OutlinedTextField(
                value = referenceName,
                onValueChange = { referenceName = it },
                label = { Text("Reference Name") },
                placeholder = { Text("Jane Smith") },
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

            // Reference Email
            OutlinedTextField(
                value = referenceEmail,
                onValueChange = { referenceEmail = it },
                label = { Text("Reference Email") },
                placeholder = { Text("jane.smith@company.com") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.EmailAddress
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                )
            )

            // Reference Phone
            OutlinedTextField(
                value = referencePhone,
                onValueChange = { referencePhone = it },
                label = { Text("Reference Phone") },
                placeholder = { Text("(555) 987-6543") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.PhoneNumber
                    },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone
                )
            )

            // Reference Relationship
            OutlinedTextField(
                value = referenceRelationship,
                onValueChange = { referenceRelationship = it },
                label = { Text("Relationship") },
                placeholder = { Text("Former Manager") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Relationship"
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
                    Log.d("JobApplication", "Applicant: $firstName $lastName, Email: $email")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Application")
            }
        }
    }
}
