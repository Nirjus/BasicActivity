package com.example.basicactivity.Scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldAppExample() {
    var click by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = Color.Green,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    navigationIconContentColor = MaterialTheme.colorScheme.inverseOnSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.inverseSurface
                ),
                title = { Text("Top app bar") },
            )
        },
        bottomBar = { BottomAppBar() { Text("Bottom app bar") } },
        floatingActionButton = {
            FloatingActionButton(onClick = { click++ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add value")
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(
                """this is scaffold example 
                |See the change in numbers below 👇
                |🔥 Index: $click
            """.trimMargin(), modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold, fontSize = 20.sp,
                lineHeight = 28.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldAppExamplePreview() {
    ScaffoldAppExample()
}