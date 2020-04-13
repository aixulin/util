package secret;

import java.util.Base64;

/**
 * base64处理
 *
 * @author billymac
 * @version 1.0
 * @date 2017年12月26日 下午3:01:29
 * @since JDK1.7
 */
public class Base64Util {

    /**
     * 字节数组base64加密成字符串
     *
     * @param src
     * @return
     * @author billymac
     * @date 2017年12月26日 下午3:03:40
     */
    public static String encryptBase64(byte[] src) {
        if (src == null)
            return null;
        return Base64.getEncoder().encodeToString(src);
    }

    /**
     * 字符串base64解密成字节数组
     *
     * @param src
     * @return
     * @author billymac
     * @date 2017年12月26日 下午3:06:22
     */
    public static byte[] decryptBase64(String src) {
        if (src == null || "".equals(src))
            return null;
        return Base64.getDecoder().decode(src);
    }

    /**
     * 获取扩展名
     *
     * @param base64Prix base64编码的前缀
     * @return 获取
     */
    public static String getExtension(String base64Prix) throws Exception {
        String suffix = "";
        if ("data:image/jpeg;".equalsIgnoreCase(base64Prix) || "data:img/jpg;".equalsIgnoreCase(base64Prix)) {
            // data:image/jpeg;base64,base64编码的jpeg图片数据
            suffix = ".jpg";
        } else if ("data:image/x-icon;".equalsIgnoreCase(base64Prix)) {
            // data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        } else if ("data:image/gif;".equalsIgnoreCase(base64Prix)) {
            // data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        } else if ("data:image/png;".equalsIgnoreCase(base64Prix)) {
            // data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        } else {
            throw new Exception("上传图片格式不合法");
        }
        return suffix;
    }
}
