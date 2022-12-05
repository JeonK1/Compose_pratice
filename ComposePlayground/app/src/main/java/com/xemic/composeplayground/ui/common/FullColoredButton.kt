package com.xemic.composeplayground.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.common.theme.Blue500
import com.xemic.composeplayground.common.theme.White

@Composable
fun FullColoredButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    borderColor: Color,
    fontColor: Color,
    text: String,
    fontSize: TextUnit,
    onClick: () -> Unit
) {
    TextButton(
        onClick = { onClick() },
        modifier = modifier
            .border(1.dp, borderColor, RectangleShape)
            .background(backgroundColor)
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            color = fontColor,
            fontWeight = FontWeight.Bold
        )
    }

}

@Preview(showBackground = true)
@Composable
fun FullColoredButtonPreview() {
    FullColoredButton(
        backgroundColor = Blue500,
        borderColor = White,
        fontColor = White,
        text = "로그인",
        fontSize = 16.sp,
        onClick = { }
    )
}
