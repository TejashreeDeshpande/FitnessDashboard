package com.example.fitnessdashboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fitnessdashboard.ui.theme.CardColor
import com.example.fitnessdashboard.ui.theme.CyanAccent
import com.example.fitnessdashboard.ui.theme.GrayText

@Composable
fun BottomNavBar() {
    val iconModifier = Modifier.size(34.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = CardColor,
                shape = RoundedCornerShape(28.dp)
            )
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            modifier = iconModifier,
            imageVector = Icons.Outlined.Home,
            contentDescription = "Home",
            tint = CyanAccent
        )
        Icon(
            modifier = iconModifier,
            imageVector = Icons.Outlined.BarChart,
            contentDescription = "Stats",
            tint = GrayText
        )
        Icon(
            modifier = iconModifier,
            imageVector = Icons.Outlined.Person,
            contentDescription = "Profile",
            tint = GrayText
        )
        Icon(
            modifier = iconModifier,
            imageVector = Icons.Outlined.Settings,
            contentDescription = "Settings",
            tint = GrayText
        )
    }
}