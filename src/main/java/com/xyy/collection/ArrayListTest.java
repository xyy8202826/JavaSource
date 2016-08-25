package com.xyy.collection;

import com.xyy.collection.model.HashKeyModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/24 Project: JavaSource
 */
public class ArrayListTest {
    public static void main( String[] args )
    {
        /**
         * 底层是数组，可以存放null，但是用到排序Collections.sort（）时如果有空值会报空指针异常
         */
      List<HashKeyModel> list = new ArrayList();
        HashKeyModel key1=new HashKeyModel("key1",19);
        HashKeyModel key2=new HashKeyModel("key2",19);
        HashKeyModel key3=new HashKeyModel("key3",19);
        HashKeyModel key4=new HashKeyModel("key4",22);
        list.add(key1);
        list.add(key2);
        list.add(key3);
        list.add(key4);
        list.add(null);
        //Collections.sort(list);
        for(HashKeyModel model :list){
            System.out.println(model);
        }
    }
}
