package check;

import java.util.List;
import java.util.Map;

/**
 * @author xulin
 * @date 2020/3/23 15:12
 * @desc 本类用于对输入的数据进行空判断
 */
public class CheckUtil {
    /**
     * 判断对象是否为空
     * 空 true
     * 非空 false
     */
    public static boolean isEmpty(Object obj) {
        return (obj == null || "".equals(obj));
    }

    /**
     * 判断对象是否为非空
     * 非空 true
     * 空 false
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断字符串是否为空
     * 空 true
     * 非空 false
     */
    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str));
    }

    /**
     * 判断字符串是否为非空
     * 非空 true
     * 空 false
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断Map是否为空
     * 空 true
     * 非空 false
     */
    public static boolean isEmpty(Map map) {
        return (map == null || map.size() == 0);
    }

    /**
     * 判断Map是否为非空
     * 非空 true
     * 空 false
     */
    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    /**
     * 判断List是否为空
     * 空 true
     * 非空 false
     */
    public static boolean isEmpty(List list) {
        return (list == null || list.size() == 0);
    }

    /**
     * 判断List是否为非空
     * 非空 true
     * 空 false
     */
    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    /**
     * 判断数组array是否为空
     * 空 true
     * 非空 false
     */
    public static boolean isEmpty(Object[] arr) {
        return (arr == null || arr.length == 0);
    }

    /**
     * 判断数组arr是否为非空
     * 非空 true
     * 空 false
     */
    public static boolean isNotEmpty(Object[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 检查字符串是否为空白字符串
     * 空白 true
     * 不空白 false
     */
    public static boolean isBlank(String str) {
        return isEmpty(str.trim());
    }

    /**
     * 检查字符串是否为非空白字符串
     * 不空白 true
     * 空白 false
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str.trim());
    }


    public static void main(String[] args) {
        String str1 = "你好";
        System.out.println(isEmpty(str1));
    }

}
