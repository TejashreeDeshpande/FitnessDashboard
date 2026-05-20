package com.example.fitnessdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.fitnessdashboard.ui.dashboard.FitnessDashboardScreen
import com.example.fitnessdashboard.ui.theme.FitnessDashboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessDashboardTheme {
                FitnessDashboardScreen()
            }
        }
    }
}