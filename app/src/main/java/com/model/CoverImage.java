package com.model;

/**
 * Created by wanghy on 2018/5/8.
 */

public class CoverImage {

    private Integer title;
    private Integer imageId;

    public CoverImage(){
        super();
    }

    public CoverImage(Integer title, Integer imageId) {
        super();
        this.title = title;
        this.imageId = imageId;
    }

    public Integer getTitle() {
        return this.title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
