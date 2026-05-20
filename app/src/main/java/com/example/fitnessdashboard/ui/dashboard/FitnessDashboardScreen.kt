package com.example.fitnessdashboard.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fitnessdashboard.ui.components.ActivityRingCard
import com.example.fitnessdashboard.ui.components.BottomNavBar
import com.example.fitnessdashboard.ui.components.GoalProgressCard
import com.example.fitnessdashboard.ui.components.GradientCard
import com.example.fitnessdashboard.ui.components.HeaderSection
import com.example.fitnessdashboard.ui.components.StatCard
import com.example.fitnessdashboard.ui.theme.Background
import com.example.fitnessdashboard.ui.theme.White80
import org.koin.androidx.compose.koinViewModel
import kotlin.math.roundToInt
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.fitnessdashboard.common.FitnessIcons

@Composable
fun FitnessDashboardScreen() {

    val viewModel: FitnessDashboardViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val sleepTotal = uiState.stats.sleepHours // 7.32
    val sleepH = sleepTotal.toInt() // 7
    val sleepM = ((sleepTotal - sleepH) * 60).roundToInt() // 19

    Scaffold(
        containerColor = Background,
        bottomBar = {
            Column(
                modifier = Modifier
                    .background(Background)
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                BottomNavBar()
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                HeaderSection()
            }
            item {
                ActivityRingCard(
                    stats = uiState.stats
                )
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StatCard(
                        title = "Heart Rate",
                        value = "${uiState.stats.heartRate} bpm",
                        subTitle = "Avg today",
                        icon = FitnessIcons.Heart,
                        iconColor = Color.Red
                    )

                    StatCard(
                        title = "Sleep",
                        value = "${sleepH}h ${sleepM}m",
                        subTitle = "Last night",
                        icon = FitnessIcons.Sleep,
                        iconColor = Color.Cyan
                    )

                    StatCard(
                        title = "Workout",
                        value = "${uiState.stats.workouts}",
                        subTitle = "This month",
                        icon = FitnessIcons.Workout,
                        iconColor = Color.Green
                    )
                }
            }

            item {
                GradientCard {
                    Column {
                        Text(
                            text = "Daily Goals",
                            color = White80,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            uiState.goals.forEach { goal ->
                                GoalProgressCard(goal = goal)
                            }
                        }
                    }
                }
            }
        }
    }
}
