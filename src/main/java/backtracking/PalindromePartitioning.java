package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        String inputStr = "aabppc";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.palindromePartition(0,result,tempList,inputStr);
        palindromePartitioning.display(result);
    }

    private void palindromePartition(int index,List<List<String>> result, List<String> currentDecomposition, String inputStr){
        if(index==inputStr.length()){
            result.add(new ArrayList<>(currentDecomposition));
            return;
        }

        for(int i=index; i<inputStr.length();i++){
            if(isValidPalindrome(inputStr,index, i)){
                currentDecomposition.add(inputStr.substring(index, i+1));
                palindromePartition(i+1, result, currentDecomposition, inputStr);
                currentDecomposition.remove(currentDecomposition.size()-1);
            }
        }
    }

    private boolean isValidPalindrome(String s, int i, int j){
        while(i>=0 && j<s.length() && i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void display(List<List<String>> result) {
        for (List<String> tList : result) {
            System.out.print("\n");
            for (String i : tList) {
                System.out.print("\t" + i);
            }
        }
    }
}
