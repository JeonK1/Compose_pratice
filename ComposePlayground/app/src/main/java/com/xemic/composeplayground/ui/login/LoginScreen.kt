package com.xemic.composeplayground.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    Column {
        TextField(
            value = "",
            onValueChange = { },
            placeholder = { Text("id 입력") }
        )
        TextField(
            value = "",
            onValueChange = { },
            placeholder = { Text("pw 입력") }
        )
        Text(text = "로그인")
        Row {
            Text("아이디 찾기")
            Text(" | ")
            Text("비밀번호 찾기")
            Text(" | ")
            Text("회원가입")
        }
        Text(text = "카카오톡 로그인")
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
