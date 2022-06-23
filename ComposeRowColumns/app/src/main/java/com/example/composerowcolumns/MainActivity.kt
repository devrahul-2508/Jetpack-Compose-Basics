package com.example.composerowcolumns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composerowcolumns.ui.theme.ComposeRowColumnsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(modifier = Modifier
                .width(300.dp)
                .fillMaxHeight(0.7f)
                .background(Color.Green) ,
                horizontalArrangement = Arrangement.SpaceAround,
                 verticalAlignment = Alignment.CenterVertically)
            {
                Text(text = "Hello")
                Text(text = "World")
                Text(text = "Game")
            }

        }
    }
}



