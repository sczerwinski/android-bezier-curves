package it.czerwinski.android.bezier

import android.graphics.PointF

/**
 * Constructs a relaxed cubic B-spline from control points.
 *
 * @param controlPoints The control points.
 *
 * @return A relaxed cubic B-spline.
 */
fun bSpline(controlPoints: List<PointF>): BezierPath {
	val vertices = controlPoints.mapIndexed {
		index, point -> when (index) {
			0, controlPoints.lastIndex -> point
			else -> (controlPoints[index - 1] + controlPoints[index + 1] + point * 4f) / 6f
		}
	}
	return bezier(vertices.first()) {
		(controlPoints zip controlPoints.drop(1)).forEachIndexed {
			index, (p1, p2) -> c(
				(p1 * 2f + p2) / 3f,
				(p1 + p2 * 2f) / 3f,
				vertices[index + 1])
		}
	}
}
