package com.example.nav3.ui.theme.screens

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.nav3.ui.theme.screens.detail.ProductDetail
import com.example.nav3.ui.theme.screens.detail.ProductDetailScreen
import com.example.nav3.ui.theme.screens.home.Home
import com.example.nav3.ui.theme.screens.home.HomeScreen

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun Navigation() {
    val backStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberViewModelStoreNavEntryDecorator()
        ),
        sceneStrategies = listOf(rememberListDetailSceneStrategy()),
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { -it })
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { it })
        },
        entryProvider = entryProvider {
            entry<Home>(
                metadata = ListDetailSceneStrategy.listPane(
                    detailPlaceholder = {
                        Text(
                            text = "Choose a product from the list",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                )
            ) {
                HomeScreen(
                    onProductClick = { productId ->
                        backStack.add(ProductDetail(productId))
                    }
                )
            }

            entry<ProductDetail>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) { key ->
                ProductDetailScreen(
                    productId = key.productId,
                    onBackClick = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}