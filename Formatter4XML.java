package XMLhandler;

import java.text.DecimalFormat;

public class Formatter4XML {

    static public String customFormatDigitsWithZeros(String pattern, String value) {
        String result;

        try {
            int digit = Integer.parseInt(value);

            DecimalFormat myFormatter = new DecimalFormat(pattern);
            result = myFormatter.format(digit);
        } catch (NumberFormatException e) {
            result = "";
        }
        return result;
    }

    static public boolean isStringDigit(String value) {
        boolean result = false;
        try {
            Integer.parseInt(value);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }
}
