package com.example.application_de_lisa

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun Serie(padding: PaddingValues, viewModel: MainViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(22.dp))
        SerieText()
        Spacer(modifier = Modifier.height(10.dp))
        SerieScreen(viewModel, navController)
    }
}


@Composable
fun SerieText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Regarde mes séries.",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.Start)
        )
    }
}


@Composable
fun SerieScreen(viewModel: MainViewModel, navController: NavController) {
    val series by viewModel.series.collectAsState() // on a deja une listeoff()
    Column {
        LaunchedEffect(Unit) {
            viewModel.getSeries()
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        )

        {
            items(series) { serie ->
                SerieItem(serie = serie, navController)
            }
        }
    }
}


@Composable
fun SerieItem(serie: ModelSeries, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(SerieDetails(serie.id))
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageUrl = "https://image.tmdb.org/t/p/w500${serie.poster_path}"
        AsyncImage(
            model = imageUrl,
            contentDescription = serie.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = serie.name, style = MaterialTheme.typography.titleMedium)
    }
}

