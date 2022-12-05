package com.xemic.composeplayground.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.xemic.composeplayground.common.theme.Purple
import com.xemic.composeplayground.common.theme.White
import com.xemic.composeplayground.ui.iconpack.Category
import com.xemic.composeplayground.ui.iconpack.Home
import com.xemic.composeplayground.ui.iconpack.IconPack
import com.xemic.composeplayground.ui.iconpack.MyPage

@Composable
fun MyBottomNavigation(
    modifier: Modifier = Modifier,
    allScreens: List<BottomNavigateItem>,
    onTabSelected: (BottomNavigateItem) -> Unit,
    currentScreen: CommonNavigateItem
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Purple,
        contentColor = White
    ) {
        allScreens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.route
                    )
                },
                selected = screen.bottomNavRoute == currentScreen.bottomNavRoute,
                onClick = { onTabSelected(screen) }
            )
        }
    }
}

sealed interface CommonNavigateItem {
    val route: String
    val bottomNavRoute: String
    var appBarName: String

    object Login: CommonNavigateItem {
        override val route = "login"
        override val bottomNavRoute = BottomNavigateItem.MyPage.route
        override var appBarName = "로그인"
    }

    object CategoryList: CommonNavigateItem {
        const val baseRoute = "category_list"
        const val categoryNo = "category_no"

        override val route = "$baseRoute/{$categoryNo}"
        override val bottomNavRoute = BottomNavigateItem.Category.route
        override var appBarName = "카테고리별 정보"
        val arguments = listOf(
            navArgument(categoryNo) { type = NavType.IntType }
        )

        fun makeRouteWithArgs(categoryNo: Int): String {
            return "$baseRoute/$categoryNo"
        }
    }
}

sealed interface BottomNavigateItem: CommonNavigateItem {
    override val route: String
    override var appBarName: String
    val icon: ImageVector

    object Home: BottomNavigateItem {
        override val route = "home"
        override val bottomNavRoute = route
        override var appBarName = "Jasa Mall"
        override val icon = IconPack.Home
    }

    object Category: BottomNavigateItem {
        override val route = "category"
        override val bottomNavRoute = route
        override var appBarName = "브랜드 카테고리"
        override val icon = IconPack.Category
    }

    object MyPage: BottomNavigateItem {
        override val route = "my_page"
        override val bottomNavRoute = route
        override var appBarName = "내 정보"
        override val icon = IconPack.MyPage
    }
}

val BottomNavScreens = listOf(
    BottomNavigateItem.Home,
    BottomNavigateItem.Category,
    BottomNavigateItem.MyPage
)

val CommonNavScreens = listOf(
    CommonNavigateItem.CategoryList,
    CommonNavigateItem.Login
)
