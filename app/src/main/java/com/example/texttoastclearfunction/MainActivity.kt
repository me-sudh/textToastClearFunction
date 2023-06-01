@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.texttoastclearfunction

import android.os.Bundle
import android.widget.NumberPicker.OnValueChangeListener
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.example.texttoastclearfunction.ui.theme.TextToastClearFunctionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextToastClearFunctionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    body()
                }
            }
        }
    }
}

@Composable
fun body(){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()) {
        Text(text = "Username")
        var user by remember {
            mutableStateOf(TextFieldValue())
        }
        var pas by remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(value = user, onValueChange = {user= it})
        Text(text = "Password")
        TextField(value = pas, onValueChange ={pas= it})
        val textValue= remember {
            mutableStateOf(false)
        }
        val toastValue= remember {
            mutableStateOf(false)
        }
        val clearValue= remember {
            mutableStateOf(false)
        }

        Button(onClick = {textValue.value=true}

        ) {
            Text(text = "Text")
        }
        Button(onClick = {toastValue.value=true}) {
            Text(text = "Toast")
        }
        Button(onClick ={clearValue.value=true}) {
            Text(text = "Clear")
        }

        if(textValue.value){
            Text(text = user.text)
            Text(text = pas.text)
        }

        if(toastValue.value){
            val context= LocalContext.current
            Toast.makeText(context, ""+user.text+"\n"+pas.text, Toast.LENGTH_SHORT).show()
            toastValue.value=false
        }
        if(clearValue.value){
            user=TextFieldValue()
            pas= TextFieldValue()
            textValue.value=false
            clearValue.value=false

        }
    }
}