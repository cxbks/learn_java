package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能：
 *
 * @author kmm on 2019/2/28
 */
public class MapToLIst {

    public static void main(String[] args){
        Map map = new HashMap();
        map.put("1", "a");
        map.put('2', 'b');
        map.put('3', 'c');
        System.out.println(map);
// 输出所有的值
        System.out.println(map.keySet());
// 输出所有的键
        System.out.println(map.values());
// 将map的值转化为List
        List list = new ArrayList(map.values());
        System.out.println("list:"+list);
// 将map的值转化为Set
        Set set = new HashSet(map.values());
        System.out.println(set);
    }
}
