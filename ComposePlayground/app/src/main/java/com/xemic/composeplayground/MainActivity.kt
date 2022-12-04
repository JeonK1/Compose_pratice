package com.xemic.composeplayground

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.xemic.composeplayground.common.navigateSingleTop
import com.xemic.composeplayground.ui.category.CategoryScreen
import com.xemic.composeplayground.ui.mypage.MyPageScreen
import com.xemic.composeplayground.common.theme.ComposePlaygroundTheme
import com.xemic.composeplayground.data.CategoryListSample
import com.xemic.composeplayground.data.ItemInfoListSample
import com.xemic.composeplayground.ui.*
import com.xemic.composeplayground.ui.home.*
import com.xemic.composeplayground.ui.itemlist.ItemListScreen
import com.xemic.composeplayground.ui.login.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlin.text.Typography.section

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
    val homeUiState by produceState(initialValue = HomeViewModel.UiState(isLoading = true)) {
        val itemListResult = viewModel.sectionList
        value = if(itemListResult is HomeViewModel.Result.Success) {
            HomeViewModel.UiState(sectionList = itemListResult.data)
        } else {
            HomeViewModel.UiState(isError = true)
        }
    }

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
                        currentSectionIndex = currentSectionIndex,
                        onSectionChanged = { index ->
                            currentSectionIndex = index
                        },
                    )
                }

                // Category 화면
                composable(route = BottomNavigateItem.Category.route) {
                    CategoryScreen(
                        onCategoryClicked = { categoryIndex ->
                            navController.navigateSingleTop(
                                CommonNavigateItem.CategoryList.makeRouteWithArgs(CategoryListSample[categoryIndex])
                            )
                        }
                    )
                }

                // 마이페이지 화면
                composable(route = BottomNavigateItem.MyPage.route) {
                    MyPageScreen(
                        navigateToLoginScreen = { navController.navigateSingleTop(CommonNavigateItem.Login.route) }
                    )
                }

                // 로그인 화면
                composable(route = CommonNavigateItem.Login.route) {
                    LoginScreen()
                }

                // 아이템 리스트 화면
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