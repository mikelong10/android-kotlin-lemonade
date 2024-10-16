package com.example.lemonsqueezy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    }
}

@Composable
fun LemonSqueezyTitleBar() {
    Text(
        text = "Lemonade",
        modifier = Modifier
            .padding()
            .background(color = Color.Yellow)
            .fillMaxWidth()
            .height(64.dp)
            .wrapContentSize(Alignment.Center),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    )
}

