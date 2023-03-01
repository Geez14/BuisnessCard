package com.example.buisnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnesscard.ui.theme.BuisnessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuisnessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    CardUI()
                }
            }
        }
    }
}

@Composable
fun CardUI() {
    Card_data(
        stringResource(R.string.title),
        stringResource(R.string.discription),
        stringResource(R.string.phone),
        stringResource(R.string.link),
        stringResource(R.string.email),
        ColorFilter.tint(color = Color(0xFF3DDC84))
    )

}

@Composable
private fun Card_data(
    Title: String,
    Description: String,
    Phone: String,
    Link: String,
    Email: String,
    colorFilter: ColorFilter
) {
    Column(
        modifier = Modifier
            .background(Color(0xFF072D3D))
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box(Modifier.fillMaxWidth())
        {
            Top_Row(
                painterResource(id = R.drawable.android_logo),
                Name = Title,
                Description = Description
            )
        }

        Spacer(modifier = Modifier.size(200.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        {
            Column {
                Info_Design(
                    painterResource(R.drawable.baseline_phone_24),
                    Phone,
                    Icon_Color = colorFilter
                )
                Info_Design(
                    painterResource(R.drawable.baseline_link_24),
                    Link,
                    Icon_Color = colorFilter
                )
                Info_Design(
                    painterResource(R.drawable.baseline_email_24),
                    Email,
                    Icon_Color = colorFilter
                )
            }
        }
    }
}


@Composable
private fun Top_Row(Image: Painter, Name: String, Description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = Image,
            contentDescription = "Logo",
            Modifier
                .size(110.dp)
        )
        Text(
            Name,
            modifier = Modifier
                .padding(start = 2.dp, end = 2.dp, bottom = 2.dp),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
        )
        Text(
            text = Description,
            modifier = Modifier
                .padding(start = 2.dp, end = 2.dp, bottom = 2.dp),
            fontSize = 16.sp,
            color = Color(0xFF3ddc84)
        )
    }
}


@Composable

fun Info_Design(Icon: Painter, Info: String, Icon_Color: ColorFilter) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            painter = Icon,
            contentDescription = null,
            colorFilter = Icon_Color,
            modifier = Modifier
                .weight(0.5f)
                .padding(end = 20.dp),
            alignment = Alignment.BottomEnd
        )

        Text(
            text = Info, modifier = Modifier.weight(1f),
            fontSize = 16.sp,
            fontWeight = FontWeight.W800,
            textAlign = TextAlign.Start
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CardUIPreview() {
    BuisnessCardTheme {
        CardUI()
    }
}