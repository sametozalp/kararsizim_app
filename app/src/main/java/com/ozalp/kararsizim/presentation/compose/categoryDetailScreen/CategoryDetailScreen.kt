package com.ozalp.kararsizim.presentation.compose.categoryDetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozalp.kararsizim.presentation.viewmodel.CategoryDetailScreenViewModel

@Composable
fun CategoryDetailScreen(modifier: Modifier = Modifier, viewModel: CategoryDetailScreenViewModel) {

    val categoryScreenDetailState = viewModel.categoryScreenDetailState.value
    val activityList = categoryScreenDetailState.activityList.shuffled()

    val localConfig = LocalConfiguration.current
    val screenHeight = localConfig.screenHeightDp

    Box(modifier = modifier.fillMaxSize()) {
        if (categoryScreenDetailState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (activityList.size > 0) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier.height((screenHeight * 20 / 100).dp))
                Text(
                    text = activityList[categoryScreenDetailState.index].activityTitle,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = activityList[categoryScreenDetailState.index].activityDescription,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

            FloatingActionButton(
                onClick = {

                    viewModel.changeActivity()

                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Change Icon",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        } else {
            Text(
                "Yakında..", modifier = Modifier.align(Alignment.Center)
            )
        }

    }

}