package com.xemic.composeplayground.common.ext

import androidx.navigation.NavController

fun NavController.navigateSingleTop(route: String) {
    navigate(route) {
        restoreState = true
        launchSingleTop = true
    }
}