package spell;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Test {


    //拼音简写方法
    public static String spell(String str) throws BadHanyuPinyinOutputFormatCombination {
        //拼音输出格式
        HanyuPinyinOutputFormat fmt = new HanyuPinyinOutputFormat();
        //设置生成的拼音是大写还是小写
        fmt.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //设置是否显示声调
        fmt.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //设置是否将yu 转成 v
        fmt.setVCharType(HanyuPinyinVCharType.WITH_V);
        //拼音数组  多音字
        String ps[] = null;
        String res = "";
        /*
        如果当前字符是汉字，ps就有值，不是null
        如果ps是null，直接输出原字符
        * */
        for (char c : str.toCharArray()) {
            //将指定汉字依据指定格式转换为拼音
            ps = PinyinHelper.toHanyuPinyinStringArray(c, fmt);
            //判断是否为拼音
            if (ps != null) {
                //拼音简拼
                res += ps[0].charAt(0);
            } else {
                res += c;
            }
        }
        return res;
    }

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(spell("张源"));
    }

}
