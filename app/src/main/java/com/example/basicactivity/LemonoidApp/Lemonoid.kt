package com.example.basicactivity.LemonoidApp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicactivity.R
import kotlin.random.Random

data class LemonadeStepResources(val imageRes: Int, val textRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonoideGame() {
    var counter by remember { mutableIntStateOf(1) }
    var sqizeCount by remember { mutableIntStateOf(0) }
    if (counter == 2 && sqizeCount == 0) {
        sqizeCount = (1..3).random()
    }
    val veriablRes = when (counter) {
        1 -> LemonadeStepResources(R.drawable.lemon_tree, R.string.Lemon_tree)
        2 -> LemonadeStepResources(R.drawable.lemon_squeeze, R.string.Lemon)
        3 -> LemonadeStepResources(R.drawable.lemon_drink, R.string.Glass_of_lemonade)
        4 -> LemonadeStepResources(R.drawable.lemon_restart, R.string.Empty_glass)
        else -> LemonadeStepResources(R.drawable.lemon_tree, R.string.Lemon_tree)
    }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xDDC0DC7B), // Light teal background
                )
            )
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {
                    if (counter >= 4) counter = 1
                    else if (counter == 2) {
                        sqizeCount--
                        if (sqizeCount <= 0) {
                            counter++
                        }
                    } else {
                        counter++
                    }
                }, modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(26.dp))
                    .background(Color(0x70A7CC82)) // Light green background)
            ) {
                Image(
                    painter = painterResource(veriablRes.imageRes),
                    contentDescription = stringResource(veriablRes.textRes),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(160.dp)
                )
            }

            Text(
                text = stringResource(veriablRes.textRes),
                modifier = Modifier.padding(top = 18.dp),
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Black
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LemonoideGamePreview() {
    LemonoideGame()
}