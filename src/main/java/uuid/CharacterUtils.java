package uuid;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author xulin
 * @date 2020/4/14 11:32
 * @Description 生成随机的字符
 */
public class CharacterUtils {
    /**
     * @param length 长度
     * @return 随机数
     * 根据长度获取随机数 可以适当调整 定义四个字符串只是为了好看
     */
    public static String getRandomString(int length) {
        // 定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%";
        // 由Random生成随机数
        StringBuffer sb = new StringBuffer();
        // 长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            // 产生0-61的数字
            int number = RandomUtils.nextInt(0,67);
            // 将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        // 将承载的字符转换成字符串
        return sb.toString();
    }

    /**
     * 产生 length个随机数字字符串
     */
    public static String getRandomNumberString(int length) {
        // 由Random生成随机数
        StringBuffer sb = new StringBuffer();
        // 长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            // 产生0-9的数字
            int numNum = RandomUtils.nextInt(0, 10);
            // 将产生的数字通过length次承载到sb中
            sb.append(numNum);
        }
        // 将承载的字符转换成字符串
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(getRandomString(3));
    }


}
