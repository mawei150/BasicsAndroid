package com.example.basicsandroid.activity.expandlistview;


import java.util.List;

/**
 * @author MW
 * @date 2019/9/18
 * <p>
 * 描述：一级标签
 */
public class BeanFirstItemBase {
    private String name;
    private List<BeanSecondItem> beanSecondItem;

    public List<BeanSecondItem> getBeanSecondItem() {
        return beanSecondItem;
    }

    public void setBeanSecondItem(List<BeanSecondItem> beanSecondItem) {
        this.beanSecondItem = beanSecondItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static class BeanSecondItem {

        private String name;

        public BeanSecondItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
