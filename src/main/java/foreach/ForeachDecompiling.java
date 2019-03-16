package foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 功能：
 * 我们使用的增强for循环，其实是Java提供的语法糖，其实现原理是借助Iterator进行元素的遍历。
 *
 * 但是如果在遍历过程中，不通过Iterator，而是通过集合类自身的方法对集合进行添加/删除操作。
 * 那么在Iterator进行下一次的遍历时，经检测发现有一次集合的修改操作并未通过自身进行，
 * 那么可能是发生了并发被其他线程执行的，这时候就会抛出异常，来提示用户可能发生了并发修改，这就是所谓的fail-fast机制。
 *
 * 当然还是有很多种方法可以解决这类问题的。比如使用普通for循环、使用Iterator进行元素删除、使用Stream的filter、使用fail-safe的类等。
 *
 * 如果是并发场景，建议使用concurrent包中的容器，
 * 如果是单线程场景，Java8之前的代码中，建议使用Iterator进行元素删除，
 * Java8及更新的版本中，可以考虑使用Stream及filter。
 *
 * @author kmm on 2019/3/5
 */
public class ForeachDecompiling {
    public static void main(String[] args) {

        // 使用ImmutableList初始化一个List
        List<String> userNames = new ArrayList<String>(){{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }
        };

//                ImmutableList.of("Hollis", "hollis", "HollisChuang", "H");

        Iterator iterator = userNames.iterator();
        do
        {
            if(!iterator.hasNext()) {
                break;
            }
            //在进行remove操作后的下一个next操作时会进行判断
            String userName = (String)iterator.next();
            if(userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        } while(true);
        System.out.println(userNames);
    }

}
