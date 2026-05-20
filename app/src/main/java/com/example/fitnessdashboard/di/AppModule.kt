package com.example.fitnessdashboard.di

import com.example.fitnessdashboard.ui.dashboard.FitnessDashboardViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

val appModule = module {
    viewModel { FitnessDashboardViewModel() }
}