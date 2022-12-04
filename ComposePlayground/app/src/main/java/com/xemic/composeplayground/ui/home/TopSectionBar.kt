package com.xemic.composeplayground.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xemic.composeplayground.common.theme.Gray700

@Composable
fun TopSectionBar(
    modifier: Modifier = Modifier,
    allSections: List<Section>,
    onTabSelected: (Int) -> Unit,
    currentScreen: Section
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp
        )
    ) {
        items(allSections.size) { index ->
            TopBarItem(
                text = allSections[index].route,
                selected = allSections[index] == currentScreen
            ) {
                onTabSelected(index)
            }
        }
    }
}

@Composable
fun TopBarItem(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(Modifier.width(IntrinsicSize.Max)) {
        Text(
            modifier = modifier
                .wrapContentHeight()
                .padding(vertical = 8.dp)
                .selectable(
                    selected = selected,
                    onClick = onClick,
                    role = Role.Tab
                ),
            text = text,
            color = if (selected) Color.Black else Color.LightGray
        )
        if (selected) {
            Divider(
                modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(Gray700)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarItemPreview() {
    TopBarItem(
        text = "섹션 이름",
        selected = true,
        onClick = { }
    )
}