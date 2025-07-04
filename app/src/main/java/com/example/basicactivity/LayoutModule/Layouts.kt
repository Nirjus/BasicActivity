package com.example.basicactivity.LayoutModule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

// Column, it allows you to place its children in a verticle sequence

@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("text 1")
        Text("text 2")
        Text("text 3")
        Text("text 4")
    }
}

@Composable
fun RowExample() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("text 1")
        Text("text 2")
        Text("text 3")
        Text("text 4")
    }
}

// Box example
@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Black)
        ) {

        }
    }
}

// ConstraintLayout : use only when UI is complex
@Composable
fun ConstraintLayoutExample() {
    Column {
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.LightGray)) {
            val (text1, text2, text3) = createRefs()
            Text("Bottom Left", modifier = Modifier.constrainAs(text1){
                bottom.linkTo(parent.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
            })
            Text("Center", modifier = Modifier.constrainAs(text2){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
            Text("Bottom Right", modifier = Modifier.constrainAs(text3){
                bottom.linkTo(parent.bottom, margin = 8.dp)
                end.linkTo(parent.end, margin = 8.dp)

            })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ColumnExamplePreview() {
//    ColumnExample()
//      RowExample()
//    BoxExample()
    ConstraintLayoutExample()
}
