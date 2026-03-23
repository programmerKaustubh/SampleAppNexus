package us.example.sampleappnexus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * Sealed class representing all destinations within the application's navigation graph.
 *
 * Each object corresponds to a unique route string used by the [NavHostController].
 * This structure ensures compile-time safety and prevents route string duplication.
 *
 * @param route The unique string identifier for the navigation route.
 */
sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object PersonalInfo : Screen("personal_info")
    data object Financial : Screen("financial")
    data object JobApplication : Screen("job_application")
    data object TestErrors : Screen("test_errors")
}

/**
 * AppNavigation defines the central navigation graph for the SampleAppNexus application.
 *
 * This composable initializes a [NavHost] that manages transitions between the 
 * HomeScreen and the various demonstration and test screens. It also provides the 
 * necessary callbacks to each screen to enable seamless navigation.
 *
 * @param modifier Modifier applied to the NavHost container.
 * @param navController The [NavHostController] used to manage backstack and navigation actions.
 * @param startDestination The initial screen to display when the application starts.
 *
 * @see Screen
 * @see HomeScreen
 * @see TestErrorsScreen
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
