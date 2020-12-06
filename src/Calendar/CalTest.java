package Calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calendar calendar = Calendar.getInstance();

        System.out.print("年份：");
        int year = sc.nextInt();
        System.out.print("月份：");
        int month = sc.nextInt();
        System.out.print("日期：");
        int day = sc.nextInt();

        //设置日期
        calendar.set(year, month - 1, 1);
        //获取星期
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        //获取月份天数
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(year + "年" + month + "月");
        System.out.println("一\t二\t三\t四\t五\t六\t日");

        week = week > 0 ? week : 7;

        for (int i = 1; i < week; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i < days; i++) {
            if (day == i)
                System.out.print("*" + i + "\t");
            else
                System.out.print(i + "\t");
            if (week % 7 == 0)
                System.out.println();
            week++;
        }
    }
}
