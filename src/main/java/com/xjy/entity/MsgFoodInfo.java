package com.xjy.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 徐静钰 on 2017/8/24.
 */
public class MsgFoodInfo implements Parcelable {

    private String name;
    private String icon;
    private String info;
    private String detailurl;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.icon);
        dest.writeString(this.info);
        dest.writeString(this.detailurl);
    }

    public MsgFoodInfo() {
    }

    protected MsgFoodInfo(Parcel in) {
        this.name = in.readString();
        this.icon = in.readString();
        this.info = in.readString();
        this.detailurl = in.readString();
    }

    public static final Parcelable.Creator<MsgFoodInfo> CREATOR = new Parcelable.Creator<MsgFoodInfo>() {
        @Override
        public MsgFoodInfo createFromParcel(Parcel source) {
            return new MsgFoodInfo(source);
        }

        @Override
        public MsgFoodInfo[] newArray(int size) {
            return new MsgFoodInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDetailurl() {
        return detailurl;
    }

    public void setDetailurl(String detailurl) {
        this.detailurl = detailurl;
    }

    public static Creator<MsgFoodInfo> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "MsgFoodInfo{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", info='" + info + '\'' +
                ", detailurl='" + detailurl + '\'' +
                '}';
    }
}
