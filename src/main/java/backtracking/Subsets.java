package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Subsets obj = new Subsets();
        obj.subsets(arr, 0, result, tempList);
        obj.display(result);
    }

    private void subsets(int[] arr, int index, List<List<Integer>> result, List<Integer> tempList) {

        result.add(new ArrayList<>(tempList));

        for (int i = index; i < arr.length; i++) {
            tempList.add(arr[i]);
            subsets(arr, i + 1, result, tempList);
            tempList.remove(tempList.size() - 1);
        }
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
