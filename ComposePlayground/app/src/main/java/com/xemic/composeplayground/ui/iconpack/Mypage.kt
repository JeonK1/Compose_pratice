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

public val IconPack.MyPage: ImageVector
    get() {
        if (_MyPage != null) {
            return _MyPage!!
        }
        _MyPage = Builder(name = "MyPage", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(19.0f, 7.001f)
                curveToRelative(0.0f, 3.865f, -3.134f, 7.0f, -7.0f, 7.0f)
                reflectiveCurveToRelative(-7.0f, -3.135f, -7.0f, -7.0f)
                curveToRelative(0.0f, -3.867f, 3.134f, -7.001f, 7.0f, -7.001f)
                reflectiveCurveToRelative(7.0f, 3.134f, 7.0f, 7.001f)
                close()
                moveTo(17.402f, 14.181f)
                curveToRelative(-1.506f, 1.137f, -3.374f, 1.82f, -5.402f, 1.82f)
                curveToRelative(-2.03f, 0.0f, -3.899f, -0.685f, -5.407f, -1.822f)
                curveToRelative(-4.072f, 1.793f, -6.593f, 7.376f, -6.593f, 9.821f)
                horizontalLineToRelative(24.0f)
                curveToRelative(0.0f, -2.423f, -2.6f, -8.006f, -6.598f, -9.819f)
                close()
            }
        }
        .build()
        return _MyPage!!
    }

private var _MyPage: ImageVector? = null
