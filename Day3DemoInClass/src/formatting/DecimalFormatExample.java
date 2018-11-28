package formatting;

import java.text.DecimalFormat;

public class DecimalFormatExample {
    public static void main(String[] args) {
        double value = 1234;

        // pattern displays at least 1 digit left of decimal and uses commas.
        DecimalFormat fmt = new DecimalFormat("#,##0.0");
        System.out.println("Value: (format as (#,##0.0)\t" + fmt.format(value));

        // pattern displays 1 digit to the right of decimal if any
        DecimalFormat fmt1 = new DecimalFormat("#,###.#");
        System.out.println("Value: (format as (#,###.#)\t" + fmt1.format(value));

        // pattern 3 digits to the right of the decimal
        DecimalFormat fmt2 = new DecimalFormat(".000");
        System.out.println("Value: (format as (.000)\t" + fmt2.format(value));

        // 'value' variable has not been changed -- it is still a type double
        System.out.println("Value is still \t\t\t" + value + "\n");
    }
}
