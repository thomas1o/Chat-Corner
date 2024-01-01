package com.example.chatcorner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.chatcorner.data.BottomNavigationItem
import com.example.chatcorner.ui.theme.ChatCornerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = listOf(
                BottomNavigationItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unSelectedIcon = Icons.Outlined.Home,
                    hasNews = false
                ),
                BottomNavigationItem(
                    title = "Cart",
                    selectedIcon = Icons.Filled.ShoppingCart,
                    unSelectedIcon = Icons.Outlined.ShoppingCart,
                    hasNews = false
                ),
                BottomNavigationItem(
                    title = "Profile",
                    selectedIcon = Icons.Filled.Person,
                    unSelectedIcon = Icons.Outlined.Person,
                    hasNews = false
                )
            )
            var selectedItemIndexed by rememberSaveable {
                mutableStateOf(0)
            }
            ChatCornerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = index == selectedItemIndexed,
                                        onClick = {
                                            selectedItemIndexed = index
//                                            navController.navigate(item.title)
                                        },
                                        label = {
                                                Text(text = item.title)
                                        },
                                        icon = {
                                            BadgedBox(
                                                badge = {
                                                    if (item.badgeCount != null) {
                                                        Badge {
                                                            Text(text = item.badgeCount.toString())
                                                        }
                                                    }
                                                    else if (item.hasNews) {
                                                        Badge()
                                                    }
                                                }
                                            ) {
                                                Icon(
                                                    imageVector = if (index == selectedItemIndexed) {
                                                        item.selectedIcon
                                                    }
                                                    else item.unSelectedIcon,
                                                    contentDescription = item.title
                                                )
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    ) {

                    }
                }
            }
        }
    }
}