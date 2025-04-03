package com.ozalp.kararsizim.presentation.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ozalp.kararsizim.presentation.compose.categoryDetailScreen.CategoryDetailScreen
import com.ozalp.kararsizim.presentation.compose.categoryScreen.CategoryScreen
import com.ozalp.kararsizim.presentation.state.CategoryScreenState
import com.ozalp.kararsizim.presentation.viewmodel.CategoryDetailScreenViewModel
import com.ozalp.kararsizim.presentation.viewmodel.CategoryScreenViewModel
import com.ozalp.kararsizim.util.CategoryDetailScreenDestination
import com.ozalp.kararsizim.util.CategoryScreenDestination
import org.koin.androidx.compose.koinViewModel

@Composable
fun KararsizimApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    Scaffold { innerPaddings ->

        NavHost(
            navController = navController,
            modifier = modifier.padding(innerPaddings),
            startDestination = CategoryScreenDestination.routeWithArgs
        ) {

            composable(CategoryScreenDestination.routeWithArgs) {
                val categoryScreenViewModel: CategoryScreenViewModel = koinViewModel()
                CategoryScreen(categoryScreenViewModel = categoryScreenViewModel) { categoryId ->

                    navController.navigate(CategoryDetailScreenDestination.route + "/" + categoryId)

                }
            }

            composable(
                CategoryDetailScreenDestination.routeWithArgs,
                arguments = listOf(navArgument(CategoryDetailScreenDestination.argCategoryId) {
                    type = NavType.StringType
                })
            ) {
                val categoryDetailScreenViewModel = koinViewModel<CategoryDetailScreenViewModel>()
                CategoryDetailScreen(viewModel = categoryDetailScreenViewModel)
            }
        }
    }
}