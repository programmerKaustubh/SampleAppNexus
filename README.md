
# SampleAppNexus

SampleAppNexus is an Android application built using Kotlin and Jetpack Compose. This app demonstrates a simple and intuitive form for collecting user personal information, incorporating best practices like autofill support and accessibility considerations.

## Features

- **Jetpack Compose UI**: Modern, declarative UI approach for easy maintenance and scalability.
- **User Information Form**: Collects comprehensive user details including name, contact information, address, CPF, and SSN.
- **Autofill Integration**: Implements autofill hints to enhance user experience by automatically filling user information.
- **Keyboard Management**: Properly handles keyboard actions and navigation for seamless form filling.

## Tech Stack

- Kotlin
- Android Jetpack Compose
- Material 3

## Project Structure

- **MainActivity.kt**: Sets up the main UI entry point using Compose.
- **UserPersonalInfoForm**: Composable function that renders the user input form.
- **UserInfo.kt**: Data class to hold and transfer user information collected from the form.

## Getting Started

### Prerequisites

- Android Studio Hedgehog (or newer)
- Android SDK 24 or higher

### Installation

Clone the repository:
```bash
git clone https://github.com/yourusername/sampleappnexus.git
```

Open the project in Android Studio and build it.

### Running the App

- Ensure a virtual device or a physical Android device is connected.
- Run the application from Android Studio.

## Usage

Fill out the provided form fields and press **Submit**. Submitted information will be logged for verification.

## Contribution

Contributions are welcome! Please fork the repository and create a pull request with your proposed enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Android Material Design Guidelines](https://m3.material.io/)
