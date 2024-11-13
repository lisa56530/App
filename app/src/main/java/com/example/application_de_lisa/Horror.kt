package com.example.application_de_lisa

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp







@Composable
fun HorrorItem(horror: collections, navController: NavController) {
}




@Composable
fun Horror(padding: PaddingValues, viewModel: MainViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(22.dp))
        HorrorText()
        Spacer(modifier = Modifier.height(10.dp))
        //HorrorScreen(viewModel, navController)
        
    }
}


@Composable
fun HorrorText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Regarde mes collections.",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.Start)
        )
    }
}


 /*
@Composable
fun HorrorScreen(viewModel: MainViewModel, navController: NavController) {
    val collectionHorror by viewModel.collectionHorror.collectAsState()
    Column {
        LaunchedEffect(Unit) {
            viewModel.getActeurs()
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        )

        {
            items(collectionHorror) { collectionHor ->
                ActeurItem(collectionHor = collectionHor, navController)
            }
        }
    }          erreur que je ne trouve pas avec les valeurs 
}           */      
