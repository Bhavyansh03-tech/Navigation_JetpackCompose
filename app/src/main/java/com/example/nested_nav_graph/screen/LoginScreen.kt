package com.example.nested_nav_graph.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nested_nav_graph.navigation.HOME_ROUTE
import com.example.nested_nav_graph.navigation.ScreenName

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