package foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能：使用Stream及filter 进行ArrayList操作
 *
 * 如果是并发场景，建议使用concurrent包中的容器，
 * 如果是单线程场景，Java8之前的代码中，建议使用Iterator进行元素删除，
 * Java8及更新的版本中，可以考虑使用Stream及filter。
 *
 * @author kmm on 2019/3/5
 */
public class StreamOperateArrayList {
    public static void main(String[] args){
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        userNames = userNames.stream().filter(userName -> !userName.equals("Hollis")).collect(Collectors.toList());
        System.out.println(userNames);
    }
}
