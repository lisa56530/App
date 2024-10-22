package com.example.application_de_lisa

import MainViewModel
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.ui.Modifier
import com.example.application_de_lisa.ui.theme.Application_De_LisaTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


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
                val viewModel: MainViewModel = viewModel()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                icon = {
                                    Image(
                                        painter = painterResource(R.drawable.th_4206553874),
                                        contentDescription = null,
                                        modifier = Modifier.size(125.dp)
                                    )
                                },
                                label = { Text("Moi.",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold ) },
                                selected = currentDestination?.route == "home",
                                onClick = { navController.navigate("home") }
                            )

                            NavigationBarItem(
                                icon = {
                                    Image(
                                        painter = painterResource(R.drawable.th_4206553874),
                                        contentDescription = null,
                                        modifier = Modifier.size(120.dp)
                                    )
                                },
                                label = { Text("Viens voir les films.",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold ) },
                                selected = currentDestination?.route == "film",
                                onClick = { navController.navigate("film") }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController,
                        startDestination = "home",
                        Modifier.padding(innerPadding)
                    ) {
                        composable("home") { Home(innerPadding) }
                        composable("film") { Film(innerPadding, viewModel) }

                    }
                }
            }
        }
    }
}
