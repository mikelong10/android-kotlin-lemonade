package com.example.lemonsqueezy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonsqueezy.ui.theme.LemonSqueezyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonSqueezyTheme {
                LemonSqueezyApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonSqueezyApp() {
    LemonSqueezyContent(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .background(color = Color.White)
    )
}

@Composable
fun LemonSqueezyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        LemonSqueezyTitleBar()
        LemonSqueezyInteractiveArea()
    }
}

@Composable
fun LemonSqueezyTitleBar() {
    Text(
        text = "Lemonade",
        modifier = Modifier
            .padding()
            .background(color = Color(0xFFF8E44C))
            .fillMaxWidth()
            .height(64.dp)
            .wrapContentSize(Alignment.Center),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    )
}

@Composable
fun LemonSqueezyInteractiveArea() {
    var currentStage by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    val lemonadeStageImage = when (currentStage) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val lemonadeStageText = when (currentStage) {
        1 -> R.string.stage_1_text
        2 -> R.string.stage_2_text
        3 -> R.string.stage_3_text
        else -> R.string.stage_4_text
    }

    fun lemonadeTap() {
        when (currentStage) {
            1 -> {
                currentStage = 2
                squeezeCount = (2..4).random()
            }

            2 -> {
                squeezeCount--
                if (squeezeCount == 0) {
                    currentStage = 3
                }
            }

            3 -> {
                currentStage = 4
            }

            4 -> {
                currentStage = 1
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { lemonadeTap() },
            shape = RoundedCornerShape(dimensionResource(R.dimen.image_button_border_radius)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2)),
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painterResource(lemonadeStageImage),
                contentDescription = stringResource(lemonadeStageText),
                modifier = Modifier
                    .height(dimensionResource(R.dimen.image_button_height))
                    .width(dimensionResource(R.dimen.image_button_width))
                    .padding(dimensionResource(R.dimen.image_button_padding))
            )
        }
        Text(text = stringResource(lemonadeStageText))
    }
}