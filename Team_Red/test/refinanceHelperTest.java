/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author loved
 */
public class refinanceHelperTest {
    public refinanceHelperTest() {
    }
    
    /**
     * Test of findAPR method, of class refinanceHelper.
     */
    @Test
    public void testFindAPR() {
        System.out.println("findAPR");
        // Case 1
        double P = 250000.0;
        double MP = 1800.0;
        double newLoanTerm = 20.0;
        double costs = 1500.0;
        double expResult = 0.06329;
        double result = refinanceHelper.findAPR(P, MP, newLoanTerm, costs);
        assertEquals(expResult, result, 0.01);
        
        // Not close??
        // Case 2
        P = 10000.0;
        MP = 1800.0;
        newLoanTerm = 10.0;
        costs = 2000.0;
        expResult = 0.10996;
        result = refinanceHelper.findAPR(P, MP, newLoanTerm, costs);
        assertEquals(expResult, result, 0.01);
        
        
        // Case 3
        P = 100000.0;
        MP = 1000.0;
        newLoanTerm = 120.0;
        costs = 2000.0;
        expResult = 0.05;
        result = refinanceHelper.findAPR(P, MP, newLoanTerm, costs);
        assertEquals(expResult, result, 0.01);
        
        // Amount doesn't change, so is it supposed to be infinity? Should we validate p=0?
        // Case 4
        P = 0.0;
        MP = 1800.0;
        newLoanTerm = 20.0;
        costs = 1500.0;
        expResult = 0;
        result = refinanceHelper.findAPR(P, MP, newLoanTerm, costs);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of findMP method, of class refinanceHelper.
     */
    
    /*@Test
    public void testFindMP() {
        System.out.println("findMP");
        double loanAmt = 0.0;
        double years = 0.0;
        double interestRate = 0.0;
        double expResult = 0.0;
        double result = refinanceHelper.findMP(loanAmt, years, interestRate);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of findRemainingBal method, of class refinanceHelper.
     */
    /*@Test
    public void testFindRemainingBal() {
        System.out.println("findRemainingBal");
        double originalLoan = 0.0;
        double loanTerm = 0.0;
        double timeLeft = 0.0;
        double interestRate = 0.0;
        double expResult = 0.0;
        double result = refinanceHelper.findRemainingBal(originalLoan, loanTerm, timeLeft, interestRate);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
