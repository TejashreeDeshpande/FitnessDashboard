package com.example.fitnessdashboard.ui.components

import com.example.fitnessdashboard.R
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessdashboard.common.FitnessIcons
import com.example.fitnessdashboard.common.formatWithCommas
import com.example.fitnessdashboard.model.FitnessStats
import com.example.fitnessdashboard.ui.theme.CyanAccent
import com.example.fitnessdashboard.ui.theme.GrayText
import com.example.fitnessdashboard.ui.theme.ProgressBackground
import com.example.fitnessdashboard.ui.theme.PurplePrimary
import com.example.fitnessdashboard.ui.theme.White80


@Composable
fun ActivityRingCard(
    stats: FitnessStats
) {
    val progress by animateFloatAsState(
        targetValue = stats.steps / 10000f,
        animationSpec = tween(durationMillis = 1200),
        label = "stepsProgress"
    )
    GradientCard {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ActivityRing(
                progress = progress,
                steps = stats.steps
            )
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Today's Activity",
                    color = White80
                )

                Spacer(modifier = Modifier.height(12.dp))

                ActivityMiniStat(
                    icon = FitnessIcons.Fire,
                    label = "Calories",
                    value = "${stats.calories} kcal"
                )

                ActivityMiniStat(
                    icon = FitnessIcons.Distance,
                    label = "Distance",
                    value = "${stats.distanceKm} km"
                )

                ActivityMiniStat(
                    icon = FitnessIcons.Time,
                    label = "Active Time",
                    value = "${stats.activeMinutes} min"
                )
            }
        }
    }
}

@Composable
private fun ActivityRing(
    progress: Float,
    steps: Int
) {
    Box(
        modifier = Modifier.size(150.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.size(140.dp)
        ) {
            val strokeWidth = 16.dp.toPx()

            drawCircle(
                color = ProgressBackground,
                radius = size.minDimension / 2,
                style = Stroke(width = strokeWidth)
            )

            drawArc(
                color = PurplePrimary,
                startAngle = -90f,
                sweepAngle = 360f * progress,
                useCenter = false,
                style = Stroke(
                    width = strokeWidth,
                    cap = StrokeCap.Round
                )
            )
            drawArc(
                color = CyanAccent,
                startAngle = -90f,
                sweepAngle = 240f * progress,
                useCenter = false,
                style = Stroke(
                    width = 8.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.width(32.dp),
                painter = painterResource(id = R.drawable.ic_shoes),
                contentDescription = "Shoes",
                tint = Color.Cyan
            )
            Text(
                text = steps.formatWithCommas,
                color = White80,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "steps",
                color = GrayText
            )
        }
    }
}

@Composable
private fun ActivityMiniStat(
    icon: ImageVector,
    label: String,
    value: String
) {
    Row(verticalAlignment = Alignment.Top) {
        Icon(
            modifier = Modifier.padding(4.dp),
            imageVector = icon,
            contentDescription = "Notifications",
            tint = Color.Green
        )

        Column {
            Text(
                text = value,
                color = White80,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = White80,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}