package it.czerwinski.android.bezier

import android.graphics.PointF

/**
 * Builds a path consisting of multiple Bézier curves.
 *
 * @param start Starting point of the path.
 * @param init Builder initializing function.
 *
 * @return A path consisting of Bézier curves.
 */
fun bezier(start: PointF, init: BezierPathBuilder.() -> Unit): BezierPath {
	val builder = BezierPathBuilder(start)
	builder.init()
	return builder.build()
}
