package com.example.firstprojectinjetpackcompose

import android.util.Log
import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstprojectinjetpackcompose.ui.theme.FirstProjectInJetpackComposeTheme
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@Composable
fun MyScreenExample02() {
    val viewModel = MainViewModel()


    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // Display the list without RecycleView
        /*viewModel.listOfCurrencies.forEach {
            Text(text = it)
        }*/
        val coroutineScope = rememberCoroutineScope()

        LazyColumn {

          // Display the list with RecycleView
/*        items(viewModel.listOfCurrencies) {
            Text(text = it)
            Text(text = it)
        }*/


            // Display the list with RecycleView by index and item
            itemsIndexed(viewModel.listOfCurrencies) { index, item ->
                Text("Item at index $index is $item")
            }

        }

        val cryptos by viewModel.listOfCryptos.collectAsState()  // collectAsState -> when getting a state converting to a Composable state
        var cryptoState  by remember { mutableStateOf(listOf<String>())}
        viewModel.listOfCryptos
            .onEach {
                cryptoState = it
            }
            .launchIn(coroutineScope)

        LazyColumn(Modifier.padding(top = 20.dp)) {
            items(items = cryptos) {
                Text(it)
            }
        }


        viewModel.addCurrency("RON")


        /*Button(onClick = {
            viewModel.addCurrency("Fun")
            viewModel.addCrypto("cryptoFun")
        }) {
            Text("Add currency")
        }*/

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                viewModel.addCurrency("Fun")
            }) {
                Text("Add currency")
            }

            Button(onClick = {
                viewModel.addCrypto("cryptoFun")
            }) {
                Text("Add Crypto")
            }
        }

        val context = LocalContext.current
        TextView(context).apply {

        }
    }




}

@Composable
fun MyScreenExample01() {
    var textState1 by remember { mutableStateOf("") }
    var textState2 by remember { mutableStateOf("") }

    Column {
        MyTextField(textState = textState1, onValueChange = { textState1 = it })
        MyTextField(textState = textState2, onValueChange = { textState2 = it })
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
            onClick = {
                Log.d(
                    "Button",
                    "textState1: $textState1 textState2: $textState2"
                )
            },
            modifier = Modifier
                .scale(1.2f)
                .padding(64.dp)
        ) {
            Text("Click me!")
        }
    }
}

@Composable
fun MyTextField(textState: String, onValueChange: (String) -> Unit) {
    // TextField(textState, onValueChange, maxLine = 2, shape = RoundedCornerShape(4.dp))
    TextField(textState, onValueChange)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstProjectInJetpackComposeTheme {
        MyScreenExample02()
    }
}