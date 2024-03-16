package com.meqdaddev.eventapi.controllers;

import com.meqdaddev.eventapi.dto.ClubDto;
import com.meqdaddev.eventapi.models.Club;
import com.meqdaddev.eventapi.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club) {
        clubService.saveClub(club);
        return "redirect:/clubs";

    }
}
