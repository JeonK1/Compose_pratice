package com.xemic.composeplayground.ui.category

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.xemic.composeplayground.common.theme.Gray1000
import com.xemic.composeplayground.common.theme.Gray400
import com.xemic.composeplayground.data.model.Category

@Composable
fun CategorySuccess(
    modifier: Modifier = Modifier,
    categoryList: List<Category>,
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
    modifier: Modifier = Modifier,
    categoryList: List<Category>, onItemClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        items(categoryList.size) { index ->
            Column {
                CategoryListItem(
                    category = categoryList[index],
                    onClick = {
                        onItemClick(categoryList[index].categoryNo)
                    }
                )
                if (index < ((categoryList.size - 1) / 2) * 2) {
                    Divider(
                        color = Gray1000,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryListItem(
    modifier: Modifier = Modifier,
    category: Category,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick() }
    ) {
        Row {
            SubcomposeAsyncImage(
                model = category.categoryIconUrl,
                contentDescription = category.categoryName,
                modifier = modifier
                    .size(44.dp, 44.dp)
                    .padding(4.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit,
            )
            Text(
                modifier = modifier.padding(top = 12.dp, bottom = 12.dp, start = 4.dp),
                text = category.categoryName,
                fontSize = 14.sp,
                color = Gray400
            )
        }
    }
}