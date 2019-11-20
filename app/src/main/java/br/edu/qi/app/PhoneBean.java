package br.edu.qi.app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/5/13.
 */
public class PhoneBean implements Parcelable {
    private String phoneNumber;
    private String phoneName;
    private boolean isSelected;

    public PhoneBean(String phoneName,String phoneNumber){
        setPhoneName(phoneName);
        setPhoneNumber(phoneNumber);
    }

    protected PhoneBean(Parcel in) {
        phoneNumber = in.readString();
        phoneName = in.readString();
        isSelected = in.readByte() != 0;
    }

    public static final Creator<PhoneBean> CREATOR = new Creator<PhoneBean>() {
        @Override
        public PhoneBean createFromParcel(Parcel in) {
            return new PhoneBean(in);
        }

        @Override
        public PhoneBean[] newArray(int size) {
            return new PhoneBean[size];
        }
    };

    public PhoneBean() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }
    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(phoneNumber);
        parcel.writeString(phoneName);
        parcel.writeByte((byte) (isSelected ? 1 : 0));
    }
}
