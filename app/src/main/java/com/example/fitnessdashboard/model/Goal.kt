package com.example.fitnessdashboard.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.DirectionsWalk
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.ui.graphics.vector.ImageVector

data class Goal(
    val title: String,
    val current: Int,
    val target: Int,
    val goalType: GoalType
) {
    val progress: Float
        get() = current.toFloat() / target

    val progressText = when (goalType) {
        GoalType.Water -> "${current}/${target} L"
        GoalType.Workout -> "${current}/${target} min"
        GoalType.Steps -> "${current}/${target}"
    }

    fun goalIcon(): ImageVector {
        return when (goalType) {
            GoalType.Steps -> Icons.AutoMirrored.Outlined.DirectionsWalk
            GoalType.Workout -> Icons.Outlined.FitnessCenter
            GoalType.Water -> Icons.Outlined.WaterDrop
        }
    }
}

enum class GoalType {
    Steps,
    Workout,
    Water
}