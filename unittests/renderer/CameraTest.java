package renderer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import renderer.Camera;
import primitives.*;

/**
 * Testing Camera Class
 *
 */
class CameraTest {
    static final Point ZERO_POINT = new Point(0.0, 0.0, 0.0);

    /**
     * Test method for
     * {@link renderer.Camera#constructRay(int, int, int, int)}.
     */
    @Test
    void testConstructRay() {
        Camera camera = new Camera(ZERO_POINT, new Vector(0.0, 0.0, -1.0), new Vector(0.0, -1.0, 0.0)).setVPDistance(10);
        String badRay = "Bad ray";

        // ============ Equivalence Partitions Tests ==============
        // EP01: 4X4 Inside (1,1)
        Ray tyu = camera.setVPSize(8, 8).constructRay(4, 4, 1, 1);
        assertEquals(new Ray(ZERO_POINT, new Vector(1.0, -1.0, -10.0)),
                camera.setVPSize(8, 8).constructRay(4, 4, 1, 1), badRay);

        // =============== Boundary Values Tests ==================
        // BV01: 3X3 Center (1,1)
        assertEquals(new Ray(ZERO_POINT, new Vector(0.0, 0.0, -10.0)),
                camera.setVPSize(6, 6).constructRay(3, 3, 1, 1), badRay);

        // BV02: 3X3 Center of Upper Side (0,1)
        assertEquals(new Ray(ZERO_POINT, new Vector(0.0, -2.0, -10.0)),
                camera.setVPSize(6, 6).constructRay(3, 3, 1, 0), badRay);

        // BV03: 3X3 Center of Left Side (1,0)
        assertEquals(new Ray(ZERO_POINT, new Vector(2.0, 0.0, -10.0)),
                camera.setVPSize(6, 6).constructRay(3, 3, 0, 1), badRay);

        // BV04: 3X3 Corner (0,0)
        assertEquals(new Ray(ZERO_POINT, new Vector(2.0, -2.0, -10.0)),
                camera.setVPSize(6, 6).constructRay(3, 3, 0, 0), badRay);

        // BV05: 4X4 Corner (0,0)
        assertEquals(new Ray(ZERO_POINT, new Vector(3.0, -3.0, -10.0)),
                camera.setVPSize(8, 8).constructRay(4, 4, 0, 0), badRay);

        // BV06: 4X4 Side (0,1)
        assertEquals(new Ray(ZERO_POINT, new Vector(1.0, -3.0, -10.0)),
                camera.setVPSize(8, 8).constructRay(4, 4, 1, 0), badRay);

    }
}
