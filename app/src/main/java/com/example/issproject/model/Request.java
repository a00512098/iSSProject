
package com.example.issproject.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request implements Parcelable
{

    @SerializedName("altitude")
    @Expose
    private Integer altitude;
    @SerializedName("datetime")
    @Expose
    private Integer datetime;
    @SerializedName("latitude")
    @Expose
    private Integer latitude;
    @SerializedName("longitude")
    @Expose
    private Integer longitude;
    @SerializedName("passes")
    @Expose
    private Integer passes;
    public final static Creator<Request> CREATOR = new Creator<Request>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Request createFromParcel(Parcel in) {
            return new Request(in);
        }

        public Request[] newArray(int size) {
            return (new Request[size]);
        }

    }
    ;

    protected Request(Parcel in) {
        this.altitude = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.datetime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.latitude = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.longitude = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.passes = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Request() {
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Integer getDatetime() {
        return datetime;
    }

    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(altitude);
        dest.writeValue(datetime);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(passes);
    }

    public int describeContents() {
        return  0;
    }

}
