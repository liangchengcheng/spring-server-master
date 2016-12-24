package com.lcc.model;

/**
 * Created by lcc on 2016/12/24.
 */
public class SmallNews {
    private Long newsId;

    private String imgUrl;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}
