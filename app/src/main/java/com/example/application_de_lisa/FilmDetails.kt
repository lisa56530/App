package com.example.application_de_lisa

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight


@Composable
fun FilmDetailsScreen(ViewModel: MainViewModel, filmId: Int) {

    val film by ViewModel.movieById.collectAsState()

    LaunchedEffect(filmId)
    {
        ViewModel.getMovieById(filmId)
    }

    film?.let { infos ->
        LazyColumn(modifier = Modifier.padding(25.dp)) {
            item {
                Spacer(modifier = Modifier.size(22.dp))
                Text(
                    text = infos.title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
            item {
                Image(infos)
            }
            item {
                Informations(infos)
            }
        }
    }
}


@Composable
fun Image(infos: ModelMovies) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500${infos.poster_path}",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.width(200.dp)
    )

}

@Composable
fun Informations(infos: ModelMovies) {
    Spacer(modifier = Modifier.size(8.dp))
    Row {
        Text(text = "Genres : ", fontWeight = FontWeight.Bold)
        Text(text = infos.genres.joinToString { it.name })
    }
    Spacer(modifier = Modifier.size(8.dp))
    Row {
        Text(text = "Nationalité : ", fontWeight = FontWeight.Bold)
        Text(text = infos.origin_country.joinToString())
    }
    Spacer(modifier = Modifier.size(8.dp))
    Text(text = "Synopsis : ", fontWeight = FontWeight.Bold)
    Text(text = infos.overview)
}
