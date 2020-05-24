package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Combination obj = new Combination();
        obj.combinations(4,2,1,result,tempList);
        obj.display(result);
    }

    private void combinations(int n, int k, int index, List<List<Integer>> result, List<Integer> tempList){
        if(k==0){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=index; i<=n; i++){
            tempList.add(i);
            combinations(n,k-1, i+1, result, tempList);
            tempList.remove(tempList.size()-1);
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
