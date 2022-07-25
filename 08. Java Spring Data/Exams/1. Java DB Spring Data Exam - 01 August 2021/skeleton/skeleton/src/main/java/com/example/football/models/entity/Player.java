package com.example.football.models.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "birth_day", nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Position position;

    @OneToOne(optional = false)
    private Stat stat;

    @ManyToOne(optional = false)
    private Team team;

    @ManyToOne(optional = false)
    private Town town;





    public Player() {
    }

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return String.format("Player - %s %s%n" +
                        "\tPosition - %s%n" +
                        "\tTeam - %s%n" +
                        "\tStadium - %s",
                this.firstName, this.lastName,
                this.position.toString(),
                this.team.getName(),
                this.team.getStadiumName());
    }


}
