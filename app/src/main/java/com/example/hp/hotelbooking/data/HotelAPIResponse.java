package com.example.hp.hotelbooking.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotelAPIResponse {

    @SerializedName("next_page_token")
    @Expose
    private String nextPageToken;

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    @SerializedName("status")
    @Expose
    private String status;

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
