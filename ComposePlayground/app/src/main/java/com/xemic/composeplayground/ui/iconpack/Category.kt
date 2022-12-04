package com.xemic.composeplayground.ui.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Round
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val IconPack.Category: ImageVector
    get() {
        if (_Category != null) {
            return _Category!!
        }
        _Category = Builder(name = "Category", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Round, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveToRelative(20.998f, 8.498f)
                horizontalLineToRelative(-17.996f)
                curveToRelative(-0.569f, 0.0f, -1.001f, 0.464f, -1.001f, 0.999f)
                curveToRelative(0.0f, 0.118f, -0.105f, -0.582f, 1.694f, 10.659f)
                curveToRelative(0.077f, 0.486f, 0.496f, 0.842f, 0.988f, 0.842f)
                horizontalLineToRelative(14.635f)
                curveToRelative(0.492f, 0.0f, 0.911f, -0.356f, 0.988f, -0.842f)
                curveToRelative(1.801f, -11.25f, 1.693f, -10.54f, 1.693f, -10.66f)
                curveToRelative(0.0f, -0.558f, -0.456f, -0.998f, -1.001f, -0.998f)
                close()
                moveTo(20.034f, 5.481f)
                horizontalLineToRelative(-16.03f)
                curveToRelative(-0.524f, 0.0f, -1.001f, 0.422f, -1.001f, 1.007f)
                curveToRelative(0.0f, 0.081f, -0.01f, 0.016f, 0.14f, 1.01f)
                horizontalLineToRelative(17.752f)
                curveToRelative(0.152f, -1.012f, 0.139f, -0.931f, 0.139f, -1.009f)
                curveToRelative(0.0f, -0.58f, -0.469f, -1.008f, -1.0f, -1.008f)
                close()
                moveTo(4.061f, 4.481f)
                horizontalLineToRelative(15.916f)
                curveToRelative(0.058f, -0.436f, 0.055f, -0.426f, 0.055f, -0.482f)
                curveToRelative(0.0f, -0.671f, -0.575f, -1.001f, -1.001f, -1.001f)
                horizontalLineToRelative(-14.024f)
                curveToRelative(-0.536f, 0.0f, -1.001f, 0.433f, -1.001f, 1.0f)
                curveToRelative(0.0f, 0.056f, -0.004f, 0.043f, 0.055f, 0.483f)
                close()
            }
        }
        .build()
        return _Category!!
    }

private var _Category: ImageVector? = null
