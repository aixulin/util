package check;

import org.springframework.util.AntPathMatcher;

/**
 * 路径的匹配
 */
public class MatchPath {
    private static AntPathMatcher resPathMatcher = new AntPathMatcher();
    public static void main(String[] args) {
        String patternStr = "com.hex.dop.**";
        String path = "com.hex.dop.devalue.dao.DevaluePlanCalendarMapper";
        boolean match = resPathMatcher.match(patternStr, path);
        System.out.println(match);
    }
}
