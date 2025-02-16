package com.example.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloandroid.ui.theme.HelloAndroidTheme
import com.example.helloandroid.ui.theme.Pink80

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloAndroidTheme {
                MyApp()
            }

//            HelloAndroidTheme {
//                Scaffold(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Pink80)
//                ) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("Android", "IPhone", "Windows", "Linux")
) {
//    Surface(
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Greeting("Android")
//    }

    Column(modifier) {
        for (name in names) {
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    val text = if (expanded.value) "Show less" else "Click me to expand"

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding))
            {
                Text("Hello,")
                Text(text = name)
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(text = text)
            }
        }


//        Text(
//            text = name,
////                color = Color.Black,
//            textAlign = TextAlign.Center,
//            modifier = modifier.padding(24.dp)
//        )
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    FlexModifierTest(Modifier.padding(20.dp)) {
//        Surface(color = MaterialTheme.colorScheme.primary) {
//            Text(
//                text = name,
////                color = Color.Black,
//                textAlign = TextAlign.Center,
//                modifier = modifier.padding(24.dp)
//            )
//        }
//    }
//}

@Composable
fun FlexModifierTest(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .background(Color.Green)
            .height(300.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Black)
            .padding(16.dp)
            .background(Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        content = content
    )
}

@Preview(showBackground = true, widthDp = 320) // , showSystemUi = true)
@Composable
fun GreetingPreview() {
    HelloAndroidTheme {
        MyApp()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HelloAndroidTheme {
//        Greeting("Android")
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    HelloAndroidTheme {
//        Greeting("IPhone")
//    }
//}