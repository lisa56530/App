package com.example.application_de_lisa


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import androidx.core.content.ContextCompat
import androidx.compose.ui.platform.LocalContext


@Composable
fun Home(padding: PaddingValues, navController: NavHostController, windowClass: WindowSizeClass) {
    when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            Column(
                modifier = Modifier
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Photo()
                Spacer(modifier = Modifier.height(10.dp))
                Description()
                Spacer(modifier = Modifier.height(10.dp))
                Boutton()
                Commencer(navController)
            }
        }

        else -> {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Photo()
                    Spacer(Modifier.size(25.dp))
                    Boutton()
                    Commencer(navController)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Description()
                }


            }
        }
    }

}

@Composable
fun Photo() {
    Box(
        modifier = Modifier
            .size(200.dp)
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
            modifier = Modifier.padding(top = 50.dp)
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
            modifier = Modifier.padding(top = 50.dp)
        )
    }
}

@Composable
fun Boutton() {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley")
            )
            ContextCompat.startActivity(context, intent, null)
        },
        modifier = Modifier.padding(bottom = 37.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)

    ) {
        Text(text = "Viens voir mon dernier album.")
    }
}


@Composable
fun Commencer(navController: NavHostController) {
    Button(
        onClick = { navController.navigate("film") },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
    ) {
        Text(text = "Regarde.")
    }
}
