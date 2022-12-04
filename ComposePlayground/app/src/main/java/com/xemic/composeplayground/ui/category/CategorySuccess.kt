package com.xemic.composeplayground.ui.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun CategorySuccess(
    modifier: Modifier = Modifier(),
    categoryList: List<String>,
    onItemClick: (Int) -> Unit
) {
    CategoryList(
        modifier = modifier,
        categoryList = categoryList,
        onItemClick = onItemClick
    )
}

@Composable
fun CategoryList(
    modifier: Modifier = Modifier(),
    categoryList: List<String>, onItemClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categoryList.size) { index ->
            CategoryListItem(
                categoryName = categoryList[index],
                onClick = {
                    onItemClick(index)
                }
            )
        }
    }
}