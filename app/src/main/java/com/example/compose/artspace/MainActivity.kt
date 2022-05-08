package com.example.compose.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp(ArtSpace.exhibition)
            }
        }
    }
}

@Composable
fun ArtSpaceApp(exhibits: List<Exhibit>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var current by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            val exhibit = exhibits.getOrElse(current, { exhibits.first() })
            Text(style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = "art space")
            Spacer(modifier = Modifier.height(32.dp))
            Artwork(exhibit = exhibit)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    val next = (current + exhibits.size - 1) % exhibits.size
                    current = next
                }) {
                    Text(stringResource(R.string.previous))
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {
                    val next = (current + 1) % exhibits.size
                    current = next
                }) {
                    Text(stringResource(R.string.next))
                }
            }
        }
    }
}

@Composable
fun Artwork(exhibit: Exhibit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painterResource(id = exhibit.image),
            contentDescription = "soccer player ${exhibit.title}"
        )

        Card() {
            Column() {
                Text(exhibit.title)
                Row() {
                    Text(exhibit.artist)
                    Text("(${exhibit.year})")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkPreview() {
    ArtSpaceTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Artwork(exhibit = ArtSpace.exhibition.first())
        }
    }
}