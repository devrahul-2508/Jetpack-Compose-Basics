package com.example.myapplication

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.s1000rr)
            val description = "BMW S1000 RR"
            val title = "BMW S1000 RR"
            ImageCard(painter = painter, contentDescription = description, title = title)
        }
    }

    @Preview
    @Composable
    fun DisplayCard() {
        val painter = painterResource(id = R.drawable.s1000rr)
        val description = "BMW S1000 RR"
        val title = "BMW S1000 RR"
        ImageCard(painter = painter, contentDescription = description, title = title)
    }
}


@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {

        val gradientGrayWhite = Brush.verticalGradient(0f to Color.Gray, 1000f to Color.White)
        Box(modifier = Modifier.height(200.dp).background(gradientGrayWhite)) {

            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(Brush.verticalGradient(
                            0.5f to Color.Gray.copy(alpha=0F),
                            1F to Color.Black
                        ))
                    }
                },
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    title, style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,

                        )
                )
            }

        }

    }
}


