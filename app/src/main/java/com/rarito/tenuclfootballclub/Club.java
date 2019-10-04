package com.rarito.tenuclfootballclub;

import android.os.Parcel;
import android.os.Parcelable;

public class Club implements Parcelable {
    private int logo;
    private String nameClub;
    private String description;

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getNameClub() {
        return nameClub;
    }

    public void setNameClub(String nameClub) {
        this.nameClub = nameClub;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.logo);
        dest.writeString(this.nameClub);
        dest.writeString(this.description);
    }

    public Club() {
    }

    protected Club(Parcel in) {
        this.logo = in.readInt();
        this.nameClub = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Club> CREATOR = new Parcelable.Creator<Club>() {
        @Override
        public Club createFromParcel(Parcel source) {
            return new Club(source);
        }

        @Override
        public Club[] newArray(int size) {
            return new Club[size];
        }
    };
}
