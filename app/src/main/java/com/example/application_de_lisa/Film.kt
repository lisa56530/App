package com.example.application_de_lisa

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Film(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilmText()
        Spacer(modifier = Modifier.height(10.dp)) // Increased space
        MainScreen()


    }
}



@Composable
fun FilmText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Les films et tout et tout",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.Start) // Aligner le texte à gauche
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var searchText by remember { mutableStateOf(TextFieldValue("Cherche moi")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // Box pour centrer le texte
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Mon Application",
                            color = Color.White, // Couleur du texte
                            textAlign = TextAlign.Center // Centre le texte
                        )
                    }
                },
                actions = {
                    // Champ de recherche dans la TopAppBar
                    TextField(
                        value = searchText.text, // Utiliser le texte
                        onValueChange = { newText -> searchText = TextFieldValue(newText) },
                        modifier = Modifier
                            .width(50.dp) // Ajuste la largeur du TextField
                            .padding(end = 8.dp) // Ajoute un peu d'espace à droite
                            .height(40.dp), // Limite la hauteur du TextField
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent, // Fond transparent pour le TextField
                            focusedTextColor = Color.Black, // Couleur du texte lorsque le champ est focalisé
                            unfocusedTextColor = Color.Black, // Couleur du texte lorsque le champ n'est pas focalisé
                            focusedIndicatorColor = Color.Transparent, // Pas de ligne sous le TextField
                            unfocusedIndicatorColor = Color.Transparent // Pas de ligne sous le TextField quand non focalisé
                        ),
                        placeholder = {
                            Text(
                                text = "Rechercher...",
                                color = Color.Gray // Couleur du placeholder
                            )
                        }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray, // Couleur de fond de la TopAppBar
                    titleContentColor = Color.White // Couleur du texte du titre
                ),
                modifier = Modifier.height(56.dp) // Limite la hauteur de la TopAppBar
            )
        },
        content = { innerPadding ->
            // Utilise innerPadding pour éviter que le contenu ne soit caché par la TopAppBar
            Column(modifier = Modifier.padding(innerPadding)) {
                // Exemple de contenu
                Text(
                    text = "Voici le contenu principal",
                    modifier = Modifier.padding(16.dp),
                    color = Color.Black
                )
            }
        }
    )
}