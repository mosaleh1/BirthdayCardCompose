package tech.mosaleh.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.mosaleh.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Column {
                    Surface {
                        BirthdayGreetingWithImage("Ali", "Sarah", Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(name: String, from: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    )
    {
        Text(
            fontSize = 34.sp,
            text = "Happy Birthday $name!",
            modifier = Modifier
                .padding(
                    top = 16.dp
                )
        )
        Text(
            text = "From $from!",
            fontSize = 19.sp,
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    end = 10.dp
                )
                .align(alignment = Alignment.End)

        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier?) {
    val image = painterResource(id = R.drawable.androidparty)
    val description = stringResource(id = R.string.birthdayDescription)
    Box {
        Image(
            painter = image,
            contentDescription = description,
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(name = message, from = from)
    }
}


