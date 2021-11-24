package com.starsystems.composetimepicker

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.shawnlin.numberpicker.NumberPicker
import com.starsystems.composetimepicker.ui.theme.ComposeTimePickerTheme

class Pickerclass: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTimePickerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TimeChange()
                }
            }
        }
    }

    @Composable
    fun TimeChange() {
        Column(
            modifier = Modifier
                .width(80.dp)
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(R.drawable.ic_arrow_datepicker_up),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                )
            }


            DateSelecter()

            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(R.drawable.ic_arrow_datepicker_down),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                )
            }
        }

    }

    @Composable
    private fun DateSelecter() {
        val customView = NumberPicker(applicationContext)
        customView.setDividerThickness(0)
        customView.wheelItemCount = 1
        customView.setBackgroundColor(Color.parseColor("#a8a8a8"))
        AndroidView(factory = { customView })
    }
}