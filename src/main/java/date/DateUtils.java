package date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
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

    /**
     * 获取当前时间所在年的天数
     */
    public static Integer getYearDays() {
        return LocalDate.now().lengthOfYear();
    }

    /**
     * 根据输入的年份获取该年份的总天数
     */
    public static Integer getDaysByYear(Integer year) {
        return LocalDate.of(year, 1, 1).lengthOfYear();
    }

    /**
     * 获取当前所在年 月 日 时 分 秒
     */
    public static void getCurrentInfo() {
        Calendar calendar = Calendar.getInstance();
        // 当前所在的年
        int year = calendar.get(Calendar.YEAR);
        System.out.println("当前所在的年" + year);
        // 当前所在的月
        int month = calendar.get(Calendar.MONTH);
        System.out.println("当前所在的月" + month);
        // 获取当前所在日
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("获取当前所在日" + dayOfMonth);
        // 获取当前所在的小时(24小时制)
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("获取当前所在的小时(24小时制)" + hourOfDay);
        // 获取当前所在的小时（12小时制）
        int hour = calendar.get(Calendar.HOUR);
        System.out.println("获取当前所在的小时（12小时制）" + hour);
        // 获取当前所在的分钟
        int minute = calendar.get(Calendar.MINUTE);
        System.out.println("获取当前所在的分钟" + minute);
        // 获取当前秒
        int second = calendar.get(Calendar.SECOND);
        System.out.println("获取当前秒" + second);
        // 获取当前是星期几
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("获取当前是星期几" + dayOfWeek);
        // 获取当前年的第几周
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println("获取当前年的第几周" + weekOfYear);
        // 获取当前月的星期数  (对这个持有怀疑态度)
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        System.out.println("获取当前月的星期数" + weekOfMonth);
        // 获取当前月的第几个星期
        int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println("获取当前月的第几个星期" + dayOfWeekInMonth);
        // 获取当前年的第几天
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("获取当前年的第几天" + dayOfYear);
    }


}
