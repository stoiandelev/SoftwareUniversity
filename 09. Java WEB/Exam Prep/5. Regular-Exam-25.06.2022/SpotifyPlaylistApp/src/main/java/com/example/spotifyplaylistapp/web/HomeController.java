package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserSession userSession;
    private final SongService songService;
    private final UserService userService;

    public HomeController(UserSession userSession, SongService songService,
                          UserService userService) {
        this.userSession = userSession;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping()
    public String homePage(Model model) {


        //if no user in session
        if (userSession.getId() == null) {
            return "index";
        }

        model.addAttribute("popSongs", songService.findAllPopSongs());
        model.addAttribute("rockSongs", songService.findAllRockSongs());
        model.addAttribute("jazzSongs", songService.findAllJazzSongs());
        model.addAttribute("totalSongDuration", userService.findTotalPlaylistDuration());
        model.addAttribute("userSongs", userService.currentUserPlaylist());

        return "home";
    }
}
