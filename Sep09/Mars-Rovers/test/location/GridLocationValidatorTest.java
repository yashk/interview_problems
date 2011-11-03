/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package location;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author 186946
 */
public class GridLocationValidatorTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // Smoke Tests
    @Test
    public void testValideMaxLocation() {
        new GridLocationValidator("10 10");
    }

    @Test
    public void testValideGridLocation() {
        GridLocationValidator validator = new GridLocationValidator("10 10");
        validator.assertValideLocation(5, 8);
    }

    public void testValideGridLocationString() {
        GridLocationValidator validator = new GridLocationValidator("10 10");
        validator.assertValideLocation("2", "5");
    }

    // Test location > maxlocation
    @Test(expected = IllegalArgumentException.class)
    public void testGreatertThanMaxLocation() {
        GridLocationValidator validator = new GridLocationValidator("10 10");
        validator.assertValideLocation(11, 12);
    }

    // Boundary value tests
    public void testBoundaryMaxLocation() {
        new GridLocationValidator("0 0");
    }

    public void testBoundaryMaxLocation1() {
        new GridLocationValidator(Integer.MAX_VALUE + " " + Integer.MAX_VALUE);
    }

    @Test
    public void testBoundaryValideGridLocation() {
        GridLocationValidator validator = new GridLocationValidator("10 10");
        validator.assertValideLocation(10, 10);
    }

    @Test
    public void testBoundaryValideGridLocation1() {
        GridLocationValidator validator = new GridLocationValidator("10 10");
        validator.assertValideLocation(0, 0);
    }

    // Tests For Illegal Inputs
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeMaxLocation() {
        new GridLocationValidator("-1 " + Integer.MAX_VALUE + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMaxLocation() {
        new GridLocationValidator("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullMaxLocation() {
        new GridLocationValidator(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonNumericMaxLocation() {
        new GridLocationValidator("A !");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllFormatedMaxLocation() {
        new GridLocationValidator("1,2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllFormatedGridLocation() {
        GridLocationValidator validator = new GridLocationValidator("10 10");
        validator.assertValideLocation("A", "-5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllFormatedGridLocation1() {
        GridLocationValidator validator = new GridLocationValidator("10 10");
        validator.assertValideLocation(null, "-5");
    }
}