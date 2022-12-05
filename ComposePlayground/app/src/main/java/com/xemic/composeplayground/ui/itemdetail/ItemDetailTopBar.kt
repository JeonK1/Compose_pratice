package com.xemic.composeplayground.ui.itemdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xemic.composeplayground.common.theme.Black
import com.xemic.composeplayground.common.theme.White

@Composable
fun ItemDetailTopBar(
    modifier: Modifier = Modifier,
    onClickBackBtn: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
    ) {
        IconButton(
            onClick = { onClickBackBtn() },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "뒤로가기",
                tint = Black,
                modifier = Modifier
                    .size(36.dp, 36.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailTopBarPreview() {
    ItemDetailTopBar(
        onClickBackBtn = { }
    )
}