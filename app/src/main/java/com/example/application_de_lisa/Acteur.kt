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
fun Acteur(padding: PaddingValues, viewModel: MainViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(22.dp))
        ActeurText()
        Spacer(modifier = Modifier.height(10.dp))
        ActeurScreen(viewModel, navController)
    }
}


@Composable
fun ActeurText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Regarde mes acteurs.",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.Start)
        )
    }
}


@Composable
fun ActeurScreen(viewModel: MainViewModel, navController: NavController) {
    val acteurs by viewModel.acteurs.collectAsState()
    Column {
        LaunchedEffect(Unit) {
            viewModel.getActeurs()
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        )

        {
            items(acteurs) { acteur ->
                ActeurItem(acteur = acteur, navController)
            }
        }
    }
}


@Composable
fun ActeurItem(acteur: ModelActeurs, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(ActeurDetails(acteur.id))
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageUrl = "https://image.tmdb.org/t/p/w500${acteur.profile_path}"
        AsyncImage(
            model = imageUrl,
            contentDescription = acteur.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = acteur.name, style = MaterialTheme.typography.titleMedium)
    }
}
