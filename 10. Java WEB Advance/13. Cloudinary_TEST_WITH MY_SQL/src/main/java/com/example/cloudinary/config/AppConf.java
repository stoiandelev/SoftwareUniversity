package com.example.cloudinary.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AppConf {

    private final CloudinaryConf cloudinaryConf;

    public AppConf(CloudinaryConf cloudinaryConf) {
        this.cloudinaryConf = cloudinaryConf;
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                Map.of(
                        "cloud_name", cloudinaryConf.getCloudName(),
                        "api_key", cloudinaryConf.getApiKey(),
                        "api_secret", cloudinaryConf.getApiSecret()
                )
        );
    }


}
