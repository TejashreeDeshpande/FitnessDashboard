package com.example.fitnessdashboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.outlined.Bedtime
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessdashboard.ui.theme.CardColor
import com.example.fitnessdashboard.ui.theme.White60
import com.example.fitnessdashboard.ui.theme.White80

@Composable
fun StatCard(
    title: String,
    value: String,
    subTitle: String,
    icon: ImageVector,
    iconColor: Color
) {
    Column(
        modifier = Modifier
            .background(
                color = CardColor,
                shape = RoundedCornerShape(22.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Icon(
                modifier = Modifier
                    .size(16.dp),
                imageVector = icon,
                contentDescription = title,
                tint = iconColor
            )
            Text(
                modifier = Modifier.padding(start = 2.dp),
                text = title,
                color = White80,
                fontSize = 16.sp
            )
        }

        Text(
            text = value,
            color = White80,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp
        )

        Text(
            text = subTitle,
            color = White60,
            fontSize = 14.sp
        )
    }
}
