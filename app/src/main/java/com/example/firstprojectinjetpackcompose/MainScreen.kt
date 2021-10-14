package com.example.firstprojectinjetpackcompose

import android.util.Log
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstprojectinjetpackcompose.ui.theme.FirstProjectInJetpackComposeTheme

@Composable
fun MyScreen() {
    var textState by remember { mutableStateOf("" ) }

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