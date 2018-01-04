package com.xjy.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 徐静钰 on 2017/8/24.
 */
public class MsgNewsInfo implements Parcelable {
    private String article;
    private String source;
    private String icon;
    private String detailurl;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.article);
        dest.writeString(this.source);
        dest.writeString(this.icon);
        dest.writeString(this.detailurl);
    }

    public MsgNewsInfo() {
    }

    protected MsgNewsInfo(Parcel in) {
        this.article = in.readString();
        this.source = in.readString();
        this.icon = in.readString();
        this.detailurl = in.readString();
    }

    public static final Parcelable.Creator<MsgNewsInfo> CREATOR = new Parcelable.Creator<MsgNewsInfo>() {
        @Override
        public MsgNewsInfo createFromParcel(Parcel source) {
            return new MsgNewsInfo(source);
        }

        @Override
        public MsgNewsInfo[] newArray(int size) {
            return new MsgNewsInfo[size];
        }
    };

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDetailurl() {
        return detailurl;
    }

    public void setDetailurl(String detailurl) {
        this.detailurl = detailurl;
    }

    public static Creator<MsgNewsInfo> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "MsgNewsInfo{" +
                "article='" + article + '\'' +
                ", source='" + source + '\'' +
                ", icon='" + icon + '\'' +
                ", detailurl='" + detailurl + '\'' +
                '}';
    }
}
