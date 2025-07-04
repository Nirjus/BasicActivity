package com.example.basicactivity.FloatingButtonExample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionButtonExample(
) {
    var onClick = {}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        FloatingActionButton(onClick) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }

        SmallFloatingActionButton(
            onClick = { onClick() },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "Account box")
        }
        LargeFloatingActionButton(
            onClick = { onClick() },
            shape = CircleShape,
        ) {
            Icon(imageVector = Icons.Filled.Add, "Large floating action button")
        }
        Spacer(modifier = Modifier.padding(16.dp))
        ExtendedFloatingActionButton(
            onClick = { onClick() },
            icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
            text = { Text(text = "Extended FAB") },
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FloatingActionButtonExamplePreview() {
    FloatingActionButtonExample()
}