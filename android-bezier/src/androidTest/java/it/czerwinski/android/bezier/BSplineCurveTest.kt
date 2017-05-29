package it.czerwinski.android.bezier

import android.graphics.PointF
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BSplineCurveTest {

	@Test
	@Throws(Exception::class)
	fun shouldCreateRelaxedCubicBSpline() {
		// given:
		val controlPoints = listOf(
				PointF(-3f, -3f),
				PointF(-3f, 0f),
				PointF(0f, 3f),
				PointF(3f, 3f),
				PointF(3f, -3f))
		// when:
		val result = bSpline(controlPoints)
		// then:
		val expectedPoints = listOf(
				PointF(-3f, -3f),
				PointF(-3f, -2f),
				PointF(-3f, -1f),
				PointF(-2.5f, 0f),
				PointF(-2f, 1f),
				PointF(-1f, 2f),
				PointF(0f, 2.5f),
				PointF(1f, 3f),
				PointF(2f, 3f),
				PointF(2.5f, 2f),
				PointF(3f, 1f),
				PointF(3f, -1f),
				PointF(3f, -3f))
		val expectedCurves = listOf(
				CubicCurve(expectedPoints[0], expectedPoints[1], expectedPoints[2], expectedPoints[3]),
				CubicCurve(expectedPoints[3], expectedPoints[4], expectedPoints[5], expectedPoints[6]),
				CubicCurve(expectedPoints[6], expectedPoints[7], expectedPoints[8], expectedPoints[9]),
				CubicCurve(expectedPoints[9], expectedPoints[10], expectedPoints[11], expectedPoints[12]))
		assertEquals(BezierPath(expectedCurves), result)
	}
}