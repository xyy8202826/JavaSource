package com.xyy.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/24 Project: JavaSource
 */
public class TreeMapTest {
    public static void main( String[] args )
    {
        /**
         * TreeMap 是按照key排序的map，因此key需要实现Comparable接口或者创建TreeMap时传入排序器Comparator
         * TreeMap 底层是红黑树（相对平衡的二叉树），每次插入都是从根节点进行遍历，插入之后还要进行重新旋转，平衡
         */
        HashKeyModel key1=new HashKeyModel("key1",19);
        HashKeyModel key2=new HashKeyModel("key2",19);
        HashKeyModel key3=new HashKeyModel("key3",20);
        HashKeyModel key4=new HashKeyModel("key4",22);
        Map<HashKeyModel,HashKeyModel> treeMap = new TreeMap();
        treeMap.put(key1,key1);
        treeMap.put(key2,key2);
        treeMap.put(key3,key3);
        treeMap.put(key4,key4);
        System.out.println(treeMap.get(key1));
        System.out.println(treeMap.get(key2));
        System.out.println(treeMap.get(key3));
        System.out.println(treeMap.get(key4));
    }
}
