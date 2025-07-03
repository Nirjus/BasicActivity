package com.example.basicactivity.INputCheap

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicactivity.INput.CustomTextInput
import com.example.basicactivity.INput.FullyCustomTextFilled
import com.example.basicactivity.R

@Composable
fun InputCheapExample() {
    var enabled by remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(R.drawable.ytlogo),
            contentDescription = "yt logo",
            modifier = Modifier
                .size(300.dp, 300.dp)
                .clip(RoundedCornerShape(45.dp))
        )
        Text(text = if (enabled) "Enabled" else "Disabled", fontSize = 38.sp)

        CustomTextInput()
        FullyCustomTextFilled()

        Spacer(modifier = Modifier.padding(16.dp))

        InputChip(
            selected = enabled,
            onClick = { enabled = !enabled },
            label = { Text(if (enabled) "Enabled" else "Disabled") },
            avatar = {
                if (enabled) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "done", Modifier.size(
                        InputChipDefaults.AvatarSize))
                } else {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close",Modifier.size(
                        InputChipDefaults.AvatarSize))
                }
            },
            trailingIcon = {
                if (enabled) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "done", Modifier.size(
                        InputChipDefaults.AvatarSize))
                } else {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close", Modifier.size(
                        InputChipDefaults.AvatarSize))
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun InputExpensiveExample() {
    InputCheapExample()
}