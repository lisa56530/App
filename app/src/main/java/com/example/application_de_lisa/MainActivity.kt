package com.example.application_de_lisa

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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.ui.Modifier
import com.example.application_de_lisa.ui.theme.Application_De_LisaTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.toRoute
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.window.core.layout.WindowWidthSizeClass

@Serializable
class Home

@Serializable
class Film

@Serializable
class Serie

@Serializable
class Acteur

@Serializable
class FilmDetails(val id: Int)

@Serializable
class SerieDetails(val id: Int)

@Serializable
class ActeurDetails(val id: Int)

@Serializable
class Horror




class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
                var requete by remember { mutableStateOf("") }
                var actif by remember { mutableStateOf(false) }

                Scaffold(
                    topBar = {
                        if (currentDestination?.hasRoute<Home>() != true) {
                            SearchBar(
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "icone de recherche",
                                        tint = Color.Magenta
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        modifier = Modifier.clickable {
                                            if (requete.isNotEmpty()) {
                                                requete = ""
                                            } else {
                                                actif = false
                                            }
                                            if (currentDestination?.hasRoute<Film>() == true) {
                                                viewModel.getMovies()
                                            } else if (currentDestination?.hasRoute<Serie>() == true) {
                                                viewModel.getSeries()
                                            } else if (currentDestination?.hasRoute<Acteur>() == true) {
                                                viewModel.getActeurs()
                                            } else if (currentDestination?.hasRoute<Horror>() == true) {
                                                viewModel.getCollectionHorror()
                                            }
                                        },
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "icone fermeture",
                                        tint = Color.Magenta
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                                query = requete,
                                onQueryChange = { requete = it },
                                onSearch = {
                                    actif = false

                                    if (currentDestination?.hasRoute<Film>() == true) {
                                        viewModel.getSearchMovies(it)
                                    } else if (currentDestination?.hasRoute<Serie>() == true) {
                                        viewModel.getSearchSeries(it)
                                    } else if (currentDestination?.hasRoute<Acteur>() == true) {
                                        viewModel.getSearchActeurs(it)
                                    } else if (currentDestination?.hasRoute<Horror>() == true) {
                                        viewModel.getCollectionHorror()
                                    }


                                },
                                active = actif,
                                onActiveChange = { actif = it },
                                placeholder = {
                                    Text(
                                        text = "Recherche..",
                                        color = Color.Magenta
                                    )
                                }
                            ) {
                            }

                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 35.dp),
                    bottomBar = {
                        when (windowSizeClass.windowWidthSizeClass) {
                            WindowWidthSizeClass.COMPACT -> {
                                NavigationBar {
                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Default.Favorite,
                                                contentDescription = "icone de recherche",
                                                tint = Color.Magenta
                                            )
                                        },
                                        label = {
                                            Text(
                                                "Films.",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Magenta
                                            )
                                        },
                                        selected = currentDestination?.hasRoute<Film>() == true,
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = Color.Gray
                                        ),
                                        onClick = { navController.navigate(Film()) }
                                    )

                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Default.Favorite,
                                                contentDescription = "icone de recherche",
                                                tint = Color.Magenta
                                            )
                                        },
                                        label = {
                                            Text(
                                                "Séries.",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Magenta
                                            )
                                        },
                                        selected = currentDestination?.hasRoute<Serie>() == true,
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = Color.Gray
                                        ),
                                        onClick = { navController.navigate(Serie()) }
                                    )
                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Default.Favorite,
                                                contentDescription = "icone de recherche",
                                                tint = Color.Magenta
                                            )
                                        },
                                        label = {
                                            Text(
                                                "Acteurs.",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Magenta
                                            )
                                        },
                                        selected = currentDestination?.hasRoute<Acteur>() == true,
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = Color.Gray
                                        ),
                                        onClick = { navController.navigate(Acteur()) }
                                    )

                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Default.Favorite,
                                                contentDescription = "icone de recherche",
                                                tint = Color.Magenta
                                            )
                                        },
                                        label = {
                                            Text(
                                                "Horror",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Magenta
                                            )
                                        },
                                        selected = currentDestination?.hasRoute<Horror>() == true,
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = Color.Gray
                                        ),
                                        onClick = { navController.navigate(Horror()) }
                                    )
                                }
                            }

                            else -> {}
                        }
                    }
                ) { innerPadding ->

                    Row {

                        when (windowSizeClass.windowWidthSizeClass) {
                            WindowWidthSizeClass.COMPACT -> {
                            }

                            else -> {
                                Column(modifier = Modifier.padding(innerPadding)) {
                                    NavigationRail {
                                        NavigationRailItem(
                                            icon = {
                                                Icon(
                                                    imageVector = Icons.Default.Favorite,
                                                    contentDescription = "icone de recherche",
                                                    tint = Color.Magenta
                                                )
                                            },
                                            label = {
                                                Text(
                                                    "Films.",
                                                    fontSize = 17.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Magenta
                                                )
                                            },
                                            selected = currentDestination?.hasRoute<Film>() == true,
                                            colors = NavigationRailItemDefaults.colors(
                                                indicatorColor = Color.Gray
                                            ),
                                            onClick = { navController.navigate(Film()) }
                                        )
                                        NavigationRailItem(
                                            icon = {
                                                Icon(
                                                    imageVector = Icons.Default.Favorite,
                                                    contentDescription = "icone de recherche",
                                                    tint = Color.Magenta
                                                )
                                            },
                                            label = {
                                                Text(
                                                    "Serie.",
                                                    fontSize = 17.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Magenta
                                                )
                                            },
                                            selected = currentDestination?.hasRoute<Serie>() == true,
                                            colors = NavigationRailItemDefaults.colors(
                                                indicatorColor = Color.Gray
                                            ),
                                            onClick = { navController.navigate(Serie()) }
                                        )
                                        NavigationRailItem(
                                            icon = {
                                                Icon(
                                                    imageVector = Icons.Default.Favorite,
                                                    contentDescription = "icone de recherche",
                                                    tint = Color.Magenta
                                                )
                                            },
                                            label = {
                                                Text(
                                                    "Acteurs.",
                                                    fontSize = 17.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Magenta
                                                )
                                            },
                                            selected = currentDestination?.hasRoute<Acteur>() == true,
                                            colors = NavigationRailItemDefaults.colors(
                                                indicatorColor = Color.Gray
                                            ),
                                            onClick = { navController.navigate(Acteur()) }
                                        )

                                        NavigationRailItem(
                                            icon = {
                                                Icon(
                                                    imageVector = Icons.Default.Favorite,
                                                    contentDescription = "icone de recherche",
                                                    tint = Color.Magenta
                                                )
                                            },
                                            label = {
                                                Text(
                                                    "Horror.",
                                                    fontSize = 17.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Magenta
                                                )
                                            },
                                            selected = currentDestination?.hasRoute<Horror>() == true,
                                            colors = NavigationRailItemDefaults.colors(
                                                indicatorColor = Color.Gray
                                            ),
                                            onClick = { navController.navigate(Horror()) }
                                        )
                                    }

                                }
                            }
                        }

                        Column {
                            NavHost(
                                navController,
                                startDestination = Home()
                                //  modifier = Modifier.padding(innerPadding) on l'enlève car sinon j'ai un espace
                                //au dessus de mes films et séries
                            ) {
                                composable<Home> {
                                    Home(
                                        innerPadding,
                                        navController,
                                        windowSizeClass
                                    )
                                }
                                composable<Film> { Film(innerPadding, viewModel, navController) }
                                composable<Serie> { Serie(innerPadding, viewModel, navController) }
                                composable<Horror> { Horror(innerPadding, viewModel, navController) }
                                composable<Acteur> {
                                    Acteur(
                                        innerPadding,
                                        viewModel,
                                        navController
                                    )
                                }


                                composable<FilmDetails> { navBackStackEntry ->
                                    val filmDetails: FilmDetails = navBackStackEntry.toRoute()
                                    FilmDetailsScreen(
                                        viewModel,
                                        filmDetails.id
                                    )
                                }

                                composable<SerieDetails> { navBackStackEntry ->
                                    val serieDetails: SerieDetails = navBackStackEntry.toRoute()
                                    SerieDetailsScreen(
                                        viewModel,
                                        serieDetails.id
                                    )

                                }
                                composable<ActeurDetails> { navBackStackEntry ->
                                    val acteurDetails: ActeurDetails = navBackStackEntry.toRoute()
                                    ActeurDetailsScreen(
                                        viewModel,
                                        acteurDetails.id
                                    )

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
