package uuid;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Schedule {

    /**
     * 按照length天 给number人排班
     */
    public static void scheduleInfo(int number,int length){
        for (int i = 0; i <= length; i++) {
            List<String> operateList = Stream.of("王", "刘", "徐", "李", "程").collect(Collectors.toList());
            for (int j = number; j > 0 && i <= length; j--, i++) {
                Integer numNum = RandomUtils.nextInt(0, operateList.size());
                System.out.println("随机数number是：" + numNum + "map中的值是：" + operateList.get(numNum));
                operateList.remove(operateList.get(numNum));
            }
        }
    }


    public static void main(String[] args) {
        scheduleInfo(5,6);

    }
}
