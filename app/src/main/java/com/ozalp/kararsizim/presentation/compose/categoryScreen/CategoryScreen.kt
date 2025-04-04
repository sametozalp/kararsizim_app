package com.ozalp.kararsizim.presentation.compose.categoryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozalp.kararsizim.R
import com.ozalp.kararsizim.presentation.state.CategoryScreenState
import com.ozalp.kararsizim.presentation.viewmodel.CategoryScreenViewModel

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    categoryScreenViewModel: CategoryScreenViewModel,
    goToItemInfo: (String) -> Unit,
    goToHaveAProblemScreen: () -> Unit,
) {

    val categoryScreenState = categoryScreenViewModel.categoryScreenState.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            //.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.categories),
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(20.dp))

            if (categoryScreenState.error.isNotEmpty()) {
                Box(modifier = modifier.fillMaxSize()) {
                    Text(
                        text = stringResource(R.string.unkown_error),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = modifier.align(Alignment.Center)
                    )
                }

            }

            if (!categoryScreenState.isLoading)
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(categoryScreenState.categories) { category ->
                        CategoryItem(categoryName = category.category_name) {
                            goToItemInfo(category.id.toString())
                        }
                    }
                }
            else
                CircularProgressIndicator()
        }

        FloatingActionButton(
            onClick = {
                goToHaveAProblemScreen()
            }, modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(text = stringResource(R.string.contact_us), modifier = Modifier.padding(15.dp))
        }
    }
}
