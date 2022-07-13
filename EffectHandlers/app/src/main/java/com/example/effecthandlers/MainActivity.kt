package com.example.effecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.effecthandlers.ui.theme.EffectHandlersTheme
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectHandlersTheme {


            }
        }
    }
}

@Composable
fun LaunchedEffect(){

    var text by remember {
        mutableStateOf("")
    }

  LaunchedEffect(key1 = text ){
      delay(1000L)
      println("The text is $text")
  }
}

@Composable
fun RememberCoroutineScope(){
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
            println("Hello World")
        }
    }) {

    }
}

@Composable
fun RememberUpdatedStateDemo(
    onTimeOut: () -> Unit
){
    val updatedOnTimeOut by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(true ){
        delay(1000L)
       updatedOnTimeOut()
    }
}



