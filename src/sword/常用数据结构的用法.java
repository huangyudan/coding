package sword;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 常用数据结构的用法 {
    public static void main(String[] args) {
        //hashmap
        Map map=new HashMap();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println("map.get(key) is :"+map.get(key));
        }



        //stringbuffer
        StringBuffer d = new StringBuffer("lalala");
        d.setCharAt(0,'h');
        d.append(1);
        d.append(new char[]{'h','y','d'});
        System.out.println(d);

    }

}
