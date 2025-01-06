package com.example.love_compatibility

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.love_compatibility.ui.theme.Love_compatibilityTheme
import com.example.love_compatibility.ui.theme.lighteggplant
import com.example.love_compatibility.ui.theme.marckscript
import com.example.love_compatibility.ui.theme.pipink
import com.example.love_compatibility.ui.theme.purplypink
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val calculate = remember { mutableStateOf(false) }
            val she = remember { mutableStateOf("") }
            val he = remember { mutableStateOf("") }
            val rezult = remember { mutableStateOf("") }
            val volumeModifier = Modifier.onKeyEvent { keyEvent ->
                when {
                    keyEvent.type == KeyEventType.KeyDown && keyEvent.key == Key.VolumeUp -> {
                        rezult.value = "100"
                        true
                    }
                    keyEvent.type == KeyEventType.KeyDown && keyEvent.key == Key.VolumeDown -> {
                        rezult.value = "0"
                        true
                    }
                    else -> false
                }
            }

            Love_compatibilityTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()) { innerPadding ->
                    Box(modifier = volumeModifier){
                        Image(painter = painterResource(R.drawable.back_hearts), contentDescription = "background",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop)
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "RAEWDA PRODUCTION",
                                modifier = Modifier,
                                fontFamily = marckscript,
                                fontSize = 20.sp,
                                color = lighteggplant
                            )
                            Text(
                                text = "Love&Compatibility",
                                modifier = Modifier,
                                fontFamily = marckscript,
                                fontSize = 50.sp,
                                color = lighteggplant
                            )


                            //textfield she
                            OutlinedTextField(
                                value = she.value,
                                onValueChange = {
                                        new -> she.value = new
                                },
                                modifier = Modifier
                                    .padding(top = 10.dp, start = 15.dp, end = 20.dp),
                                colors = TextFieldDefaults.colors(
                                    cursorColor = lighteggplant,
                                    focusedContainerColor = pipink,
                                    unfocusedContainerColor = pipink,
                                    focusedIndicatorColor = lighteggplant,
                                    unfocusedIndicatorColor = purplypink
                                    ),
                                enabled = true,
                                readOnly = false,
                                placeholder = { Text("her name",
                                    color = lighteggplant,
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,) },
                                textStyle = TextStyle(
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,
                                    color = lighteggplant
                                ),
                                maxLines = 1,
                                singleLine = true,
                                shape = CircleShape
                            )


                            //textfield he
                            OutlinedTextField(
                                value = he.value,
                                onValueChange = {
                                        new -> he.value = new
                                },
                                modifier = Modifier
                                    .padding(top = 10.dp, start = 15.dp, end = 20.dp),
                                colors = TextFieldDefaults.colors(
                                    cursorColor = lighteggplant,
                                    focusedContainerColor = pipink,
                                    unfocusedContainerColor = pipink,
                                    focusedIndicatorColor = lighteggplant,
                                    unfocusedIndicatorColor = purplypink
                                ),
                                enabled = true,
                                readOnly = false,
                                placeholder = { Text("his name",
                                    color = lighteggplant,
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,) },
                                textStyle = TextStyle(
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,
                                    color = lighteggplant
                                ),
                                maxLines = 1,
                                singleLine = true,
                                shape = CircleShape
                            )


                            //calculate
                            Button(
                                onClick = {
                                    calculate.value = true
                                    rezult.value = Random.nextInt(0,100).toString()
                                },
                                modifier = Modifier,
                                colors = ButtonDefaults.buttonColors(lighteggplant)
                            ) {
                                Text(
                                    text = "calculate",
                                    modifier = Modifier,
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,
                                    color = pipink
                                )
                            } //calculate

                            Text(
                                text = she.value + " + " + he.value + " = " + rezult.value + "%",
                                modifier = Modifier
                                    .padding(30.dp),
                                fontFamily = marckscript,
                                fontSize = 50.sp,
                                color = lighteggplant,
                                lineHeight = 60.sp,
                                textAlign = TextAlign.Center
                            )

                            //again
                            Button(
                                onClick = {
                                    calculate.value = false
                                    she.value = ""
                                    he.value = ""
                                    rezult.value = ""
                                },
                                modifier = Modifier,
                                colors = ButtonDefaults.buttonColors(lighteggplant)
                            ) {
                                Text(
                                    text = "again",
                                    modifier = Modifier,
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,
                                    color = pipink
                                    )
                            } //again

                        }
                    }

                }
            }
        }
    }
}
