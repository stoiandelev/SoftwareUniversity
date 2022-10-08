package com.example.cloudinary.service.impl;

public class CloudinaryImage {

    private String url;
    private String publicId;
    private String title;

    public CloudinaryImage() {
    }

    public String getUrl() {
        return url;
    }

    public CloudinaryImage setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public CloudinaryImage setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CloudinaryImage setTitle(String title) {
        this.title = title;
        return this;
    }
}
