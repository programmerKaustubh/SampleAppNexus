# SampleAppNexus

A sample Android application for testing [TestNexus](https://twocan.us) Connected Apps integration. Use this app to verify crash alerts, Remote Config change notifications, and performance monitoring with the TestNexus App Health Watcher extension.

## Features

### Test Errors Screen
Trigger controlled crashes and events to test your TestNexus alert pipeline:
- **Crashes**: NullPointerException, IllegalStateException, StackOverflow, and more
- **Unique Timestamped Crash**: Generates a new crash signature every time (guaranteed Eventarc trigger)
- **ANR**: Blocks the main thread for 15 seconds
- **Firebase Performance**: Custom traces (`checkout_flow`, `image_upload`) and network requests
- **Remote Config**: Fetch and display current config values

### Autofill Demonstration
Three form screens demonstrating Android Autofill best practices:
- **Personal Information**: Identity and contact fields
- **Financial Information**: Credit cards and bank accounts
- **Job Application**: Multi-section employment form

## Setup

### Prerequisites
- Android Studio Ladybug or later
- Android SDK 35
- A Firebase project with Crashlytics, Performance Monitoring, and Remote Config enabled

### Steps

1. **Clone this repository**
   ```
   git clone https://github.com/programmerKaustubh/SampleAppNexus.git
   ```

2. **Add your Firebase config**
   - Go to the [Firebase Console](https://console.firebase.google.com/)
   - Create or select a project
   - Add an Android app with package name `us.example.sampleappnexus`
   - Download `google-services.json` and place it in the `app/` directory

3. **Enable Firebase services**
   - Crashlytics: Enable in Firebase Console
   - Performance Monitoring: Enable in Firebase Console
   - Remote Config: Create test parameters (e.g., `api_base_url`, `feature_dark_mode`, `min_app_version`)

4. **Install the TestNexus extension** on your Firebase project
   - Follow the [App Health Watcher Extension](https://github.com/programmerKaustubh/test-nexus-plugin) setup guide

5. **Build and run**
   ```
   ./gradlew :app:assembleDebug
   ```

## Testing the Alert Pipeline

1. **Crash Alerts**: Press "Unique Timestamped Crash" → reopen the app → wait 15-30 minutes for Crashlytics to process
2. **Config Alerts**: Change a Remote Config parameter in Firebase Console → publish → notification arrives within seconds
3. **Performance Alerts**: Press "Custom Trace" buttons → data appears in Cloud Monitoring after 12-24 hours

## Architecture

- **UI**: 100% Jetpack Compose with Material 3
- **Navigation**: Jetpack Navigation with centralized `AppNavigation` graph
- **Min SDK**: 28 (Android 9+)
- **Target SDK**: 35 (Android 15)

## License

Copyright 2024 Twocan Software LLC. All rights reserved.
