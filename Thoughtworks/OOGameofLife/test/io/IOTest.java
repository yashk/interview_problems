/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io;

import domain.pattern.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 186946
 */
public class IOTest {

    public IOTest() {
    }

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

    /**
     * Test of getPattern method, of class IO.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInvaildeInput() {
        String input = "--XXYY";
        IO instance = new IO();
        Pattern expResult = instance.getPattern(input);
        System.out.println("result "+ expResult);
    }

}