package com.xyy.collection;

import com.xyy.collection.model.ListModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/24 Project: JavaSource
 */
public class LinkedListTest {
    public static void main( String[] args )
    {
        /**
         * 底层是链表，可以存放null，但是用到排序Collections.sort（）时如果有空值会报空指针异常
         */
      List<ListModel> list = new LinkedList();
        ListModel key1=new ListModel("key1",19);
        ListModel key2=new ListModel("key2",19);
        ListModel key3=new ListModel("key3",19);
        ListModel key4=new ListModel("key4",22);
        list.add(key1);
        list.add(key3);
        list.add(key4);
        list.add(key2);
        list.add(null);
        Collections.sort(list, new Comparator<ListModel>() {
            public int compare(ListModel o1, ListModel o2) {
                System.out.println(o1+"compareTo"+o2);
                return o1.getAge() - o2.getAge();
            }
        });
        for(ListModel model :list){
            System.out.println(model);
        }
    }
}
