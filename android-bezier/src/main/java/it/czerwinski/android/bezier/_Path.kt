package it.czerwinski.android.bezier

import android.graphics.Path
import android.graphics.PointF

/**
 * Appends Bézier curve to the Android path.
 *
 * @param bezierCurve The Bézier curve.
 *
 * @return Path with appended Bézier curve.
 */
operator fun Path.plus(bezierCurve: BezierCurve) =
		bezierCurve.appendToPath(this)

/**
 * Creates an Android path starting from the given point.
 *
 * @param start The starting point of the path.
 *
 * @return The Android path.
 */
fun pathFrom(start: PointF): Path {
	val path = Path()
	path.moveTo(start.x, start.y)
	return path
}