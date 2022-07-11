package com.example.xmlexercise.model.dto.usersSeeds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedRootDto {

    @XmlElement(name = "user")
    private List<UserSeedDto> user;



    public List<UserSeedDto> getUser() {
        return user;
    }

    public void setUser(List<UserSeedDto> user) {
        this.user = user;
    }
}
