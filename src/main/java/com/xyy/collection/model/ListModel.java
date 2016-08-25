package com.xyy.collection.model;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/24 Project: JavaSource
 */
public class ListModel {
    private String name;
    private int age;

    public ListModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
       // HashKeyModel that = (HashKeyModel) o;
        System.out.println("HashKeyModel.equals["+toString()+"]");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListModel that = (ListModel) o;

        if (getAge() != that.getAge()) return false;
        return getName().equals(that.getName());

    }

    @Override
    public int hashCode() {
        System.out.println("HashKeyModel.hashCode["+toString()+"]");
       int result = getName().hashCode();
        result = 31 * result + getAge();
        return result;
      //  return getAge();
    }

    @Override
    public String toString() {
        return "HashKeyModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

/*    public int compareTo(Object o) {
        ListModel that = (ListModel) o;
        System.out.println(toString()+"compareTo"+that);
        return getAge() - that.getAge();
    }*/
}
