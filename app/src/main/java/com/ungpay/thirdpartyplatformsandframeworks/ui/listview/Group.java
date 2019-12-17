package com.ungpay.thirdpartyplatformsandframeworks.ui.listview;

import java.util.ArrayList;

public class Group {
    private String id;
    private String title;
    private ArrayList<Child> children;

    public Group() {
        children=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void addChildrenItem(Child child) {
        children.add(child);
    }

    public int getChildrenCount() {
        return children.size();
    }

    public Child getChildItem(int index) {
        return children.get(index);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }
}