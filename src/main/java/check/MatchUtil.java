package check;

/**
 * @author xulin
 * @date 2020/3/23 17:49
 * 此类用于存放一些常用的正则表达式子
 */
public class MatchUtil {
    /**
     * 手机号正则
     * 会持续关注营业厅发布的号段 之后进行更新
     */
    public static final String REGEX_TEL = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0-8])|(18[0-9])|(19[1|8|9]))\\d{8}$";
    /**
     * 邮箱验证
     */
    public static final String REGEX_EMAIL = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    /**
     * 密码正则
     * 包含 大写字母 小写字母 数字 特殊符号 在8-16位之间
     */
    public static final String REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[_.#?!@$%^&*-]).{8,16}$";





}
