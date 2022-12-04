package com.xemic.composeplayground.ui.iconpack

import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.collections.List as ____KtList

public object IconPack

private var __MyIcons: ____KtList<ImageVector>? = null

public val IconPack.MyIcons: ____KtList<ImageVector>
  get() {
    if (__MyIcons != null) {
      return __MyIcons!!
    }
    __MyIcons= listOf(Category, Home, MyPage)
    return __MyIcons!!
  }
