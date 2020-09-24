package com.geekbrains.coolimage.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PixabayResponse {
    @Expose
    @SerializedName("total")
    private int total;

    @Expose
    @SerializedName("totalHits")
    private int totalHits;

    @Expose
    @SerializedName("hits")
    private List<Hit> hits;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }
}
