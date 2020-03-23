package string;

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

    // TODO: 2020/3/23 想到好玩的再写吧 

    /**
     * 将传入的所有字符串按顺序拼接成一个字符串返回
     */
    private static String append(String... str) {
        StringBuilder result = new StringBuilder();
        for (String temp : str) {
            result.append(temp);
        }
        return result.toString();
    }


}
