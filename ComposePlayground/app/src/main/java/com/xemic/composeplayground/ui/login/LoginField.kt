package com.xemic.composeplayground.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginField(
    modifier: Modifier = Modifier,
    id: String,
    pw: String,
    onIdChanged: (String) -> Unit,
    onPwChanged: (String) -> Unit
) {
    Column(modifier) {
        EditTextField(
            modifier = modifier,
            value = id,
            hint = "아이디",
            onValueChanged = { text -> onIdChanged(text) }
        )
        Spacer(modifier = Modifier.height(4.dp))
        EditTextField(
            modifier = modifier,
            value = pw,
            hint = "비밀번호",
            onValueChanged = { text -> onPwChanged(text) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFieldPreview() {
    LoginField(
        id = "",
        pw = "",
        onPwChanged = {},
        onIdChanged = {},
    )
}