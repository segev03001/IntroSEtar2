package Primitives;

import org.junit.jupiter.api.Test;

import static Primitives.Util.isZero;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for primitives.Vector class
 * @author segev and shilo
 */
class VectorTest {

    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(-2, -4, -6);
    Vector v3 = new Vector(0, 3, -2);
    Vector v = new Vector(1, 2, 3);

    @Test
    void testZeroPoint(){
        try { // test zero vector
            new Vector(0, 0, 0);
            fail("ERROR: zero vector does not throw an exception");
        } catch (Exception e) {
            out.println("good: zero vector cannot exist");
        }

    }
    @Test
    void add() {
        Vector addv = v1.add(v2);
        Vector resultV = new Vector(-1, -2, -3);
        assertEquals(addv, resultV, "ERROR: add() wrong value");

    }

    @Test
    void subtract() {
        Vector subV = v1.subtract(v2);
        Vector resultV = new Vector(3, 6, 9);
        assertEquals(subV, resultV, "ERROR: subtract() wrong value");
    }

    /**
     * Test method for scale.
     */
    @Test
    void scale() {
        Vector vscale = v1.scale(-1);
        assertEquals(v1.length(),vscale.length(),0.0001);
    }

    @Test
    void dotProduct() {
        if (!isZero(v1.dotProduct(v3)))
            fail("ERROR: dotProduct() for orthogonal vectors is not zero");
        if (!isZero(v1.dotProduct(v2) + 28))
            fail("ERROR: dotProduct() wrong value");
    }

    /**
     * Test method for crossProduct
     * {@link Primitives.Vector#crossProduct(Primitives.Vector)}.
     */
    @Test
    void crossProduct() {
            // ============ Equivalence Partitions Tests ==============
            Vector v3 = new Vector(0, 3, -2);
            Vector vr = v1.crossProduct(v3);

            // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
            assertEquals(v1.length() * v3.length(), vr.length(), 0.00001,"crossProduct() wrong result length");

            // Test cross-product result orthogonality to its operands
            assertTrue(isZero(vr.dotProduct(v1)), "crossProduct() result is not orthogonal to 1st operand");
            assertTrue(isZero(vr.dotProduct(v3)), "crossProduct() result is not orthogonal to 2nd operand");

            // =============== Boundary Values Tests ==================
            // test zero vector from cross-productof co-lined vectors
            try {
                v1.crossProduct(v2);
                fail("crossProduct() for parallel vectors does not throw an exception");
            } catch (Exception e) {}
        }


        @Test
    void lengthSquared() {
            if (!isZero(v1.lengthSquared() - 14))
               fail("ERROR: lengthSquared() wrong value");
    }

    @Test
    void length() {
            double result = new Vector(0, 3, 4).length();
            assertTrue(isZero(result -5), ("ERROR: length() wrong value") );

    }

    @Test
    void normalize() {
        Vector vCopy = new Vector(v.getHead());
        Vector vCopyNormalize = vCopy.normalize();
        if (vCopy != vCopyNormalize)
            fail("ERROR: normalize() function creates a new vector");
        if (!isZero(vCopyNormalize.length() - 1))
            fail("ERROR: normalize() result is not a unit vector");
    }

    @Test
    void normalized() {
        Vector u = v.normalized();
        if (u == v)
            fail("ERROR: normalized() function does not create a new vector");
    }
}