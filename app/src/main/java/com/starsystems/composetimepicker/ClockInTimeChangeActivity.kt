
package com.starsystems.composetimepicker
/*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView




@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
class ClockInTimeChangeActivity : ComponentActivity() {

    var clockInReason = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(
                displayProgressBar = false,
                darkTheme = false
            ) {
                init()
                initViewModel()
                ScreenContent()
            }
        }
    }

    @Preview
    @Composable
    private fun ScreenContent() {

        AppTheme(
            darkTheme = false,
        ) {
            val scaffoldState = rememberScaffoldState()

            Scaffold(scaffoldState = scaffoldState,
                topBar = {
                    Surface(elevation = 5.dp) {
                        OnTopBarWithButton(text = "Job Report")
                    }
                },

                content = { innerPadding ->
                    CircularProgressBar(isDisplay = false, verticalBias = 0.3f)
                    MainContent(innerPadding, false)
                }
            )
        }
    }


    private fun init() {

    }

    private fun initViewModel() {

    }


    @Composable
    fun MainContent(innerPadding: PaddingValues, b: Boolean) {
        Spacer(modifier = Modifier.padding(innerPadding))
        Column {
            ClockIn()
            GraySpacer()
            EnterReason()

            DateSelecter()
        }
    }

    @Composable
    private fun DateSelecter() {
        val customView = SingleDateAndTimePicker(applicationContext)
        AndroidView(factory = { customView })
    }

    @Composable
    fun ClockIn() {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            // Heading
            Row {
                VerticalDivider()
                Text(
                    text = "Clock In",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(alignment = Alignment.CenterVertically),
                    style = TextStyle(
                        color = cardMainHeadingColor,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                )
            }

            Spacer(modifier = componentSpacer)

            // Pick Time Row
            Row(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Pick time",
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .weight(1.0f)
                        .align(alignment = Alignment.CenterVertically)
                )


                Column(
                    modifier = Modifier
                        .background(cardBgcolor)
                        .weight(1.0f)
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
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

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "9",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Justify,
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painterResource(R.drawable.ic_arrow_datepicker_down),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp),
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = ":",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    )
                }

                Column(
                    modifier = Modifier
                        .background(cardBgcolor)
                        .weight(1.0f)
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
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

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "9",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Justify,
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
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

                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = ":",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    )
                }

                Column(
                    modifier = Modifier
                        .background(cardBgcolor)
                        .weight(1.0f)
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
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

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "AM",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Justify,
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
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
        }
    }

    @Composable
    fun GraySpacer() {
        Spacer(
            modifier = Modifier
                .background(Color(0xFFC4C4C4))
                .height(8.dp)
                .fillMaxWidth()
        )
    }

    @Composable
    fun EnterReason() {

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = textColorPrimary
                    )
                ) {
                    append("Tell us why did you want to clock in manually")
                }

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append(" *")
                }
            })

            Spacer(modifier = smallSpacer)

            */
/* Reason text field *//*

            TextField(value = clockInReason.value, onValueChange = { newText ->

                clockInReason.value = newText

            }, placeholder = { Text("Enter your reason(s) here") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = blueLight,
                    unfocusedIndicatorColor = textColorDisabled,
                    textColor = Grey500,
                    placeholderColor = textColorDisabled
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @Composable
    fun OnTopBarWithButton(
        icon: @Composable () -> Unit = {
            IconButton(onClick = {
                onBackPressed()
            }) {
                Icon(Icons.Filled.ArrowBack, "")
            }
        }, text: String = "Main heading"
    ) {
        TopAppBar(
            title = { Text(text) },
            navigationIcon = icon,
            backgroundColor = Color.White,
            contentColor = Color.Black,
            elevation = 12.dp,
            actions = {
                Text(
                    text = "Next", color = FoundationPrimary,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 10.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
        )
    }
}*/
