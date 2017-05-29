package it.czerwinski.android.bezier

import android.graphics.PointF

/**
 * A builder for paths consisting of multiple Bézier curves.
 */
class BezierPathBuilder(private var nextStart: PointF) {

	private val curves = mutableListOf<BezierCurve>()

	/**
	 * Adds linear Bézier curve.
	 *
	 * @param end Ending point of the curve.
	 */
	fun l(end: PointF) {
		curves.add(LinearCurve(nextStart, end))
		nextStart = end
	}

	/**
	 * Adds quadratic Bézier curve.
	 *
	 * @param middle Middle control point of the curve.
	 * @param end Ending point of the curve.
	 */
	fun q(middle: PointF, end: PointF) {
		curves.add(QuadCurve(nextStart, middle, end))
		nextStart = end
	}

	/**
	 * Adds cubic Bézier curve.
	 *
	 * @param p1 First control point of the curve.
	 * @param p2 Second control point of the curve.
	 * @param end Ending point of the curve.
	 */
	fun c(p1: PointF, p2: PointF, end: PointF) {
		curves.add(CubicCurve(nextStart, p1, p2, end))
		nextStart = end
	}

	internal fun build() =
			BezierPath(curves)
}
