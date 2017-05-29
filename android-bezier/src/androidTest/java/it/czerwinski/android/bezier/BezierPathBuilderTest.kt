package it.czerwinski.android.bezier

import android.graphics.PointF
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BezierPathBuilderTest {

	@Test
	@Throws(Exception::class)
	fun shouldCreateLinearCurve() {
		// given:
		val p0 = PointF(1f, 2f)
		val p1 = PointF(3f, 4f)
		// when:
		val curve = bezier(p0) {
			l(p1)
		}
		// then:
		assertEquals(BezierPath(listOf(LinearCurve(p0, p1))), curve)
	}

	@Test
	@Throws(Exception::class)
	fun shouldCreateQuadraticCurve() {
		// given:
		val p0 = PointF(1f, 2f)
		val p1 = PointF(3f, 4f)
		val p2 = PointF(5f, 6f)
		// when:
		val curve = bezier(p0) {
			q(p1, p2)
		}
		// then:
		assertEquals(BezierPath(listOf(QuadCurve(p0, p1, p2))), curve)
	}

	@Test
	@Throws(Exception::class)
	fun shouldCreateCubicCurve() {
		// given:
		val p0 = PointF(1f, 2f)
		val p1 = PointF(3f, 4f)
		val p2 = PointF(5f, 6f)
		val p3 = PointF(5f, 6f)
		// when:
		val curve = bezier(p0) {
			c(p1, p2, p3)
		}
		// then:
		assertEquals(BezierPath(listOf(CubicCurve(p0, p1, p2, p3))), curve)
	}

	@Test
	@Throws(Exception::class)
	fun shouldCreateCombinedPath() {
		// given:
		val p = arrayOf(
				PointF(1f, 2f),
				PointF(3f, 4f),
				PointF(5f, 6f),
				PointF(7f, 8f),
				PointF(9f, 10f),
				PointF(11f, 12f),
				PointF(13f, 14f),
				PointF(15f, 16f),
				PointF(17f, 18f),
				PointF(19f, 20f))
		// when:
		val curve = bezier(p[0]) {
			c(p[1], p[2], p[3])
			l(p[4])
			q(p[5], p[6])
			c(p[7], p[8], p[9])
		}
		// then:
		val expectedCurves = listOf(
				CubicCurve(p[0], p[1], p[2], p[3]),
				LinearCurve(p[3], p[4]),
				QuadCurve(p[4], p[5], p[6]),
				CubicCurve(p[6], p[7], p[8], p[9]))
		assertEquals(BezierPath(expectedCurves), curve)
	}
}
