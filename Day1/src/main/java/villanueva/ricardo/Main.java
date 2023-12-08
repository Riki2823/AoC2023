package villanueva.ricardo;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        String values = "two1nine,eightwothree,abcone2threexyz,xtwone3four,4nineeightseven2,zoneight234,7pqrstsixteen";
        String[] valuesAr = values.split(",");
        String[] validValues = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};


        System.out.println("Result: " + getNumber(valuesAr, validValues));
    }

    public static int getNumber(String[] input, String[] validValues) {
        int result = 0;
        for (String s : input) {
            //usar string utils
            String[] chars = s.split("");
            String first = "";
            String second = "";

            for (String c : chars) {
                if (isNumber(c)) {
                    first = c;
                    break;
                }
            }
            for (int i = chars.length - 1; i >= 0; i--) {
                if (isNumber(chars[i])) {
                    second = chars[i];
                    break;
                }
            }

            String res = first + second;
            System.out.println(s + ": " +  res);
            result += Integer.parseInt(res);
        }
        return result;
    }

    private static boolean isNumber(String aChar) {
        try {
            Integer.parseInt(aChar);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}