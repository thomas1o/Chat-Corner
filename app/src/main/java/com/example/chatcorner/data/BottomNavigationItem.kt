package com.example.chatcorner.data

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem (

    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null

)