package ETC;


public class StringCalculator {

    public int add(String input1, String input2) {
        int inputNumber1 = stringToInt(input1);
        int inputNumber2 = stringToInt(input2);
        return inputNumber1 + inputNumber2;
    }

    private int stringToInt(String input) {
        int output = 0;
        int digit = 1;
        for(int i = input.length() - 1; i >= 0; --i){
            output += (input.charAt(i) - '0') * digit;
            digit *= 10;
        }
        return output;
    }
}
