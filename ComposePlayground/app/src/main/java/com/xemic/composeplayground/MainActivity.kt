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
import com.xemic.composeplayground.data.CategoryListSample
import com.xemic.composeplayground.data.ItemInfoListSample
import com.xemic.composeplayground.ui.*
import com.xemic.composeplayground.ui.home.HomeSections
import com.xemic.composeplayground.ui.itemlist.ItemListScreen

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
            BottomNavScreens.find { it.route == currentDestination?.route }
                ?: CommonNavScreens.find { it.route == currentDestination?.route }
                ?: BottomNavigateItem.Home

        var currentSection by rememberSaveable { mutableStateOf(HomeSections[0].route) }

        Scaffold(
            topBar = { MyTopBar(currentScreen) },
            bottomBar = {
                MyBottomNavigation(
                    allScreens = BottomNavScreens,
                    onTabSelected = { screen ->
                        navController.navigateSingleTop(screen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = BottomNavigateItem.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = BottomNavigateItem.Home.route) {
                    HomeScreen(
                        currentSection = HomeSections.find { it.route == currentSection } ?: HomeSections[0],
                        onSectionChanged = { section ->
                            currentSection = section.route
                        }
                    )
                }

                composable(route = BottomNavigateItem.Category.route) {
                    CategoryScreen(
                        onCategoryClicked = { categoryIndex ->
                            navController.navigateSingleTop(
                                CommonNavigateItem.CategoryList.makeRouteWithArgs(CategoryListSample[categoryIndex])
                            )
                        }
                    )
                }

                composable(route = BottomNavigateItem.MyPage.route) {
                    MyPageScreen()
                }

                composable(
                    route = CommonNavigateItem.CategoryList.route,
                    arguments = CommonNavigateItem.CategoryList.arguments
                ) {
                    it.arguments?.getString(CommonNavigateItem.CategoryList.categoryName)?.let { categoryName ->
                        ItemListScreen(
                            data = ItemInfoListSample.filter { itemInfo -> itemInfo.brandName == categoryName }
                        )
                    }
                }
            }
        }
    }
}