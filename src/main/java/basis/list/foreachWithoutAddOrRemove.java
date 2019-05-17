package basis.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class foreachWithoutAddOrRemove {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (Objects.equals("2", item)) {
                iterator.remove();
            }
        }
        System.out.println("basis.list:"+list);
        System.out.println("iterator:"+iterator);


        //region 该注释内的方法强制不使用，因为会报：java.util.ConcurrentModificationException
        List<String> list2 = new ArrayList();
        list2.add("1");
        list2.add("2");
        for (String s : list2) {
            if (Objects.equals("2", s)) {
                list2.remove(s);
            }
        }
        System.out.println("list2:"+list2);
        //endregion
    }
}
