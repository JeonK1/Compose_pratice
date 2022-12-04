package com.xemic.composeplayground.ui.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val IconPack.Home: ImageVector
    get() {
        if (_Home != null) {
            return _Home!!
        }
        _Home = Builder(name = "Home", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(21.0f, 13.0f)
                verticalLineToRelative(10.0f)
                horizontalLineToRelative(-6.0f)
                verticalLineToRelative(-6.0f)
                horizontalLineToRelative(-6.0f)
                verticalLineToRelative(6.0f)
                horizontalLineToRelative(-6.0f)
                verticalLineToRelative(-10.0f)
                horizontalLineToRelative(-3.0f)
                lineToRelative(12.0f, -12.0f)
                lineToRelative(12.0f, 12.0f)
                horizontalLineToRelative(-3.0f)
                close()
                moveTo(20.0f, 7.093f)
                verticalLineToRelative(-5.093f)
                horizontalLineToRelative(-3.0f)
                verticalLineToRelative(2.093f)
                lineToRelative(3.0f, 3.0f)
                close()
            }
        }
        .build()
        return _Home!!
    }

private var _Home: ImageVector? = null
