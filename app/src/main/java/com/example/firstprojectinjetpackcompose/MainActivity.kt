package com.example.firstprojectinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstprojectinjetpackcompose.ui.theme.FirstProjectInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun MyScreen(name: String) {
    Box {
        Text("First Text")
        Text("Second Text")
    }
}

fun

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstProjectInJetpackComposeTheme {
        Greeting("Android")
    }
}