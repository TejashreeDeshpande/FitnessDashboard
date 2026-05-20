package com.example.fitnessdashboard.data.mock

import com.example.fitnessdashboard.model.FitnessStats
import com.example.fitnessdashboard.model.Goal
import com.example.fitnessdashboard.model.GoalType

object MockFitnessData {

    val stats = FitnessStats(
        steps = 7842,
        calories = 563,
        distanceKm = 5.6,
        activeMinutes = 68,
        heartRate = 86,
        sleepHours = 7.3,
        workouts = 24
    )

    val goals = listOf(
        Goal(
            title = "Steps Goal",
            current = 7842,
            target = 10000,
            goalType = GoalType.Steps
        ),
        Goal(
            title = "Workout Goal",
            current = 24,
            target = 30,
            goalType = GoalType.Workout
        ),
        Goal(
            title = "Water Goal",
            current = 2,
            target = 3,
            goalType = GoalType.Water
        )
    )
}