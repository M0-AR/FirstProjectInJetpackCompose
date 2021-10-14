package com.example.firstprojectinjetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstprojectinjetpackcompose.ui.theme.FirstProjectInJetpackComposeTheme
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color

@Composable
fun MyScreen() {
    var textState1 by remember { mutableStateOf("" ) }
    var textState2 by remember { mutableStateOf("" ) }

    Column {
        TextField(
            value = textState1,
            onValueChange = {
                Log.d("textState1", "$it")
                textState1 = it
            },
            Modifier
                .padding(6.dp)
        )

        TextField(
            value = textState2,
            onValueChange = {
                Log.d("textState2", "$it")
                textState2 = it
        },
            Modifier
                .padding(6.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Cyan
            )
        )

        Button(
            onClick = { Log.d("Button",
                "textState1: $textState1 textState2: $textState2")},
            modifier = Modifier
                        .scale(1.2f)
                        .padding(64.dp)
        ) {
            Text("Click me!")
        }
    }
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