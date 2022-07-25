package com.example.football.models.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity {

    @Column(nullable = false, scale = 2)
    private Float shooting;

    @Column(nullable = false, scale = 2)
    private Float passing;

    @Column(nullable = false, scale = 2)
    private Float endurance;


    @OneToOne(mappedBy = "stat")
    private Player player;






    public Stat() {
    }

    public Float getShooting() {
        return shooting;
    }

    public void setShooting(Float shooting) {
        this.shooting = shooting;
    }

    public Float getPassing() {
        return passing;
    }

    public void setPassing(Float passing) {
        this.passing = passing;
    }

    public Float getEndurance() {
        return endurance;
    }

    public void setEndurance(Float endurance) {
        this.endurance = endurance;
    }
}
