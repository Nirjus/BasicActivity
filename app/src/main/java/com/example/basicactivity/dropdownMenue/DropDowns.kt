package com.example.basicactivity.dropdownMenue

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DropdownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    val listItems = List(10) { it + 1 }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.TopEnd,
    ) {
        IconButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "more items")
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            listItems.forEach {
                DropdownMenuItem(
                    text = { Text("Option $it") },
                    onClick = {expanded = false},
                    leadingIcon = { Icon(imageVector =  Icons.Default.AccountCircle, contentDescription = null) },
                    trailingIcon = { Icon(imageVector =Icons.Filled.DateRange, contentDescription = null) },
                )
                HorizontalDivider()
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DropdownMenuExamplePreview() {
    DropdownMenuExample()
}