package request;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static check.CheckUtil.isEmpty;
import static check.CheckUtil.isNotEmpty;

/**
 * @author xulin
 * @date 2020/4/7 13:45
 */
public class RequestUtil {

    /**
     * 获取用户的真实的请求的ip
     */
    public static String getIp() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String ip = request.getHeader("X-Forwarded-For");
        if (isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (!isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 直接获取请求中的response
     * <p>通常获取request的方式我们可以注入获取</p>
     * <p>@Autowired private HttpServletRequest request;</p>
     * <p>可是同样的方式获取response却不可以，下面提供一种方式用于获取response</p>
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
    }
}
