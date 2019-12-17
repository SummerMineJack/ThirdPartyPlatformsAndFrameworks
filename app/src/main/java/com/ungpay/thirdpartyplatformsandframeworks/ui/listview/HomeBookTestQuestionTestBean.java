package com.ungpay.thirdpartyplatformsandframeworks.ui.listview;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class HomeBookTestQuestionTestBean implements Parcelable {

    public String questionTitle;
    public ArrayList<HomeBookTestQuestionTestBeanContent> orderList;


    protected HomeBookTestQuestionTestBean(Parcel in) {
        orderList = in.createTypedArrayList(HomeBookTestQuestionTestBeanContent.CREATOR);
    }

    public HomeBookTestQuestionTestBean() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(orderList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeBookTestQuestionTestBean> CREATOR = new Creator<HomeBookTestQuestionTestBean>() {
        @Override
        public HomeBookTestQuestionTestBean createFromParcel(Parcel in) {
            return new HomeBookTestQuestionTestBean(in);
        }

        @Override
        public HomeBookTestQuestionTestBean[] newArray(int size) {
            return new HomeBookTestQuestionTestBean[size];
        }
    };

    public ArrayList<HomeBookTestQuestionTestBeanContent> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<HomeBookTestQuestionTestBeanContent> orderList) {
        this.orderList = orderList;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    /**
     *  获取Item内容
     *
     * @param pPosition
     * @return
     */
    public String getItem(int pPosition) {
        // Category排在第一位
        if (pPosition == 0) {
            return getQuestionTitle();
        } else {
            return orderList.get(pPosition - 1).getQuestionContent();
        }
    }

    /**
     * 当前类别Item总数。Category也需要占用一个Item
     * @return
     */
    public int getItemCount() {
        return orderList.size() + 1;
    }
}
