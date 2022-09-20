package com.example.spotifyplaylistapp.model.binding;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;


public class SongDTO {

    @Size(min = 3, max = 20, message = "Performer length must be between 3 and 20 character!")
    @NotNull
    private String performer;

    @Size(min = 2, max = 20, message = "Title length must be between 2 and 20 character!")
    @NotNull
    private String title;

    @Positive(message = "Duration must be positive number!")
    @NotNull
    private Integer duration;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The date cannot be in future!")
    private LocalDate releaseDate;

    @NotBlank(message = "You must select a style!")
    private String style;


    public SongDTO() {
    }

    public String getPerformer() {
        return performer;
    }

    public SongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongDTO setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public SongDTO setStyle(String style) {
        this.style = style;
        return this;
    }
}
