package com.example.application_de_lisa

import MainViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.getValue
import coil.compose.AsyncImage

@Composable
fun Film(padding: PaddingValues, viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilmText()
        Spacer(modifier = Modifier.height(10.dp))
        FilmsScreen(viewModel)


    }
}



@Composable
fun FilmText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Regarde mes films",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.Start) // Aligner le texte à gauche
        )
    }
}



@Composable
fun FilmsScreen(viewModel: MainViewModel) {

    val films by viewModel.movies.collectAsState() // on a deja une listeoff()
Column {
    LaunchedEffect(Unit) {
        viewModel.getMovies()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2))

    {
        items(films) { movie ->
            MovieItem(movie = movie) // Passe le bon type ici
        }
    }
}
}


@Composable
fun MovieItem(movie: ModelMovies) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Charge et affiche l'image du film
        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
        AsyncImage(
            model = imageUrl,
            contentDescription = movie.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Hauteur fixe pour les images
        )
        Spacer(modifier = Modifier.height(8.dp)) // Espace entre l'image et le texte
        Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
    }
}

