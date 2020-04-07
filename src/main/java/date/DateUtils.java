package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xulin
 * @date 2020/3/31 14:01
 */
public class DateUtils {
    /*
    写在前面的话
    对时间戳的一些理解
        1.时间戳是指格林威治时间1970年01月01日00时00分00秒
    (北京时间1970年01月01日08时00分00秒)起至现在的总秒数
    使用时间戳的好处：
        1、时间戳没有时区概念，比如如果用'2015-12-31 17:00:00'这么一个字符串表示时间的话，
        北京时间和美国时间是不一样的，但是用时间戳1451552400来表示的话，
        那就是一定是唯一的时间，不会有歧义；
        2、时间戳在编程语言中一般是长整形数据类型，无论何种编程语言都能认识时间戳，
        如果用字符串表示时间，还需要转换。
     */

    /**
     * 时间格式 年-月-日
     * (yyyy-MM-dd)
     */
    private final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式 年月日时分秒
     * (yyyy-MM-dd HH:mm:ss)
     */
    private final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式 时分秒
     * HH:mm:ss)
     */
    private final static String TIME_PATTERN = "HH:mm:ss";

    /**
     * @param date 日期
     * @return 返回yyyy-MM-dd格式日期
     * 日期格式化 日期格式为：yyyy-MM-dd
     */
    public static String dateFormat(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * @param date 日期
     * @return 返回HH:mm:ss格式日期
     * 日期格式化 日期格式为：HH:mm:ss
     */
    public static String timeFormat(Date date) {
        return format(date, TIME_PATTERN);
    }

    /**
     * @param date    日期
     * @param pattern 格式，如：DateUtils.DATE_TIME_PATTERN
     * @return 返回yyyy-MM-dd格式日期
     * 日期格式化 日期格式为：yyyy-MM-dd
     */
    private static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * <p>+n天</p>
     *
     * @param date    日期
     * @param days    天数
     * @param pattern 时间格式
     */
    public static String addDay(Date date, Long days, String pattern) {
        // 得到指定日期的毫秒数
        long time = date.getTime();
        // 要加上的天数转换成毫秒数
        Long millis = days * 24 * 60 * 60 * 1000;
        time += millis;
        return format(new Date(time), pattern);
    }

    /**
     * <p>-n天</p>
     *
     * @param date    日期
     * @param days    天数
     * @param pattern 时间格式
     */
    public static String subDay(Date date, Long days, String pattern) {
        // 得到指定日期的毫秒数
        long time = date.getTime();
        // 要加上的天数转换成毫秒数
        Long millis = days * 24 * 60 * 60 * 1000;
        time -= millis;
        return format(new Date(time), pattern);
    }
}
