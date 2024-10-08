package com.example.application_de_lisa

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.ui.Modifier
import com.example.application_de_lisa.ui.theme.Application_De_LisaTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Serializable
data class Film(val id: Int)
@Serializable
data class Profil(val id: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
            Application_De_LisaTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController,
                        startDestination = "profil",
                        Modifier.padding(innerPadding)
                    ) {
                        composable("profil") { ProfilScreen() }
                        composable("film") { FilmScreen() }
                    }

                    NavigationBar {
                        NavigationBarItem(
                            icon = {
                                Image(
                                    painter = painterResource(R.drawable.th_4206553874),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(125.dp)
                                )
                            },
                            label = { Text("Mon profil") },
                            selected = currentDestination?.route == "profil",
                            onClick = { navController.navigate("profil") }
                        )

                        NavigationBarItem(
                            icon = {
                                Image(
                                    painter = painterResource(R.drawable.th_4206553874),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(120.dp)
                                )
                            },
                            label = { Text("Viens voir les films.") },
                            selected = currentDestination?.route == "film",
                            onClick = { navController.navigate("film") }
                        )
                    }
                }
            }
        }
    }
}



