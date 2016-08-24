package com.xyy.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/24 Project: JavaSource
 */
public class HashMapTest {
    public static void main( String[] args )
    {
        /**
         * HashMap 底层是数组，数组里面放的是Node（链表），
         * 通过hashCode计算数组的下标，如果hashCode相同会比较key的equals方法，
         * 如果equals(o)=true会覆盖之前的值，如果为false会在该坐标的链表后面添加
         *
         * 获取值的时候先根据key的hashCode获取下标位置，遍历该节点的链表，比较hasCode和equals 相同返回，没有返回null
         */
        HashKeyModel key1=new HashKeyModel("key1",19);
        HashKeyModel key2=new HashKeyModel("key2",19);
        HashKeyModel key3=new HashKeyModel("key3",19);
        HashKeyModel key4=new HashKeyModel("key4",22);
        Map<HashKeyModel,HashKeyModel> hashMap = new HashMap();
        hashMap.put(key1,key1);
        hashMap.put(key2,key2);
        hashMap.put(key3,key3);
        hashMap.put(key4,key4);
        System.out.println(hashMap.get(key1));
        System.out.println(hashMap.get(key2));
        System.out.println(hashMap.get(key3));
        System.out.println(hashMap.get(key4));
    }
}
