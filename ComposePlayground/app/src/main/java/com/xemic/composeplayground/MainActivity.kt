package com.xemic.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.xemic.composeplayground.common.navigateSingleTop
import com.xemic.composeplayground.ui.category.CategoryScreen
import com.xemic.composeplayground.ui.home.HomeScreen
import com.xemic.composeplayground.ui.mypage.MyPageScreen
import com.xemic.composeplayground.common.theme.ComposePlaygroundTheme
import com.xemic.composeplayground.ui.Destination
import com.xemic.composeplayground.ui.MyBottomNavigation
import com.xemic.composeplayground.ui.MyMainScreens
import com.xemic.composeplayground.ui.MyTopBar
import com.xemic.composeplayground.ui.home.HomeSections

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    ComposePlaygroundTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            MyMainScreens.find { it.route == currentDestination?.route } ?: Destination.Home

        var currentSection by rememberSaveable { mutableStateOf(HomeSections[0].route) }

        Scaffold(
            topBar = { MyTopBar(currentScreen) },
            bottomBar = {
                MyBottomNavigation(
                    allScreens = MyMainScreens,
                    onTabSelected = { screen ->
                        navController.navigateSingleTop(screen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Destination.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = Destination.Home.route) {
                    HomeScreen(
                        currentSection = HomeSections.find { it.route == currentSection } ?: HomeSections[0],
                        onSectionChanged = { section ->
                            currentSection = section.route
                        }
                    )
                }
                composable(route = Destination.Category.route) {
                    CategoryScreen()
                }
                composable(route = Destination.MyPage.route) {
                    MyPageScreen()
                }
            }
        }
    }
}