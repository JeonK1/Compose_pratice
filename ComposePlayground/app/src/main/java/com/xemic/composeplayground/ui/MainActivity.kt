package com.xemic.composeplayground.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.xemic.composeplayground.common.ext.navigateSingleTop
import com.xemic.composeplayground.ui.mypage.MyPageScreen
import com.xemic.composeplayground.common.theme.ComposePlaygroundTheme
import com.xemic.composeplayground.ui.category.CategoryMainScreen
import com.xemic.composeplayground.ui.home.*
import com.xemic.composeplayground.ui.itemlist.ItemListScreen
import com.xemic.composeplayground.ui.login.LoginScreen
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.common.model.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppScreen()
        }
    }
}

@Composable
fun MainAppScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val homeScrollState = rememberLazyGridState()
    val homeUiState by produceState(initialValue = UiState<List<Section>>(isLoading = true)) {
        val itemListResult = viewModel.sectionList
        value = if(itemListResult is Result.Success) {
            UiState(data = itemListResult.data)
        } else {
            UiState(isError = true)
        }
    }

    var isLogin = rememberSaveable { false }

    ComposePlaygroundTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            BottomNavScreens.find { it.route == currentDestination?.route }
                ?: CommonNavScreens.find { it.route == currentDestination?.route }
                ?: BottomNavigateItem.Home

        var currentSectionIndex by rememberSaveable { mutableStateOf(0) }

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
                // Home 화면
                composable(route = BottomNavigateItem.Home.route) {
                    HomeMainScreen(
                        uiState = homeUiState,
                        scrollState = homeScrollState,
                        currentSectionIndex = currentSectionIndex,
                        onSectionChanged = { index ->
                            currentSectionIndex = index

                            // reset scrollState
                            coroutineScope.launch {
                                homeScrollState.scrollToItem(0)
                            }
                        }
                    )
                }

                // Category 화면
                composable(route = BottomNavigateItem.Category.route) {
                    CategoryMainScreen(
                        onCategoryClicked = { categoryNo ->
                            navController.navigateSingleTop(
                                CommonNavigateItem.CategoryList.makeRouteWithArgs(categoryNo)
                            )
                        }
                    )
                }

                // 마이페이지 화면
                composable(route = BottomNavigateItem.MyPage.route) {
                    if (isLogin) {
                        MyPageScreen()
                    } else {
                        navController.navigateSingleTop(CommonNavigateItem.Login.route)
                    }
                }

                // 로그인 화면
                composable(route = CommonNavigateItem.Login.route) {
                    LoginScreen(
                        onLoginSuccess = {
                            isLogin = true
                            navController.navigateSingleTop(BottomNavigateItem.MyPage.route)
                        }
                    )
                }

                // 아이템 리스트 화면
                composable(
                    route = CommonNavigateItem.CategoryList.route,
                    arguments = CommonNavigateItem.CategoryList.arguments
                ) {
                    it.arguments?.getInt(CommonNavigateItem.CategoryList.categoryNo)?.let { categoryNo ->
                        ItemListScreen(
                            categoryNo = categoryNo
                        )
                    }
                }
            }
        }
    }
}