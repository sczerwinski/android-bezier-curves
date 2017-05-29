package it.czerwinski.android.bezier

import android.graphics.Path

/**
 * A path consisting of multiple Bézier curves.
 */
data class BezierPath(val curves: List<BezierCurve>) {

	/**
	 * Starting point of the path.
	 */
	val start by lazy { curves.first().start }

	/**
	 * Ending point of the path.
	 */
	val end by lazy { curves.last().end }

	/**
	 * Converts the Bézier curves to Android path.
	 *
	 * @return The Android path.
	 */
	fun toPath(): Path =
			curves.fold(pathFrom(start)) {
				path, curve -> path + curve
			}
}
