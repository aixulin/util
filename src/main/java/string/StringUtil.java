package string;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static check.CheckUtil.isEmpty;

/**
 * @author xulin
 * @date 2020/3/23 15:59
 * @desc 字符串的一些工具类
 * 实际上java中字符串已经提供了相当完善的工具类给我们使用
 * 此处书写 有一部分是强化概念(原String已经提供了的方法)
 * 少量常用的方法
 */
public class StringUtil {

    /**
     * 转大写
     */
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    /**
     * 转小写
     */
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * String和其他数据类型之间的转换
     */
    public static void exchange() {
        String str = "123";
        // String 转化为Integer /int  Long/long
        int i = Integer.parseInt(str);
        Integer integer = Integer.valueOf(str);

        long l = Long.parseLong(str);
        Long aLong = Long.valueOf(str);

        // String 转化为 Double /double  Float/float  BigDecimal
        double v = Double.parseDouble(str);
        Double aDouble = Double.valueOf(str);

        float v2 = Float.parseFloat(str);
        Float aFloat = Float.valueOf(str);

        BigDecimal bigDecimal = new BigDecimal(str);

        // 其他类型向String 转化 调用toString方法
    }

    /**
     * 将传入的所有字符串按顺序拼接成一个字符串返回
     */
    public static String append(String... str) {
        StringBuilder result = new StringBuilder();
        for (String temp : str) {
            result.append(temp);
        }
        return result.toString();
    }

    /**
     * 去空格
     */
    public static String trim(String str) {
        return str.trim();
    }

    /**
     * 判断两个字符串是否相等
     */
    public static boolean equal(String str1, String str2) {
        return str1.equals(str2);
    }

    /**
     * 两个字符串忽略大小写相等
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    /**
     * 字符串转list 逗号分隔
     */
    public static List<String> getListFromString(String str) {
        String[] xx = str.split(",");
        return Arrays.asList(xx);
    }

    /**
     * 逗号分隔的整形的数字转化为整形的list
     */
    public static List<Integer> getIntegerListFromString(String str) {
        List<Integer> sList = new ArrayList<Integer>();
        String[] xx = str.split(",");
        for (String temp : xx) {
            sList.add(Integer.parseInt(temp));
        }
        return sList;
    }

    /**
     * 将list转化成逗号分隔的字符串
     */
    public static String getStringFromList(List<String> list) {
        if (isEmpty(list)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : list) {
            stringBuilder.append(str).append(",");
        }
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 1);
    }


    // TODO: 2020/3/23 想到好玩的再写吧


}
