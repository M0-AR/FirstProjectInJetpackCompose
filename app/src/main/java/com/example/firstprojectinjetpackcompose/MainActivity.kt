package com.example.firstprojectinjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.*
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
    var textState by remember { mutableStateOf("" )}

    TextField(value = textState, onValueChange = {
        Log.d("textState", "$it")
        textState = it
    })
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