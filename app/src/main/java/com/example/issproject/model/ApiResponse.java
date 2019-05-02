
package com.example.issproject.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse implements Parcelable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("response")
    @Expose
    private List<Response> response = null;
    public final static Creator<ApiResponse> CREATOR = new Creator<ApiResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ApiResponse createFromParcel(Parcel in) {
            return new ApiResponse(in);
        }

        public ApiResponse[] newArray(int size) {
            return (new ApiResponse[size]);
        }

    }
    ;

    protected ApiResponse(Parcel in) {
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.request = ((Request) in.readValue((Request.class.getClassLoader())));
        in.readList(this.response, (Response.class.getClassLoader()));
    }

    public ApiResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
        dest.writeValue(request);
        dest.writeList(response);
    }

    public int describeContents() {
        return  0;
    }

}
