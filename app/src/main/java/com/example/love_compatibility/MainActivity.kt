package com.example.love_compatibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.love_compatibility.ui.theme.Love_compatibilityTheme
import com.example.love_compatibility.ui.theme.lighteggplant
import com.example.love_compatibility.ui.theme.marckscript
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val calculate = remember { mutableStateOf(false) }
            val she = remember { mutableStateOf(" ") }
            val he = remember { mutableStateOf(" ") }
            val rezult = remember { mutableStateOf("") }

            Love_compatibilityTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()) { innerPadding ->
                    Box{
                        Image(painter = painterResource(R.drawable.back_hearts), contentDescription = "background",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop)
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                        ) {
                            Text(text = "hi")

                            Text(text = "hi hi hi")

                            //textfield she
                            OutlinedTextField(
                                value = she.value,
                                onValueChange = {
                                        new -> she.value = new
                                },
                                modifier = Modifier
                                    .padding(top = 10.dp, start = 15.dp, end = 20.dp),
                                colors = TextFieldDefaults.colors(cursorColor = lighteggplant),
                                enabled = true,
                                readOnly = false,
                                placeholder = { Text("her name",
                                    color = Color.Magenta,
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,) },
                                textStyle = TextStyle(
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,
                                    color = Color.Magenta
                                ),
                                maxLines = 1,
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
                                colors = TextFieldDefaults.colors(cursorColor = lighteggplant),
                                enabled = true,
                                readOnly = false,
                                placeholder = { Text("his name",
                                    color = Color.Magenta,
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,) },
                                textStyle = TextStyle(
                                    fontFamily = marckscript,
                                    fontSize = 40.sp,
                                    color = Color.Magenta
                                ),
                                maxLines = 1,
                                shape = CircleShape
                            )


                            //calculate
                            Button(
                                onClick = {
                                    calculate.value = true
                                    rezult.value = Random.nextInt(0,100).toString()
                                },
                                modifier = Modifier
                            ) {
                                Text(text = "calculate")
                            } //calculate

                            Text(text = she.value + " +" + he.value + " = " + rezult.value + "%")

                            //again
                            Button(
                                onClick = {
                                    calculate.value = false
                                    she.value = " "
                                    he.value = " "
                                    rezult.value = ""
                                }
                            ) {
                                Text(text = "again")
                            } //again
                        }
                    }

                }
            }
        }
    }
}
