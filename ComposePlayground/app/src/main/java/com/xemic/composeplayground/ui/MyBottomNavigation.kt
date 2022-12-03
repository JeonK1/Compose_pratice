package com.xemic.composeplayground.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.xemic.composeplayground.ui.mypage.MyPageScreen

@Composable
fun MyBottomNavigation(
    modifier: Modifier = Modifier,
    allScreens: List<Destination>,
    onTabSelected: (Destination) -> Unit,
    currentScreen: Destination
) {
    BottomNavigation(
        modifier = modifier
    ) {
        allScreens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.route
                    )
                },
                selected = screen == currentScreen,
                onClick = { onTabSelected(screen) }
            )
        }
    }
}

sealed interface Destination {
    val icon: ImageVector
    val route: String
    val name: String

    object Home: Destination {
        override val icon = Icons.Default.Call
        override val route = "home"
        override val name = "Jasa Mall"
    }

    object Category: Destination {
        override val icon = Icons.Default.Call
        override val route = "category"
        override val name = "브랜드 카테고리"
    }

    object MyPage: Destination {
        override val icon = Icons.Default.Call
        override val route = "my_page"
        override val name = "내 정보"
    }
}

val MyMainScreens = listOf(
    Destination.Home,
    Destination.Category,
    Destination.MyPage
)
