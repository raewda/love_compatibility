package com.example.love_compatibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.love_compatibility.ui.theme.Love_compatibilityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Love_compatibilityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        Text(text = "hi")

                        Text(text = "hi hi hi")

                        //textfield girl

                        //textfield boy

                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                        ) {
                            Text(text = "calculate")
                        }

                        Text(text = "rezult")

                        Button(
                            onClick = {

                            }
                        ) {
                            Text(text = "Again")
                        }
                    }
                }
            }
        }
    }
}
