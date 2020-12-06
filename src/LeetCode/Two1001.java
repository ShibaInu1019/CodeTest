package LeetCode;

public class Two1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int last = A.length - 1;

        while (j > -1 && i > -1) {
            if (A[i] <= B[j]) {
                A[last] = B[j];
                last--;
                j--;
            } else {
                A[last] = A[i];
                last--;
                i--;
            }
        }

        //有且只有B数组可能有剩余元素
        while (j != -1) {
            A[last] = B[j];
            j--;
            last--;
        }
    }
}
