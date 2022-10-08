package com.example.cloudinary.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cloudinary")
public class CloudinaryConf {

    private String cloudName;
    private String apiKey;
    private String apiSecret;

    /**
     * Set the cloud name associated with the cloudinary account
     */

    public CloudinaryConf() {
    }

    public String getCloudName() {
        return cloudName;
    }

    public CloudinaryConf setCloudName(String cloudName) {
        this.cloudName = cloudName;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public CloudinaryConf setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public CloudinaryConf setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }
}
