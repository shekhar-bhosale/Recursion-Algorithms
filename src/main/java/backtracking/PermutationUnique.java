package backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationUnique {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2};
        List<List<Integer>> result = new ArrayList<>();
        PermutationUnique permutationUnique = new PermutationUnique();
        permutationUnique.permuteUtil(arr, 0, result);
        permutationUnique.display(result);
    }

    private void permuteUtil(int[] arr, int index, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> tempList = Arrays.stream(arr).boxed().collect(Collectors.toList());
            result.add(tempList);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                swap(arr, i, index);
                permuteUtil(arr, index + 1, result);
                swap(arr, i, index);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void display(List<List<Integer>> result) {
        for (List<Integer> tList : result) {
            System.out.print("\n");
            for (int i : tList) {
                System.out.print("\t" + i);
            }
        }
    }
}


