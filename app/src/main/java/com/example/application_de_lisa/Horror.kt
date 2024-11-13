package com.example.application_de_lisa

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun Horror (padding: PaddingValues, viewModel: MainViewModel, navController: NavController) {
 Column(
         modifier = Modifier
             .fillMaxSize()


     ) {
     HorrorText()
     }
 }





@Composable
fun HorrorItem(horror: collections, navController: NavController) {
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
