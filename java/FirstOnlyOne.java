package question35;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Claudius on 2017/6/14.
 * 找出字符串中第一个只出现过一次的字符
 * 使用linkedhashmap ，用来按照顺序记录字符与次数。
 */
public class FirstOnlyOne {
    public static void main(String[] args) {
        FirstOnlyOne firstOnlyOne = new FirstOnlyOne();
        System.out.print(firstOnlyOne.find("abaccdeffb"));
    }
    public String find(String str){
        LinkedHashMap<String,Integer> record = new LinkedHashMap<>();
        int length = str.length();
        for (int i = 0; i <length ; i++) {
            String key = str.substring(i,i+1);
            if (record.containsKey(key)){
                record.put(key,record.get(key)+1);
            }else
                record.put(key,1);
        }
        for (int i = 0; i <length ; i++) {
            Iterator<Map.Entry<String, Integer>> iterator = record.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String,Integer> entry = iterator.next();
                if (entry.getValue() == 1)
                    return entry.getKey();
            }
        }
        return  null;
    }
}
