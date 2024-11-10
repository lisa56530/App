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
fun ActeurDetailsScreen(viewModel: MainViewModel, acteurId: Int) {

    val acteur by viewModel.acteurById.collectAsState()

    LaunchedEffect(acteurId)
    {
        viewModel.getActeurById(acteurId)
    }

    acteur?.let { infos ->
        LazyColumn(modifier = Modifier.padding(25.dp)) {
            item {
                Spacer(modifier = Modifier.size(22.dp))
                Text(
                    text = infos.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
            item {
                ImageA(infos)
            }
            item {
                InformationsA(infos)
            }

        }
    }
}


@Composable
fun ImageA(infos: ModelActeurs) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500${infos.profile_path}",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.width(200.dp)
    )

}

@Composable
fun InformationsA(infos: ModelActeurs) {
    Spacer(modifier = Modifier.size(8.dp))
    Row {
        Text(text = "Anniversaire : ", fontWeight = FontWeight.Bold)
        infos.birthday?.let { Text(text = it) }
    }
    Spacer(modifier = Modifier.size(8.dp))
    Row {
        Text(text = "Nationalité : ", fontWeight = FontWeight.Bold)
        Text(text = infos.place_of_birth)
    }
    Spacer(modifier = Modifier.size(8.dp))
    Text(text = "Biographie : ", fontWeight = FontWeight.Bold)
    Text(text = infos.biography)
}
