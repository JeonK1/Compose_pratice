package com.xemic.composeplayground.ui.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xemic.composeplayground.data.CategoryListSample

@Composable
fun CategoryScreen(onCategoryClicked: (Int) -> Unit) {
    CategoryList(
        categoryList = CategoryListSample,
        onItemClick = { categoryIndex ->
            onCategoryClicked(categoryIndex)
        }
    )
}

@Composable
fun CategoryList(categoryList: List<String>, onItemClick: (Int) -> Unit) {
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

@Composable
fun CategoryListItem(categoryName: String, onClick: () -> Unit) {
    ClickableText(
        text = AnnotatedString(categoryName),
        onClick = { onClick() }
    )
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    CategoryScreen(onCategoryClicked = { })
}