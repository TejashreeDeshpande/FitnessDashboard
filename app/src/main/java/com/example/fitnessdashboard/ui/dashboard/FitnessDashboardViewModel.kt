package com.example.fitnessdashboard.ui.dashboard

import androidx.lifecycle.ViewModel
import com.example.fitnessdashboard.data.mock.MockFitnessData
import com.example.fitnessdashboard.model.DashboardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FitnessDashboardViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(
            DashboardUiState(
                stats = MockFitnessData.stats,
                goals = MockFitnessData.goals
            )
        )
    val uiState: StateFlow<DashboardUiState>
        get() = _uiState
}