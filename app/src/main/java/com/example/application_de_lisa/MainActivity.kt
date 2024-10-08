package com.example.application_de_lisa

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavDestination.Companion.hasRoute
import kotlinx.serialization.Serializable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.ui.Modifier
import com.example.application_de_lisa.ui.theme.Application_De_LisaTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.painterResource


@Serializable
class Film
@Serializable
class Profil

class MainActivity : ComponentActivity() {
    private fun <T> composable(t: @Composable () -> Unit) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
            Screen(windowSizeClass)
            Application_De_LisaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Home(innerPadding)
                }


                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(

                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                icon = {},
                                label = { Text("Mon profil") },
                                selected = currentDestination?.hasRoute<Profil>() == true,
                                onClick = { navController.navigate(Profil()) })
                            NavigationBarItem(
                                icon = { }, label = { Text("Edition du profil") },
                                selected = currentDestination?.hasRoute<Film>() == true,
                                onClick = { navController.navigate(Film()) })
                        }
                    })
                { innerPadding ->
                    NavHost(
                        navController, startDestination = Profil(),
                        Modifier.padding(innerPadding)
                    ) {
                        composable<Profil> { ProfilScreen() }
                        composable<Film> { FilmScreen() }
                    }

                }
            }
        }
    }

    }
}





