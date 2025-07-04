package com.example.basicactivity.LayoutModule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ModifierExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color = Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "This is the jetpack",
            modifier = Modifier
                .background(Color.Yellow),
            fontSize = 20.sp
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewModifierExample() {
    ModifierExample()
}