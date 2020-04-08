package uuid;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils {

    /**
     * 随机的UUID 由数字和字符构成 32位
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成13位时间戳+4位随机数的 随机Long型整数
     */
    public static Long uuidLong() {
        return Long.valueOf(String.valueOf(Instant.now().getEpochSecond()) + String.format("%04d", new Random().nextInt(9999)));
    }


    /**
     * 生成10位秒值+7位随机数的随机Long型整数
     */
    public static Long uuidLong2() {
        return Long.valueOf(String.valueOf(Instant.now().getEpochSecond() / 1000) + String.format("%07d", new Random().nextInt(9999999)));
    }


}
