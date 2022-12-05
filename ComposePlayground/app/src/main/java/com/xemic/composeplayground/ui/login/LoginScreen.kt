package com.xemic.composeplayground.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.common.theme.*
import com.xemic.composeplayground.ui.common.FullColoredButton

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    var id by rememberSaveable { mutableStateOf("") }
    var pw by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LoginField(
            modifier = modifier.fillMaxWidth(),
            id = id,
            pw = pw,
            onIdChanged = { id = it },
            onPwChanged = { pw = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        FullColoredButton(
            modifier = modifier
                .fillMaxWidth(),
            backgroundColor = Purple,
            borderColor = Transparent,
            fontColor = White,
            text = "로그인",
            fontSize = 16.sp,
            onClick = {
                // Todo : 로그인 로직
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        FullColoredButton(
            modifier = modifier
                .fillMaxWidth(),
            backgroundColor = White,
            borderColor = Purple,
            fontColor = Purple,
            text = "회원가입",
            fontSize = 16.sp,
            onClick = {
                // Todo : 회원가입 로직
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = modifier.align(Alignment.Center)
            ) {
                Text(
                    text = "아이디 찾기",
                    fontSize = 11.sp,
                    color = Gray700,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.clickable {
                        // Todo : 아이디 찾기 로직
                    }
                )
                Text(
                    text = "  |  ",
                    fontSize = 11.sp,
                    color = Gray700,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "비밀번호 찾기",
                    fontSize = 11.sp,
                    color = Gray700,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.clickable {
                        // Todo : 비밀번호 찾기 로직
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}