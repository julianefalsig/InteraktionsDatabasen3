package com.example.interaktionsdatabasen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interaktionsdatabasen.ui.theme.InteraktionsDatabasenTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteraktionsDatabasenTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        InteraktionsDatabasenApp()
                }

            }
        }
    }
}

@Composable
fun InteraktionsDatabasenApp() {
    Box(Modifier.fillMaxSize()) {
        InteraktionsDatabaseCard(
            title = stringResource(R.string.title_interaktions_databasen),
            shortDescription = stringResource(R.string.compose_short_desc),
            longDescription = stringResource(R.string.compose_long_desc),
            imagePainter = painterResource(R.drawable.oig2)

        )

    }
}

@Composable
fun InteraktionsDatabaseCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = longDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, bottom = 350.dp)
        )

        MyBottomNavigation(
            selectedTab = 0,
            onTabSelected = { /* Handle tab selection here */ },)


    }
    }

@Composable
fun MyBottomNavigation(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    val tabs = listOf(
        BottomNavItem.Funktion1,
        BottomNavItem.Funktion2,
        BottomNavItem.FAQ
    )

    BottomNavigation{


        tabs.forEachIndexed { index, tab ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.title
                    )
                },
                modifier = Modifier.padding(10.dp),
                label = { Text(text = tab.title) },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) }

            )
        }
    }
}

sealed class BottomNavItem(val title: String, val icon: ImageVector) {
    object Funktion1 : BottomNavItem("Interaktioner", Icons.Default.AddCircle)
    object Funktion2 : BottomNavItem("præparat", Icons.Default.Share)
    object FAQ : BottomNavItem("FAQ", Icons.Default.Search)
    companion object {
    }
}


@Preview(showBackground = true)
@Composable
fun InteraktionsDatabasenAppPreview() {
    InteraktionsDatabasenTheme {
        InteraktionsDatabaseCard(stringResource(R.string.title_interaktions_databasen),stringResource(R.string.compose_short_desc),stringResource(R.string.compose_long_desc),painterResource(R.drawable.oig2))

    }
}
}

/*
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}

@Composable
fun BottomNavigationBar() {
    BottomNavigation {
        // Add BottomNavigationItems here
        BottomNavigationItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favorites"
                )
            },
            label = { Text(text = "Favorites") }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            },
            label = { Text(text = "Settings") }
        )
    }
}
*/

