# Jetpack Compose Navigation Examples


Sure! Below is a template for a README file for your GitHub repository that demonstrates how to implement basic navigation, passing arguments, and nested navigation using Navigation Compose in Jetpack Compose with Kotlin.

Jetpack Compose Navigation Examples
Welcome to the Jetpack Compose Navigation Examples repository! This project showcases how to implement basic navigation, pass arguments, and handle nested navigation using Navigation Compose in Jetpack Compose with Kotlin.

## Features

- Basic Navigation
- Passing Arguments
- Nested Navigation

## Setup

To get a local copy up and running, follow these simple steps:

1. Clone the repository.

```bash
git clone https://github.com/Bhavyansh03-tech/Navigation_JetpackCompose.git
```

2. Open the project in Android Studio.
3. Build the project.

## Steps to Nested Implement Navigation Compose

To implement Nested Navigation Compose, follow these steps:

1. Add navigation compose dependency in both libs.version.toml and gradle.build.

```bash
navigationCompose = "2.7.7"

androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navigationCompose" }
```


2. Now create sealed class add screens name and routes.

```Kotlin
// Passing arguments :
const val DETAIL_SCREEN_ID = "id"
const val DETAIL_SCREEN_NAME = "name"

// Routes :
const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"
const val AUTHENTICATION_ROUTE = "authentication"

sealed class ScreenName(val route: String) {
    data object Home : ScreenName(route = "home_screen")
    data object Detail : ScreenName(route = "detail_screen/{$DETAIL_SCREEN_ID}/{$DETAIL_SCREEN_NAME}"){
        fun passNameAndId(
            id: Int,
            name: String
        ): String {
            return "detail_screen/$id/$name"
        }
    }
    data object Login : ScreenName(route = "login_screen")
    data object Signup : ScreenName(route = "signup_screen")
}
```


3. Now Create a kotlin file and set up navgraph in that file.

```Kotlin
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AUTHENTICATION_ROUTE,
        route = ROOT_ROUTE
    ){
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}
```


4. Create a new Kotlin file and define a function that extends `NavGraphBuilder` with the name of your navigation graph. For example: `NavGraphBuilder.nameOfNavGraph()`.

```Kotlin
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.nested_nav_graph.screen.LoginScreen
import com.example.nested_nav_graph.screen.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = ScreenName.Login.route,
        route = AUTHENTICATION_ROUTE
    ){
        composable(
            route = ScreenName.Login.route
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = ScreenName.Signup.route
        ){
            SignUpScreen(navController = navController)
        }
    }
}
```


5. Don't forget to initialize `navController` in the `MainActivity`.

```Kotlin
val navController = rememberNavController()
SetupNavGraph(navController = navController)
```


6. Now Add Navigation in screens. For example:

```Kotlin
@Composable
fun LoginScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "Login Screen",
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(35.dp))

            Button(
                onClick = {
                    navController.navigate(ScreenName.Signup.route)
                }
            ) {
                Text(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    text = "SignUp"
                )
            }

            OutlinedButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(HOME_ROUTE)
                }
            ) {
                Text(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    text = "Go To Home Screen"
                )
            }
        }
    }
}
```


7. To pop a screen from the back stack, you can use:

```Kotlin
// Just OnBackPressed() function :->
navController.popBackStack()

// If you want to pass any data to the previous screen :->
navController.navigate(route = ScreenName.Home.route) {
    popUpTo(route = ScreenName.Home.route) {
        inclusive = true
    }
}
```

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

1.> Fork the Project.\
2.> Create your Feature Branch `git checkout -b feature/AmazingFeature`.\
3.> Commit your Changes `git commit -m 'Add some AmazingFeature'`.\
4.> Push to the Branch `git push origin feature/AmazingFeature`.\
5.> Open a Pull Request

## Acknowledgements

- Inspiration from various Android development tutorials and documentation.
## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).
