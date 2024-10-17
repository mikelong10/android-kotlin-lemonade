package com.example.lemonsqueezy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button (
            onClick = {},
            shape = RoundedCornerShape(dimensionResource(R.dimen.image_button_border_radius)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2)),
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painterResource(R.drawable.lemon_tree),
                contentDescription = "Lemonade stage",
                modifier = Modifier
                    .height(dimensionResource(R.dimen.image_button_height))
                    .width(dimensionResource(R.dimen.image_button_width))
                    .padding(dimensionResource(R.dimen.image_button_padding))
            )
        }
        Text(text = "Tap the lemon tree to select a lemon")
    }
}