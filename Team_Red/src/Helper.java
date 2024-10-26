
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Currency;
import java.util.Map;
import java.util.TreeMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loved
 */

// validate funct
// monthlyPayment funct
// Unit tests for both
public class Helper {
    public static boolean isValidNumber(String test) 
    {
        try {
            float num = Float.parseFloat(test);
        }
        catch (NumberFormatException e) {
            System.out.println(test + " caused " + e);
            return false;
        }
        return true;
    }
    
    public static boolean isPos(String num) 
    {
        if (isValidNumber(num)) {
            if (Float.parseFloat(num) > 0) {
                return true;
            }
            //System.out.println("You cannot have a height or weight <= 0!");
        }
        //System.out.println(num + " is not a number.");
        return false;
    }
    
    public static double monthlyPayment(double amt, double annInterestRate, int yrs) {
        String msg = "";
        if (!isPos(String.valueOf(yrs))) {
            msg += "Years must be > 0!\n";
        }
        if (!isPos(String.valueOf(annInterestRate))) {
            System.out.println("Nice try.");
            msg += "Annual interest rate must be > 0!\n";
        }
        if (amt < 0) {
            msg += "Amount must be > 0!\n";
        }
        
        if (amt > 999999999 || annInterestRate > 999999999) {
            msg += "Amount too large!\n";
        }
        
        if (!msg.equals("")) {
            System.out.println(msg);
            return -1;
        }

        // There shouldn't be a need to validate amt > 0
        double exp = Math.pow((1+annInterestRate/1200), (yrs * 12));
        double result = (amt * annInterestRate/1200) / (1 - 1 / (exp));
        
        // Trying to round to two decimal places
        //BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);  
        //result = bd.doubleValue();
        
        System.out.println(result);
        return result;
    }
    
    public static Map<String, Double> webScraper() {
        String s = "success";
        String url = "http://www.x-rates.com/table/?from=USD&amount=1";
        Map<String, Double> rateDict = new Hashtable();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table.ratesTable > tbody > tr");
            
            // Blank to avoid default currency selection
            rateDict.put("", 0.0);
            rateDict.put("US Dollar", 1.0);
            System.out.println(rateDict.get(""));
            
            for (Element row : rows) {
                Elements tds = row.select("td");
                String currency = tds.get(0).text();
                Double rate1 = Double.valueOf(tds.get(1).text());
                Double rate2 = Double.valueOf(tds.get(2).text());
                //System.out.printf("Currency: %s, rate1: %s, rate2: %s%n", currency, rate1, rate2);
                rateDict.put(currency, rate1);
            }
            rateDict = new TreeMap<String, Double>(rateDict);
        }
        catch (IOException ex) {
            s = "fail";
        }
        System.out.printf("%s", rateDict);
        return rateDict;
    }
    
    // Format the amount using deciamls/commas and currency symbols
    public static String getSymbol(Object currency, Double newAmt) {
        // Arial Unicode MS for symbol font
        double d = newAmt;
        // Checking locale function;
        //String currencyName = NumberFormat.getCurrencyInstance(getLocaleFromCurrency(String.valueOf(currency))).getCurrency().getDisplayName();
        NumberFormat nf
            = NumberFormat.getCurrencyInstance(getLocaleFromCurrency(String.valueOf(currency)));
        //System.out.println("\n" + nf.getCurrency().getDisplayName() + " vs. " + currencyName);
        System.out.println("\n" + currency + " representation of " + d
                           + " : " + nf.format(d));
        return nf.format(d);
    }
    
    // Mapping 
    public static Locale getLocaleFromCurrency(String currencyName) {
        String currencyCode = switch (currencyName) {   // Symbols not displaying
            case "Argentine Peso" -> "ARS";
            case "Australian Dollar" -> "AUD";
            case "Bahraini Dinar" -> "BHD";
            case "Botswana Pula" -> "BWP";     // **Not Working**
            case "Brazilian Real" -> "BRL";
            case "British Pound" -> "GBP";
            case "Bruneian Dollar" -> "BND";      // **Not Working**
            case "Bulgarian Lev" -> "BGN";
            case "Canadian Dollar" -> "CAD";
            case "Chilean Peso" -> "CLP";
            case "Chinese Yuan Renminbi" -> "CNY";
            case "Colombian Peso" -> "COP";
            case "Czech Koruna" -> "CZK";
            case "Danish Krone" -> "DKK";
            case "Emirati Dirham" -> "AED";
            case "Euro" -> "EUR";
            case "Hong Kong Dollar" -> "HKD";
            case "Hungarian Forint" -> "HUF";
            case "Icelandic Krona" -> "ISK";
            case "Indian Rupee" -> "INR";
            case "Indonesian Rupiah" -> "IDR";
            case "Iranian Rial" -> "IRR";
            case "Israeli Shekel" -> "ILS";
            case "Japanese Yen" -> "JPY";
            case "Kazakhstani Tenge" -> "KZT";
            case "Kuwaiti Dinar" -> "KWD";
            case "Libyan Dinar" -> "LYD";
            case "Malaysian Ringgit" -> "MYR";
            case "Mauritian Rupee" -> "MUR";
            case "Mexican Peso" -> "MXN";
            case "Nepalese Rupee" -> "NPR";
            case "New Zealand Dollar" -> "NZD";
            case "Norwegian Krone" -> "NOK";
            case "Omani Rial" -> "OMR";
            case "Pakistani Rupee" -> "PKR";
            case "Philippine Peso" -> "PHP";
            case "Polish Zloty" -> "PLN";
            case "Qatari Riyal" -> "QAR";
            case "Romanian New Leu" -> "RON";
            case "Russian Ruble" -> "RUB";
            case "Saudi Arabian Riyal" -> "SAR";
            case "Singapore Dollar" -> "SGD";
            case "South African Rand" -> "ZAR";
            case "South Korean Won" -> "KRW";
            case "Sri Lankan Rupee" -> "LKR";
            case "Swedish Krona" -> "SEK";
            case "Swiss Franc" -> "CHF";
            case "Taiwan New Dollar" -> "TWD";
            case "Thai Baht" -> "THB";
            case "Trinidadian Dollar" -> "TTD";   // **Not Working; different name**
            case "Turkish Lira" -> "TRY";
            case "US Dollar" -> "USD";
            case "Venezuelan Bolivar" -> "VES";
            
            default -> null;
        };
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                //System.out.println("case " + "\"" + NumberFormat.getCurrencyInstance(locale).getCurrency().getDisplayName()+ "\" -> \"" + currency + "\";");
                //System.out.println(currency.getCurrencyCode().equals(currencyCode));
                if (currency != null && currency.getCurrencyCode().equals(currencyCode)) {
                    return locale;
                }
            } catch (Exception e) {
            }
        }
        System.out.println("Couldn't find " + currencyName);
        return null;
    }

}
