package com.xemic.composeplayground.common.ext

import java.text.DecimalFormat

fun Int.toStringDecimalFormat() = DecimalFormat("#,###").format(this)