/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
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
    // 1) All 0's
    @Test
    public void testMonthlyPayment1() {
        System.out.println("monthlyPayment1");
        double amt = 0.0;
        double annInterestRate = 0.0;
        int yrs = 0;
        double expResult = -1.0;
        double result = Helper.monthlyPayment(amt, annInterestRate, yrs);
        assertEquals(expResult, result, 0);
    }
    
    // amt == 0
    @Test
    public void testMonthlyPayment2() {
        System.out.println("monthlyPayment2");
        double amt = 0.0;
        double annInterestRate = 5.0;
        int yrs = 5;
        double expResult = 0.0;
        double result = Helper.monthlyPayment(amt, annInterestRate, yrs);
        assertEquals(expResult, result, 0);
    }
    
    // annIterestRate == 0
    @Test
    public void testMonthlyPayment3() {
        System.out.println("monthlyPayment3");
        double amt = 1000.0;
        double annInterestRate = 0.0;
        int yrs = 5;
        double expResult = -1.0;
        double result = Helper.monthlyPayment(amt, annInterestRate, yrs);
        assertEquals(expResult, result, 0);
    }
    
    // yrs == 0
    @Test
    public void testMonthlyPayment4() {
        System.out.println("monthlyPayment3");
        double amt = 1000.0;
        double annInterestRate = 5.0;
        int yrs = 0;
        double expResult = -1.0;
        double result = Helper.monthlyPayment(amt, annInterestRate, yrs);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testMonthlyPayment5() {
        System.out.println("monthlyPayment5");
        double amt = 10000;
        double annInterestRate = 15.0;
        int yrs = 5;
        double expResult = 125/(1 - 1 / (Math.pow((1+15.0/1200), (60))));
        double result = Helper.monthlyPayment(amt, annInterestRate, yrs);
        assertEquals(expResult, result, 0);
    }
    
}