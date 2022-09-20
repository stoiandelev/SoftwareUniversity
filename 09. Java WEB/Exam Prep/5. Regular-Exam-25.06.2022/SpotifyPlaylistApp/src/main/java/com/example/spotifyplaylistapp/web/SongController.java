package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.binding.SongDTO;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import com.example.spotifyplaylistapp.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final StyleService styleService;
    private final UserSession userSession;

    public SongController(SongService songService, StyleService styleService,
                          UserSession userSession) {
        this.songService = songService;
        this.styleService = styleService;
        this.userSession = userSession;
    }

    @ModelAttribute
    public SongDTO songDTO() {
        return new SongDTO();
    }

    @GetMapping("/add")
    public String addSong() {
        if (userSession.getId() == null) {
            return "redirect:/users/login";
        }
        return "song-add";
    }

    @PostMapping("/add")
    public String addSongConfirm(@Valid SongDTO songDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("songDTO", songDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songDTO", bindingResult);
            return "redirect:add";
        }

        boolean isAdded = songService.addSong(songDTO);

        if (!isAdded) {
            redirectAttributes.addFlashAttribute("songDTO", songDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songDTO", bindingResult);
            redirectAttributes.addFlashAttribute("styles", styleService.findAllStyles());
            return "redirect:add";
        }

        return "redirect:/";
    }

    @GetMapping("/add/{songId}")
    public String addSongToPlaylist(@PathVariable Long songId) {
        songService.saveSongToPlaylist(songId);
        return "redirect:/";
    }

    @GetMapping("/remove-all")
    public String removeSongFromPlaylist() {
        songService.removeSongFromPlaylist();
        return "redirect:/";
    }
}
