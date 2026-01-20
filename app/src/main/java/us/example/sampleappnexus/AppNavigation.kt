package us.example.sampleappnexus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * Defines navigation routes for the app.
 * Each route corresponds to a different screen demonstrating autofill functionality.
 */
sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object PersonalInfo : Screen("personal_info")
    data object Financial : Screen("financial")
    data object JobApplication : Screen("job_application")
    data object TestErrors : Screen("test_errors")
}

/**
 * AppNavigation sets up the navigation graph for the entire app.
 * It defines how users navigate between different form screens.
 */
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        // Home Screen - Main menu with navigation options
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToPersonalInfo = {
                    navController.navigate(Screen.PersonalInfo.route)
                },
                onNavigateToFinancial = {
                    navController.navigate(Screen.Financial.route)
                },
                onNavigateToJobApplication = {
                    navController.navigate(Screen.JobApplication.route)
                },
                onNavigateToTestErrors = {
                    navController.navigate(Screen.TestErrors.route)
                }
            )
        }

        // Personal Information Form Screen
        composable(Screen.PersonalInfo.route) {
            PersonalInfoScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Financial Information Form Screen
        composable(Screen.Financial.route) {
            FinancialInfoScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Job Application Form Screen
        composable(Screen.JobApplication.route) {
            JobApplicationScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Test Errors Screen - For testing TestNexus Health Dashboard
        composable(Screen.TestErrors.route) {
            TestErrorsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
