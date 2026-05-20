package com.example.fitnessdashboard.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.TrackChanges
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessdashboard.model.Goal
import com.example.fitnessdashboard.ui.theme.GrayText
import com.example.fitnessdashboard.ui.theme.GreenSuccess
import com.example.fitnessdashboard.ui.theme.ProgressBackground
import com.example.fitnessdashboard.ui.theme.White80

@Composable
fun GoalProgressCard(
    goal: Goal
) {
    val progress by animateFloatAsState(
        targetValue = goal.progress.coerceIn(0f, 1f),
        animationSpec = tween(durationMillis = 900),
        label = "goalProgress"
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    imageVector = goal.goalIcon(),
                    contentDescription = "goal",
                    tint = Color.Cyan
                )
                Text(
                    text = goal.title,
                    color = White80,
                    fontSize = 16.sp
                )
            }

            Text(
                text = goal.progressText,
                color = GrayText
            )
        }

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = GreenSuccess,
            trackColor = ProgressBackground
        )
    }
}