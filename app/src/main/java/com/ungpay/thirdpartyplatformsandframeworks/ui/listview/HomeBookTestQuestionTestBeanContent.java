package com.ungpay.thirdpartyplatformsandframeworks.ui.listview;

import android.os.Parcel;
import android.os.Parcelable;

public class HomeBookTestQuestionTestBeanContent implements Parcelable {

    public String questionContent;

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }


    public HomeBookTestQuestionTestBeanContent() {
    }

    protected HomeBookTestQuestionTestBeanContent(Parcel in) {
        questionContent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionContent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeBookTestQuestionTestBeanContent> CREATOR = new Creator<HomeBookTestQuestionTestBeanContent>() {
        @Override
        public HomeBookTestQuestionTestBeanContent createFromParcel(Parcel in) {
            return new HomeBookTestQuestionTestBeanContent(in);
        }

        @Override
        public HomeBookTestQuestionTestBeanContent[] newArray(int size) {
            return new HomeBookTestQuestionTestBeanContent[size];
        }
    };
}
