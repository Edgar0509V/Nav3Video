package com.example.nav3.data

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String
)

val sampleProducts = listOf(
    Product(1, "Jetpack Compose T-Shirt", 25.0, "Camiseta oficial de alta calidad para desarrolladores Android."),
    Product(2, "Kotlin Sticker Pack", 10.0, "Pack de pegatinas troqueladas con el logo de Kotlin y Compose."),
    Product(3, "Android Studio Mug", 15.0, "Taza de cerámica resistente para acompañar tus largas sesiones de código."),
    Product(4, "Mechanical Keyboard", 120.0, "Teclado mecánico switches red con retroiluminación RGB."),
    Product(5, "Developer Hoodie", 45.0, "Sudadera con capucha cómoda y abrigada para oficina o teletrabajo.")
)