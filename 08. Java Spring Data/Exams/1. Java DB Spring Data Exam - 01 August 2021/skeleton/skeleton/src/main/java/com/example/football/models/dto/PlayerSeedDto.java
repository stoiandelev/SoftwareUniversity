package com.example.football.models.dto;

import com.example.football.models.entity.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDto {

    @XmlElement(name = "first-name")
    @Size(min = 2)
    private String firstName;

    @XmlElement(name = "last-name")
    @Size(min = 2)
    private String lastName;

    @XmlElement
    @Email
    private String email;

    @XmlElement(name = "birth-date")
    private String birthDay;

    @XmlElement
    private Position position;

    @XmlElement(name = "town")
    private TownNameDTO townName;

    @XmlElement(name = "team")
    private TeamNameDTO teamName;

    @XmlElement(name = "stat")
    private StatIdDTO statName;









    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TownNameDTO getTownName() {
        return townName;
    }

    public void setTownName(TownNameDTO townName) {
        this.townName = townName;
    }

    public TeamNameDTO getTeamName() {
        return teamName;
    }

    public void setTeamName(TeamNameDTO teamName) {
        this.teamName = teamName;
    }

    public StatIdDTO getStatName() {
        return statName;
    }

    public void setStatName(StatIdDTO statName) {
        this.statName = statName;
    }
}
