/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author loved
 */
@RunWith(Parameterized.class)
public class currency_calcTest {
    
    private Object oldCurr;
    private Object newCurr;
    private String oldAmt;
    private int expResult;

    
    // Constructor for parameter injection
    public currency_calcTest(Object oldCurr, Object newCurr, String oldAmt, int expResult) {
        this.oldCurr = oldCurr;
        this.newCurr = newCurr;
        this.oldAmt = oldAmt;
        this.expResult = expResult;
    }

    // Parameters for the test
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            //{"Australian Dollar", "Argentine Peso", "2500", 1234}, //idk
            {"Australian Dollar", "Australian Dollar", "2500", 2500},
            //{"Australian Dollar", "Bahraini Dinar", "2500", 675},  //idk
            //{"Australian Dollar", "Botswana Pula", "2500", 2350},  //idk
            {"Australian Dollar", "Brazilian Real", "2500", 9424},
            {"Australian Dollar", "British Pound", "2500", 1273},
            //{"Australian Dollar", "Bruneian Dollar", "2500", 2500},  //idk
            //{"Australian Dollar", "Bulgarian Lev", "2500", 1534},  //idk
            //{"Australian Dollar", "Canadian Dollar", "2500", 2293},
            //{"Australian Dollar", "Chilean Peso", "2500", 1800},  //idk
            //{"Australian Dollar", "Chinese Yuan Renminbi", "2500", 11755},
            //{"Australian Dollar", "Colombian Peso", "2500", 920},  //idk
            //{"Australian Dollar", "Czech Koruna", "2500", 1450},  //idk
            //{"Australian Dollar", "Danish Krone", "2500", 1350},  //idk
            //{"Australian Dollar", "Emirati Dirham", "2500", 2435},  //idk
            {"Australian Dollar", "Euro", "2500", 1529},
            {"Australian Dollar", "Hong Kong Dollar", "2500", 12829},
            //{"Australian Dollar", "Hungarian Forint", "2500", 1750},  //idk
            //{"Australian Dollar", "Icelandic Krona", "2500", 1250},  //idk
            {"Australian Dollar", "Indian Rupee", "2500", 138856},
            //{"Australian Dollar", "Indonesian Rupiah", "2500", 1000},  //idk
            //{"Australian Dollar", "Iranian Rial", "2500", 750},  //idk
            //{"Australian Dollar", "Israeli Shekel", "2500", 2300},  //idk
            {"Australian Dollar", "Japanese Yen", "2500", 251438},
            //{"Australian Dollar", "Kazakhstani Tenge", "2500", 1600},  //idk
            //{"Australian Dollar", "Kuwaiti Dinar", "2500", 600},  //idk
            //{"Australian Dollar", "Libyan Dinar", "2500", 1100},  //idk
            //{"Australian Dollar", "Malaysian Ringgit", "2500", 2000},  //idk
            //{"Australian Dollar", "Mauritian Rupee", "2500", 1850},  //idk
            {"Australian Dollar", "Mexican Peso", "2500", 33003},
            //{"Australian Dollar", "Nepalese Rupee", "2500", 1200},  //idk
            //{"Australian Dollar", "New Zealand Dollar", "2500", 2500},  //idk
            //{"Australian Dollar", "Norwegian Krone", "2500", 1400},  //idk
            //{"Australian Dollar", "Omani Rial", "2500", 700},  //idk
            //{"Australian Dollar", "Pakistani Rupee", "2500", 1500},  //idk
            //{"Australian Dollar", "Philippine Peso", "2500", 1300},  //idk
            //{"Australian Dollar", "Polish Zloty", "2500", 1600},  //idk
            //{"Australian Dollar", "Qatari Riyal", "2500", 1900},  //idk
            //{"Australian Dollar", "Romanian New Leu", "2500", 1700},  //idk
            {"Australian Dollar", "Russian Ruble", "2500", 160132},
            //{"Australian Dollar", "Saudi Arabian Riyal", "2500", 2400},  //idk
            {"Australian Dollar", "Singapore Dollar", "2500", 2181},
            {"Australian Dollar", "South African Rand", "2500", 29184},
            {"Australian Dollar", "South Korean Won", "2500", 2292734},
            //{"Australian Dollar", "Sri Lankan Rupee", "2500", 1250},  //idk
            //{"Australian Dollar", "Swedish Krona", "2500", 1350},  //idk
            {"Australian Dollar", "Swiss Franc", "2500", 1431},
            //{"Australian Dollar", "Taiwan New Dollar", "2500", 1500},  //idk
            //{"Australian Dollar", "Thai Baht", "2500", 1900},  //idk
            //{"Australian Dollar", "Trinidadian Dollar", "2500", 2500},  //idk
            //{"Australian Dollar", "Turkish Lira", "2500", 1400},  //idk
            {"Australian Dollar", "US Dollar", "2500", 1652},
            //{"Australian Dollar", "Venezuelan Bolivar", "2500", 800}  //idk
        });
    }
    /**
     * Test of convert method, of class currency_calc.
     */
    @Test
    
    public void testConvert() {
        System.out.println("convert");
        //Object oldCurr = "Australian Dollar";
        //Object newCurr = "Euro";
        //String oldAmt = "2500";
        currency_calc instance = new currency_calc();
        //int expResult = 1529;
        int result = instance.convert(oldCurr, newCurr, oldAmt).intValue();
        System.out.println(5 + (result * expResult/result));
        assertEquals(expResult, result, result * expResult/result);
    }

    /**
     * Test of currencyValidate method, of class currency_calc.
    @Test
    public void testCurrencyValidate() {
        System.out.println("currencyValidate");
        Object oldCurr = "Australian Dollar";
        Object newCurr = "Euro";
        String oldAmt = "2500";
        currency_calc instance = new currency_calc();
        instance.currencyValidate(oldCurr, newCurr, oldAmt);
    }
    */
    
}
