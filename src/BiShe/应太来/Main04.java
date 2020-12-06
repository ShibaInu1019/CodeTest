package BiShe.应太来;

public class Main04 {


    public static String printObliqueArray(int[][] arr) {
        StringBuilder builder = new StringBuilder();
        //总循环次数，要求性能最高，数组多少个数就循环多少次
        int allcount = 0;
        //大体上打印多 少行，也就是上图的斜线条数
        int num = arr.length + arr[0].length - 1;
        //二维数组的列数
        int num2 = arr[0].length;
        //j开始的下标
        int jstart = 0;
        //j结束的下标
        int jend = 0;
        //循环打印
        for (int i = 0; i < num; i++) {
            //超过第4行，x就是有了规律，此处控制x
            int x = (i > (num2 - 1)) ? (i - num2 + 1) : 0;
            //控制循环次数和数组的y坐标
            jstart = (i > num2 - 1) ? num2 - 1 : i;
            jend = (num2 + i - num < 0) ? 0 : num2 + i - num;
            //打印每一行
            for (int j = jstart; j >= jend; j--) {
                builder.append(arr[x][j]+",");
                x++;
                allcount++;
            }
        }
        return builder.toString().substring(0,builder.length()-1);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12}};
        System.out.println(printObliqueArray(arr));
    }
}
