package com.adityasastri.personalapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MenuItem(val title: String, val icon: ImageVector)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdityaSastriApp()
        }
    }
}

@Composable
fun AdityaSastriApp() {
    val maroon = Color(0xFF6D1018)
    val gold = Color(0xFFD6A52E)
    val cream = Color(0xFFFFF8E8)
    val context = LocalContext.current

    var selected by remember { mutableStateOf<String?>(null) }

    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = maroon,
            secondary = gold,
            background = cream
        )
    ) {
        if (selected == null) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(cream)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(maroon)
                        .padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "ॐ",
                        color = gold,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "Aditya Sastri",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "స్మార్త పురోహితులు",
                        color = Color(0xFFFFE9A8),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    "శుభం భూయాత్",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    textAlign = TextAlign.Center,
                    color = maroon,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )

                val menuItems = listOf(
                    MenuItem("మంత్రాలు", Icons.Default.Favorite),
                    MenuItem("పూజలు", Icons.Default.Star),
                    MenuItem("వైదిక జ్యోతిష్యం", Icons.Default.DateRange),
                    MenuItem("వాస్తు", Icons.Default.Home),
                    MenuItem("పూజా సామాగ్రి", Icons.Default.List),
                    MenuItem("నా నోట్స్", Icons.Default.Edit),
                    MenuItem("పంచాంగం", Icons.Default.CalendarMonth),
                    MenuItem("స్తోత్రాలు", Icons.Default.MenuBook),
                    MenuItem("సంప్రదించండి", Icons.Default.Phone)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(menuItems) { item ->

                        Card(
                            onClick = {
                                if (item.title == "సంప్రదించండి") {
                                    context.startActivity(
                                        Intent(
                                            Intent.ACTION_DIAL,
                                            Uri.parse("tel:8800246048")
                                        )
                                    )
                                } else {
                                    selected = item.title
                                }
                            },
                            shape = RoundedCornerShape(18.dp),
                            modifier = Modifier.aspectRatio(0.95f)
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {

                                Icon(
                                    item.icon,
                                    contentDescription = item.title,
                                    tint = maroon,
                                    modifier = Modifier.size(40.dp)
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    item.title,
                                    color = maroon,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(maroon)
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "|| లోకా సమస్తా సుఖినో భవంతు ||",
                        color = Color(0xFFFFE9A8),
                        fontSize = 15.sp
                    )

                    Text(
                        "📞 8800246048",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        } else {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(cream)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(maroon)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = { selected = null }
                    ) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    Text(
                        selected!!,
                        color = Color.White,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "ॐ",
                        color = maroon,
                        fontSize = 70.sp
                    )

                    Text(
                        selected!!,
                        color = maroon,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "ఈ విభాగంలోని సమాచారం త్వరలో జోడించబడుతుంది.",
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
