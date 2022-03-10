package geometries;

import primitives.*;

/**
 * Triangle class represents a polygon with three points
 *
 */
public class Triangle extends Polygon{

    /**
     * Constructor to initialize Triangle based on Polygon with 3 points
     *
     * @param p1 first point value
     * @param p2 second point value
     * @param p3 third point value
     */
    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }
}
