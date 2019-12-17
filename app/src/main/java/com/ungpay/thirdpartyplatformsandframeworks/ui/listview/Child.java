package com.ungpay.thirdpartyplatformsandframeworks.ui.listview;

public class Child {
    private String userid;
    private String fullname;
    private String username;
    private boolean isChecked = false;

    public void toggle() {
        this.isChecked = !this.isChecked;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}