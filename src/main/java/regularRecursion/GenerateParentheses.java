package regularRecursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        GenerateParentheses obj = new GenerateParentheses();
        obj.generateParentheses(3, 3, "", result);
        obj.display(result);
    }

    private void generateParentheses(int numLeftParenNeeded, int numRightParenNeeded, String currentString, List<String> result) {
        if (numLeftParenNeeded == 0 && numRightParenNeeded == 0) {
            result.add(currentString);
            return;
        }
        if (numLeftParenNeeded > 0) {
            generateParentheses(numLeftParenNeeded - 1, numRightParenNeeded, currentString + "(", result);
        }
        if (numLeftParenNeeded < numRightParenNeeded) {
            generateParentheses(numLeftParenNeeded, numRightParenNeeded - 1, currentString + ")", result);
        }

    }

    private void display(List<String> result) {
        for (String str : result) {
            System.out.println(str);
        }
    }

}
