package com.example.basicactivity.CheckBox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.util.fastForEachIndexed

@Composable
fun CheckBoxExample() {
    val childCheckBoxState = remember { mutableListOf(false, false, false) }
    val parentState = when {
        childCheckBoxState.all { it } -> ToggleableState.On
        childCheckBoxState.none() -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Select All")
            TriStateCheckbox(state = parentState, onClick = {
                val s = parentState != ToggleableState.On
                childCheckBoxState.indices.forEach {
                    childCheckBoxState[it] = s
                }
            })
        }
            childCheckBoxState.fastForEachIndexed { index, b ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Option ${index + 1}")
                    Checkbox(checked = b, onCheckedChange = { childCheckBoxState[index] = it })
                }
//                TriStateCheckbox(
//                    state = if (b) ToggleableState.On else ToggleableState.Off,
//                    onClick = {
//                        childCheckBoxState[index] = !childCheckBoxState[index]
//                    })
            }

    }
    if(childCheckBoxState.all { it }){
        Text("All options selected")
    }
}

@Preview(showSystemUi = true)
@Composable
fun CheckBoxExamplePreview() {
    CheckBoxExample()
}