package it.czerwinski.android.bezier

import android.graphics.PointF

internal operator fun PointF.plus(other: PointF): PointF =
		PointF(x + other.x, y + other.y)

internal operator fun PointF.times(value: Float): PointF =
		PointF(x * value, y * value)

internal operator fun PointF.div(value: Float): PointF =
		PointF(x / value, y / value)
