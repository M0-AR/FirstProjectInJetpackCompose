package com.example.firstprojectinjetpackcompose

import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel {
    val listOfCurrencies = mutableStateListOf("DK", "USD")

    private val _listOfCryptos = MutableStateFlow(listOf("BTC", "ETH"))
    val listOfCryptos = _listOfCryptos.asStateFlow()

    fun addCurrency(currency: String) {
        listOfCurrencies.add(currency)
    }

    fun addCrypto(crypto: String) {
        _listOfCryptos.value = _listOfCryptos.value.plus(crypto)
    }
}