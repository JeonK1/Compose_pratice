package com.xemic.composeplayground.ui.login

import androidx.compose.foundation.border
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.common.theme.Gray700
import com.xemic.composeplayground.common.theme.Gray900
import com.xemic.composeplayground.common.theme.White

@Composable
fun EditTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    hint: String,
    onValueChanged: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = { text -> onValueChanged(text) },
        placeholder = {
            HintText(
                text = hint,
                fontSize = 16.sp
            )
        },
        modifier = modifier
            .border(0.5.dp, Gray700, RectangleShape),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White
        )
    )
}

@Composable
fun HintText(
    text: String,
    fontSize: TextUnit,
) {
    Text(
        text = text,
        fontSize = fontSize,
        color = Gray900
    )
}