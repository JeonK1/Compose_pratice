package com.xemic.composeplayground.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    currentSection: Section,
    onSectionChanged: (Section) -> Unit
) {
    Column {
        TopSectionBar(
            allSections = HomeSections,
            onTabSelected = { section ->
                onSectionChanged(section)
            },
            currentScreen = currentSection
        )

        SectionScreen(
            modifier = modifier,
            currentSection = currentSection
        )
    }
}

@Composable
fun TopSectionBar(
    modifier: Modifier = Modifier,
    allSections: List<Section>,
    onTabSelected: (Section) -> Unit,
    currentScreen: Section
) {
    LazyRow(modifier) {
        allSections.forEach { section ->
            item {
                TopBarItem(
                    text = section.route,
                    selected = section == currentScreen
                ) {
                    onTabSelected(section)
                }
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
    Text(
        modifier = modifier
            .padding(16.dp)
            .wrapContentHeight()
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.Tab
            ),
        text = text,
        color = if(selected) Color.Black else Color.LightGray
    )
}

@Preview(showBackground = true)
@Composable
fun TopSectionBarPreview() {
    TopSectionBar(
        allSections = HomeSections,
        onTabSelected = { },
        currentScreen = HomeSections[0]
    )
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