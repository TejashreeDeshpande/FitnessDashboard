package com.example.fitnessdashboard.model

data class FitnessStats(
    val steps: Int,
    val calories: Int,
    val distanceKm: Double,
    val activeMinutes: Int,
    val heartRate: Int,
    val sleepHours: Double,
    val workouts: Int
)
