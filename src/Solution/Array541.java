package Solution;

public class Array541 {
    public String reverseStr(String s, int k) {
        char []temp = s.toCharArray();
        //每次跳跃2k个元素
        for (int start = 0; start <temp.length ; start+=2*k) {
            int left = start;
            //比较前k个元素的最后一个元素索引 与 数组的最后一个元素索引  大小
            //如果right = start+k-1，证明还没有到数组末尾，start+k-1就是本次循环的2k个元素中第k个元素，反转前k个元素
            //如果right = temp.length-1，证明已经到达数组末尾，并且不足k个元素，全部反转即可
            int right = Math.min(start+k-1,temp.length-1);
            while (left<right){
                char c = temp[left];
                temp[left] = temp[right];
                temp[right] = c;
                left++;
                right--;
            }
        }
        return new String(temp);
    }

}
