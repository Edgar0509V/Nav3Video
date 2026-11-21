package com.example.nav3.ui.theme.screens.detail

import androidx.lifecycle.ViewModel
import com.example.nav3.data.Product
import com.example.nav3.data.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailViewModel : ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product.asStateFlow()

    fun getProduct(productId: Int): StateFlow<Product?> {
        _product.value = sampleProducts.find { it.id == productId }
        return product
    }
}