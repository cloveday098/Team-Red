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
            {"Australian Dollar", "Argentine Peso", "2500", 1631518},
            {"Australian Dollar", "Australian Dollar", "2500", 2500},
            {"Australian Dollar", "Bahraini Dinar", "2500", 622},
            {"Australian Dollar", "Botswana Pula", "2500", 22128},
            {"Australian Dollar", "Brazilian Real", "2500", 9424},
            {"Australian Dollar", "British Pound", "2500", 1273},
            {"Australian Dollar", "Bruneian Dollar", "2500", 2186},  
            {"Australian Dollar", "Bulgarian Lev", "2500", 2986},
            {"Australian Dollar", "Canadian Dollar", "2500", 2293},
            {"Australian Dollar", "Chilean Peso", "2500", 1561408},
            {"Australian Dollar", "Chinese Yuan Renminbi", "2500", 11755},
            {"Australian Dollar", "Colombian Peso", "2500", 7142776},
            {"Australian Dollar", "Czech Koruna", "2500", 38683},
            {"Australian Dollar", "Danish Krone", "2500", 11386},
            {"Australian Dollar", "Emirati Dirham", "2500", 6067},
            {"Australian Dollar", "Euro", "2500", 1529},
            {"Australian Dollar", "Hong Kong Dollar", "2500", 12829},
            {"Australian Dollar", "Hungarian Forint", "2500", 618011},
            {"Australian Dollar", "Icelandic Krona", "2500", 227614},
            {"Australian Dollar", "Indian Rupee", "2500", 138856},
            {"Australian Dollar", "Indonesian Rupiah", "2500", 25883699},
            {"Australian Dollar", "Iranian Rial", "2500", 69568213},
            {"Australian Dollar", "Israeli Shekel", "2500", 6150},
            {"Australian Dollar", "Japanese Yen", "2500", 251438},
            {"Australian Dollar", "Kazakhstani Tenge", "2500", 807508},
            {"Australian Dollar", "Kuwaiti Dinar", "2500", 505},
            {"Australian Dollar", "Libyan Dinar", "2500", 7928},
            {"Australian Dollar", "Malaysian Ringgit", "2500", 7181},
            {"Australian Dollar", "Mauritian Rupee", "2500", 76122},
            {"Australian Dollar", "Mexican Peso", "2500", 33003},
            {"Australian Dollar", "Nepalese Rupee", "2500", 221376},
            {"Australian Dollar", "New Zealand Dollar", "2500", 2754},
            {"Australian Dollar", "Norwegian Krone", "2500", 18093},
            {"Australian Dollar", "Omani Rial", "2500", 634},
            {"Australian Dollar", "Pakistani Rupee", "2500", 457700},
            {"Australian Dollar", "Philippine Peso", "2500", 95909},
            {"Australian Dollar", "Polish Zloty", "2500", 6622},
            {"Australian Dollar", "Qatari Riyal", "2500", 6000},
            {"Australian Dollar", "Romanian New Leu", "2500", 7570},
            {"Australian Dollar", "Russian Ruble", "2500", 160132},
            {"Australian Dollar", "Saudi Arabian Riyal", "2500", 6184},
            {"Australian Dollar", "Singapore Dollar", "2500", 2181},
            {"Australian Dollar", "South African Rand", "2500", 29184},
            {"Australian Dollar", "South Korean Won", "2500", 2292734},
            {"Australian Dollar", "Sri Lankan Rupee", "2500", 483212},
            {"Australian Dollar", "Swedish Krona", "2500", 17513},
            {"Australian Dollar", "Swiss Franc", "2500", 1431},
            {"Australian Dollar", "Taiwan New Dollar", "2500", 52869},
            {"Australian Dollar", "Thai Baht", "2500", 55646},
            {"Australian Dollar", "Trinidadian Dollar", "2500", 11160},
            {"Australian Dollar", "Turkish Lira", "2500", 56453},
            {"Australian Dollar", "US Dollar", "2500", 1652},
            {"Australian Dollar", "Venezuelan Bolivar", "2500", 2147483647}
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
        assertEquals(expResult, result, result * 0.05);
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
