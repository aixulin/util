package date;

import java.util.Date;

/**
 * @author xulin
 * @date 2020/3/24 11:17
 * @desc 该工具类用于一些时间和日期的转化
 */
public class DateUtil {
    // TODO: 2020/3/26  定义一些常用的数据格式等



    /**
     * 获取当前日期 long 型
     */
    private static Long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前日期
     * 返回的格式： 2020-03-04 17:38:36
     */
    private static Date getDate() {
        return new Date();
    }
}
