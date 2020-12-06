package BiShe.途虎养车;


public class Main {
    public int[] arrayMerge(int[] array1, int n, int[] array2, int m) {
        // write code here

        int res[] = new int[m + n];

        return res;
    }


    public int combination(int r, int n) {
        // write code here
        if (n==0||n==r)
            return 1;
        if(n==1)
                return r;
        if(n>r/2)
            return combination(r,r-n);
        if (n>1)
            return combination(r-1,n-1)+combination(r-1,n);
        return -1;
    }
}
