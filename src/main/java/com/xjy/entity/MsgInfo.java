package com.xjy.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 徐静钰 on 2017/8/23.
 */
public class MsgInfo implements Parcelable {

    private int type;//1左 2右
    private String code;
    private String text;
    private String url;
    private List<Object> list;

    public MsgInfo() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public static Creator<MsgInfo> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeString(this.code);
        dest.writeString(this.text);
        dest.writeString(this.url);
        dest.writeList(this.list);
    }

    protected MsgInfo(Parcel in) {
        this.type = in.readInt();
        this.code = in.readString();
        this.text = in.readString();
        this.url = in.readString();
        this.list = new ArrayList<Object>();
        in.readList(this.list, Object.class.getClassLoader());
    }

    public static final Creator<MsgInfo> CREATOR = new Creator<MsgInfo>() {
        @Override
        public MsgInfo createFromParcel(Parcel source) {
            return new MsgInfo(source);
        }

        @Override
        public MsgInfo[] newArray(int size) {
            return new MsgInfo[size];
        }
    };

    @Override
    public String toString() {
        return "MsgInfo{" +
                "type=" + type +
                ", code='" + code + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", list=" + list +
                '}';
    }
}
