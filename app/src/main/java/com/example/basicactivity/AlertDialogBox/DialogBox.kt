package com.example.basicactivity.AlertDialogBox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.basicactivity.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialgExample(
    onDissmissRequest: () -> Unit,
    onConfermation: () -> Unit,
    icon: ImageVector,
    dialogTitle: String,
    dialogText: String
) {
    AlertDialog(
        onDismissRequest = { onDissmissRequest() },
        dismissButton = {
            TextButton(onClick = { onDissmissRequest() }) {
                Text("Cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfermation() }) {
                Text("Ok")
            }
        },
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = { Text(dialogTitle) },
        text = { Text(dialogText) },

        )

}

@Composable
fun MinmalDialog(
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = "Wow cool")
            Text(
                text = "This is a minimal Dialog box",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DialogBoxWithImage(message: String, onConfermation: () -> Unit, onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
//                .background(Color.LightGray)
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.ytlogo),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Logo"
                )
                Text(
                    message,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { onConfermation() }, modifier = Modifier.padding(8.dp)) {
                        Text("Confirm")
                    }
                    TextButton(onClick = { onConfermation() }, modifier = Modifier.padding(8.dp)) {
                        Text("Dismiss")
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlertDialogExamplePreview() {
    var openDialBox by remember { mutableStateOf(false) }
    var openMinimulDialogBox by remember { mutableStateOf(false) }
    var openDialogBoxWithImage by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { openDialBox = true }) { Text("Open Dialog box") }
        Button(onClick = { openMinimulDialogBox = true }) { Text("Open Minimal Dialog box") }
        Button(onClick = { openDialogBoxWithImage = true }) { Text("Open Dialog box with Image") }

        if (openDialBox) {
            AlertDialgExample(
                onDissmissRequest = { openDialBox = false },
                onConfermation = { openDialBox = true },
                dialogTitle = "My Dialog Title",
                dialogText = "Are you sure you want to delete this file",
                icon = Icons.Default.MailOutline
            )
        } else if (openMinimulDialogBox) {
            MinmalDialog(onDismissRequest = {
                openMinimulDialogBox = false
            })
        } else if (openDialogBoxWithImage) {
            DialogBoxWithImage(
                message = "This is a dialog box with Image exampl",
                onConfermation = { openDialogBoxWithImage = false },
                onDismissRequest = { openDialogBoxWithImage = false })
        }
    }
}