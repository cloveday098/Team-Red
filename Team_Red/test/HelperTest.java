/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author loved
 */
public class HelperTest {
    
    public HelperTest() {
        
 }

    /**
     * Tests of add method, of class Helper.
     */
    @Test
    public void testAdd1() {
        System.out.println("add#1");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Helper.add(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testAdd2() {
        System.out.println("add#2");
        int a = 999999999;
        int b = 999999999;
        int expResult = 1999999998;
        int result = Helper.add(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testAdd3() {
        System.out.println("add#3");
        int a = -1;
        int b = -1;
        int expResult = -2;
        int result = Helper.add(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPos method, of class Helper.
     */
    @Test
    public void testIsPos() {
        System.out.println("isPos");
        int n = 0;
        Helper instance = new Helper();
        boolean expResult = false;
        boolean result = instance.isPos(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of monthlyPayment method, of class Helper.
     */
    @Test
    public void testMonthlyPayment1() {
        System.out.println("monthlyPayment");
        double amt = 0.0;
        double annInterestRate = 0.0;
        int yrs = 0;
        double expResult = 0.0;
        double result = Helper.monthlyPayment(amt, annInterestRate, yrs);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testMonthlyPayment2() {
        System.out.println("monthlyPayment");
        double amt = 10000;
        double annInterestRate = 15.0;
        int yrs = 5;
        double expResult = 125.0;
        double result = Helper.monthlyPayment(amt, annInterestRate, yrs);
        assertEquals(expResult, result, 0);
    }
    
}