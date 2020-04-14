package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author xulin
 * @date 2020/4/14 10:21
 * @desc 此类用于json转化的一些内容（利用到的引用是阿里巴巴下的fastjson包）
 */
public class JsonUtil {
    /**
     * 将某个对象转化成JSON字符串
     */
    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 将字符串转化成json对象
     */
    public static <T> T parseObject(String str, Class<T> clazz) {
        return JSON.parseObject(str, clazz);
    }

    /**
     * 将字符串转化为list
     */
    public static <T> List<T> parseArray(String str, Class<T> clazz) {
        return JSON.parseArray(str, clazz);
    }

    /**
     * 复杂类型的json转化需要先定义type 然后再进行转化
     */
    public static Type defineType() {
        return new TypeReference<Map<String, Object>>() {
        }.getType();
    }

    public static void main(String[] args) {
        /* 这里简单写一个demo书写使用形式 在工作中偶然遇到了这种形式的 实际情况比这种更复杂一点
        map中是一个对象，用普通的封装之后去解析会报错*/
        String str = " {\"money\":\"100.00\",\"payMethod\":\"alipay\"}";
        Type type = defineType();
        Map<String, Object> map = JSON.parseObject(str, type);
        System.out.println(map.get("money"));
        System.out.println(map.get("payMethod"));
    }

}
