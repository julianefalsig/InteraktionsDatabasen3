package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Interaktioner", "jetpack Compose"))

            }
        }
    }
data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message){
    Row {
        Image(
            painter = painterResource(R.drawable.win_20230107_22_04_29_pro),
            contentDescription = "Contact profile picture",
        )
    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message ("Colleague", "He, take a look at Jetpack Compose, it's great!")
    )

}}


