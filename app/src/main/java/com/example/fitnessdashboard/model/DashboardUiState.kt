package com.example.fitnessdashboard.model

data class DashboardUiState(
    val stats: FitnessStats,
    val goals: List<Goal>
)