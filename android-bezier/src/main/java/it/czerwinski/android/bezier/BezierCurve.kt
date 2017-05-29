package it.czerwinski.android.bezier

import android.graphics.Path
import android.graphics.PointF

/**
 * Bézier curve.
 */
sealed class BezierCurve() {

	/**
	 * Starting point of the curve.
	 */
	abstract val start: PointF

	/**
	 * Ending point of the curve.
	 */
	abstract val end: PointF

	/**
	 * Converts the curve to Android path.
	 *
	 * @return The Android path.
	 */
	fun toPath(): Path {
		val path = Path()
		path.moveTo(start.x, start.y)
		return appendToPath(path)
	}

	internal abstract fun appendToPath(path : Path): Path
}

/**
 * Linear Bézier curve.
 *
 * @property start Starting point of the curve.
 * @property end Ending point of the curve.
 */
data class LinearCurve(
		override val start: PointF,
		override val end: PointF) : BezierCurve() {

	override fun appendToPath(path: Path): Path {
		path.lineTo(end.x, end.y)
		return path
	}
}

/**
 * Quadratic Bézier curve.
 *
 * @property start Starting point of the curve.
 * @property middle Middle control point of the curve.
 * @property end Ending point of the curve.
 */
data class QuadCurve(
		override val start: PointF,
		val middle: PointF,
		override val end: PointF) : BezierCurve() {

	override fun appendToPath(path: Path): Path {
		path.quadTo(middle.x, middle.y, end.x, end.y)
		return path
	}
}

/**
 * Cubic Bézier curve.
 *
 * @property start Starting point of the curve.
 * @property p1 First control point of the curve.
 * @property p2 Second control point of the curve.
 * @property end Ending point of the curve.
 */
data class CubicCurve(
		override val start: PointF,
		val p1: PointF,
		val p2: PointF,
		override val end: PointF) : BezierCurve() {

	override fun appendToPath(path: Path): Path {
		path.cubicTo(p1.x, p1.y, p2.x, p2.y, end.x, end.y)
		return path
	}
}
