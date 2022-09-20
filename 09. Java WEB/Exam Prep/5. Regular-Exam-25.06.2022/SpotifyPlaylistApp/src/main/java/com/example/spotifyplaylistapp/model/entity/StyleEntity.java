package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "styles")
public class StyleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    @NotNull
    private StyleEnum styleName;

    @Column
    private String description;

    @OneToMany(mappedBy = "style", fetch = FetchType.EAGER)
    private List<SongEntity> songs;

    public StyleEntity() {
    }

    public StyleEnum getStyleName() {
        return styleName;
    }

    public StyleEntity setStyleName(StyleEnum styleName) {
        this.styleName = styleName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StyleEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<SongEntity> getSongs() {
        return songs;
    }

    public StyleEntity setSongs(List<SongEntity> songs) {
        this.songs = songs;
        return this;
    }
}
