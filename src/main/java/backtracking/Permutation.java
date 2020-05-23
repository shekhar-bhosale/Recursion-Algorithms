package backtracking;

public class Permutation {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation("abc");
    }

    public void permutation(String input){
        permutationUtil(input,0);
    }

    private void permutationUtil(String input, int index){
        if(index==input.length()){
            System.out.println("String permuation:"+input);
        }

        System.out.println("input:"+input+"  index:"+index);

        for(int i=index;i<input.length();i++){
            input = swap(input,index,i);
            permutationUtil(input,index+1);
            input = swap(input,index,i);
        }



    }

    private String swap(String str, int i, int j){
        char strArr[]=str.toCharArray();
        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
        return String.valueOf(strArr);
    }

}
