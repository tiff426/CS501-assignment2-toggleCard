package com.example.togglecard

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.togglecard.ui.theme.ToggleCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToggleCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                Column(modifier = Modifier.padding(top = 50.dp)) {
                    ToggleCard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToggleCardTheme {
        Greeting("Android")
    }
}

@Composable
fun ToggleCard() {
    var funFact by rememberSaveable { mutableStateOf("Tap to see a fun fact!")}
    var clicked by rememberSaveable { mutableStateOf(false)}
    Card(colors = CardDefaults.cardColors(
        containerColor = Color(0xfff0f3a2),
        contentColor = Color.Black
    ), modifier = Modifier.padding(30.dp)
        .size(width = 300.dp, height = 200.dp),
        onClick = {clicked = !clicked; funFact = if (clicked) {"Kotlin was created by JetBrains!"} else {"Tap to see a fun fact!"} } ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = funFact)
        }
    }
}