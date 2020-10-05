package com.geekbrains.coolimage.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "photo_base")
public class Hit {

    @PrimaryKey
    @Expose
    @SerializedName("id")
    public int id;

    @Expose
    @SerializedName("previewURL")
    public String previewUrl;

    @Expose
    @SerializedName("webformatURL")
    public String webFormatUrl;

    @Expose
    @SerializedName("largeImageURL")
    public String largeImageUrl;

    @Expose
    public long clickTimestamp;

    @Expose
    public long expireTimestamp;

    /*@Override
    public String toString(){
        return "Hit{" +
                "id=" + id +
                ", previewUrl'" + previewUrl + '\'' +
                ", webFormatUrl'" + webFormatUrl + '\'' +
                ", largeImageUrl'" + largeImageUrl + '\'' +
                '}';
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getWebFormatUrl() {
        return webFormatUrl;
    }

    public void setWebFormatUrl(String webFormatUrl) {
        this.webFormatUrl = webFormatUrl;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public long getClickTimestamp() {
        return clickTimestamp;
    }

    public void setClickTimestamp(long clickTimestamp) {
        this.clickTimestamp = clickTimestamp;
    }

    public long getExpireTimestamp() {
        return expireTimestamp;
    }

    public void setExpireTimestamp(long expireTimestamp) {
        this.expireTimestamp = expireTimestamp;
    }
}
