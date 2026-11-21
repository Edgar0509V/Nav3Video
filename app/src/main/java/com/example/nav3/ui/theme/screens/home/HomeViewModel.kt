package com.example.nav3.ui.theme.screens.home

import androidx.lifecycle.ViewModel
import com.example.nav3.data.Product
import com.example.nav3.data.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(sampleProducts)
    val products: StateFlow<List<Product>> = _products.asStateFlow()
}