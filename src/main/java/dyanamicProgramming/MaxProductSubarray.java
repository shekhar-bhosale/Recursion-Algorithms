package dyanamicProgramming;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4, -1};
        MaxProductSubarray obj = new MaxProductSubarray();
        System.out.println("Maximum product of subarray:" + obj.maximumProductSubarray(arr));

    }

    private int maximumProductSubarray(int[] arr) {
        int maxProdSofar = arr[0], minProdSofar = arr[0], result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int a = maxProdSofar * arr[i];
            int b = minProdSofar * arr[i];
            maxProdSofar = Math.max(Math.max(a, b), arr[i]);
            minProdSofar = Math.min(Math.min(a, b), arr[i]);
            result = Math.max(maxProdSofar, result);
        }
        return result;
    }
}
