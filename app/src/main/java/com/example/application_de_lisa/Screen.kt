package com.example.application_de_lisa

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.window.core.layout.WindowWidthSizeClass
import java.lang.reflect.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass


@Composable
fun Screen(windowClass: WindowSizeClass) {
    when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            Column(androidx.compose.ui.Modifier.fillMaxSize().padding(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painterResource(R.drawable.kanye_west),
                    contentDescription = "Kanye",
                )
                Text(text = "Description de l'image")
            }
        }
        else -> {
            Row(
                androidx.compose.ui.Modifier.fillMaxSize().padding(),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(R.drawable.kanye_west),
                    contentDescription = "Kanye",
                )
                Text(modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(10.dp),
                    text = "Description de l'image")
            }
        }
    }
}