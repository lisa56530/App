package com.example.application_de_lisa



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application_de_lisa.ui.theme.Application_De_LisaTheme

@Composable
fun ProfilScreen() {
}


@Composable
fun Home(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Photo()
        Spacer(modifier = Modifier.height(16.dp)) // Increased space
        Description()
        Spacer(modifier = Modifier.height(16.dp)) // Increased space
        Boutton()
    }
}

@Composable
fun Photo() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(200.dp) // Adjusted size for Box
            .clip(CircleShape)
            .border(BorderStroke(12.dp, Color.Magenta), CircleShape)
    ) {
        Image(
            painterResource(R.drawable.kanye_west),
            contentDescription = "Kanye",
            modifier = Modifier
                .clip(CircleShape)
                .size(200.dp)
        )
    }
}

@Composable
fun Description() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Manager : KanyeWest@gmail.com",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 25.dp)
        )
        Text(
            text = "Soundcloud : Kanye.Music",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp)
        )
        Text(
            text = "Moi c'est Kanye.",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 60.dp) // Increased bottom padding
        )
    }
}

@Composable
fun Boutton() {
    Button(
        onClick = {
            // Action for button
        },
        modifier = Modifier.padding(bottom= 60.dp)
    ) {
        Text(text = "Viens voir mon dernier album.")
    }
}



@ExperimentalMaterial3Api
@Composable
fun MyTopBar(title: String, onBackPress: () -> Unit) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
            }
        }
    )
}


