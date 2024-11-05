package com.example.jaze

import MainViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.items
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridItemSpan
import com.example.application_de_lisa.FilmDetails
import com.example.application_de_lisa.ModelMovies


@Composable
fun FilmDetailsScreen(ViewModel: MainViewModel,  navController: NavController, filmId: Int) {

    val film by ViewModel.movieById.collectAsState()

    LaunchedEffect(filmId)
    {
        ViewModel.getMovieById(filmId)
    }



    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    )
    {
        film?.let { infos ->

            item(span = { GridItemSpan(2) }) {
                Column {
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(text = infos.title)
                    Image(infos)
                    Informations(infos)
                }

            }



            val lesActeurs=infos.credits.cast.take(6)

            items(lesActeurs) { unActeur ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable {
                            navController.navigate("acteurDetails/${unActeur.id}")
                        }
                ) {

                    //Image(painterResource(id = unActeur.profilePath), contentDescription = unActeur.name)
                    Text(text = unActeur.name)
                }
            }
        }

    }
}




@Composable
fun Image(infos: ModelMovies){
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500${infos.poster_path}",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.width(200.dp)
    )

}

@Composable
fun Informations(infos: ModelMovies){

    Text(text = "Genres")
    infos.genres.forEach { Genre ->
        Text(text = Genre.name)
    }
    Text(text = infos.overview)
    Text(text = infos.original_language)
    Text(text = "Titre original: ${infos.original_title}")

    //Text(text = "Nationalité: ${infos.origin_country.joinToString(", ")}")
    Text(text = "Nationalité:")
    infos.origin_country.forEach { country ->
        Text(text = country)
    }
}