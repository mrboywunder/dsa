package src.dsa.dp;

import java.util.HashMap;
import java.util.Objects;

public class LongestValidParantheses {

    public boolean isValid(String input) {
        int i = 0;
        while (input.charAt(i) == ')') {
            i++;
        }

        int counter = 0;

        for (int j = i; j < input.length(); j ++) {
            if (input.charAt(j) == '(' ) {
                counter++;
                if (counter == 1) {
                    System.out.println("Valid parantheses start at index " + j);
                }
            }
            else {
                counter--;
                if (counter == 0) {
                    System.out.println("Valid parantheses end at index " + j);
                }
            }

        }
        return counter == 0 ;
    }
}
