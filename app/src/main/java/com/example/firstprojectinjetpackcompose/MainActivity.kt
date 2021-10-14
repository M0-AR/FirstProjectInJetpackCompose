package com.example.firstprojectinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
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
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    Box {
        Text("First Text")
        Text("Second Text")
    }
    // var textState by remember { mutableStateOf("" }
    // TextField(value = textState, onValueChange = {})
}

@Composable
fun MyTextField() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstProjectInJetpackComposeTheme {
        MyScreen()
    }
}