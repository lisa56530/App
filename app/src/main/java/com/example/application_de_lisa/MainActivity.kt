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
                                icon = { painterResource(R.drawable.th_4206553874);
                                  },
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


/*

package com.example.application_de_lisa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

// Classes Parcelable
@Parcelize
data class Profil(val name: String = "Profil Example") : Parcelable

@Parcelize
data class Film(val title: String = "Film Example") : Parcelable

// Ecrans
@Composable
fun ProfilScreen(profil: Profil) {
    Text(text = "Profil Screen: ${profil.name}")
}

@Composable
fun FilmScreen(film: Film) {
    Text(text = "Film Screen: ${film.title}")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                // Bottom Bar avec Navigation
                Scaffold(
                    bottomBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination

                        NavigationBar {
                            NavigationBarItem(
                                icon = { painterResource(R.drawable.th_4206553874) },
                                label = { Text("Mon profil") },
                                selected = currentDestination?.route == "profil", // On vérifie la route actuelle
                                onClick = {
                                    val profil = Profil()  // Crée l'objet Profil
                                    navController.navigate("profil/${profim}")  // Passe l'objet
                                }
                            )
                            NavigationBarItem(
                                icon = { },
                                label = { Text("Edition du profil") },
                                selected = currentDestination?.route == "film",
                                onClick = {
                                    val film = Film()  // Crée l'objet Film
                                    navController.navigate("film/${film}")  // Passe l'objet
                                }
                            )
                        }
                    }
                ) {
                    // NavHost avec startDestination en tant que chaîne de caractères (route)
                    NavHost(
                        navController = navController,
                        startDestination = "profil/{profil}",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(
                            "profil/{profil}",
                            arguments = listOf(navArgument("profil") { type = NavType.ParcelableType(Profil::class.java) })
                        ) { backStackEntry ->
                            val profil = backStackEntry.arguments?.getParcelable<Profil>("profil") ?: Profil()
                            ProfilScreen(profil = profil)
                        }

                        composable(
                            "film/{film}",
                            arguments = listOf(navArgument("film") { type = NavType.ParcelableType(Film::class.java) })
                        ) { backStackEntry ->
                            val film = backStackEntry.arguments?.getParcelable<Film>("film") ?: Film()
                            FilmScreen(film = film)
                        }
                    }
                }
            }
        }
    }
}

*/