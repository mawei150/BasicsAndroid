package com.example.basicsandroid.activity.itemtype;

public class BeanItemBase {

    private String name;//内容展示
    private int  type;//标识这条 Item属于布局一或是布局二
    private String  item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BeanItemBase(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public BeanItemBase(String name, int type, String item) {
        this.name = name;
        this.type = type;
        this.item = item;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
