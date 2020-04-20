package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
/**
* @author xulin
* @date 2020/4/20 10:00
* @Description  redis工具类
*/
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private ListOperations<String, Object> listOperations;
    @Autowired
    private HashOperations<String, String, Object> hashOperations;
    @Autowired
    private SetOperations<String, Object> setOperations;
    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    // *****************************************字符类型的处理************************************************** //
    /**
     *  set
     * @param key
     * @param value
     */
    public void set(String key, String value){
        valueOperations.set(key, value);
    }
    /**
     *  set 带超时时间
     * @param key
     * @param value
     */
    public void set(String key, String value, long expire,TimeUnit unit){
        valueOperations.set(key, value);
        redisTemplate.expire(key, expire, unit);
    }

    /**
     * get
     * @param key
     * @return
     */
    public String get(String key) {
        return valueOperations.get(key);
    }
    /**
     * del
     * @param key
     * @return
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // *****************************************集合类型的处理************************************************** //

    /**
     * 获取长度
     * @param key
     * @return
     */
    public Long size(String key){
        return listOperations.size(key);
    }

    /**
     *  右 进
     * @param key
     * @param object
     * @return
     */
    public Long rightPush(String key,Object object){
        return  listOperations.leftPush(key,object);
    }

    /**
     * 右出
     * @param key
     * @return
     */
    public Object rightPop(String key){
        return  listOperations.rightPop(key);
    }

    /**
     * 左 进
     * @param key
     * @param object
     * @return
     */
    public Long leftPush(String key,Object object){
        return  listOperations.leftPush(key,object);
    }

    /**
     * 左出
     * @param key
     * @return
     */
    public Object leftPop(String key){
        return  listOperations.leftPop(key);
    }


    /**
     * 获取 object 对象
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        Object o = redisTemplate.opsForValue().get(key);
        return (T)o;
    }

    /**
     * set object
     * @param key
     * @param object
     * @param expire
     * @param unit
     */
    public void set(String key, Object object, long expire,TimeUnit unit) {
        redisTemplate.opsForValue().set(key,object);
        redisTemplate.expire(key, expire, unit);
    }





    /**
     *  选择数据库，使用完请重新设置为默认db
     * @param db
     */
    public synchronized void selectDB(RedisTemplate template,int db){
        LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory)template.getConnectionFactory();
        connectionFactory.setDatabase(db);
        connectionFactory.resetConnection();
    }


}
