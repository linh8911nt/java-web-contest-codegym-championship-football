package com.codegym.controller;

import com.codegym.model.Player;
import com.codegym.model.Team;
import com.codegym.service.PlayerService;
import com.codegym.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @ModelAttribute("teams")
    public Iterable<Team> teams(){

        return teamService.findAll();
    }

    @GetMapping("/create-player")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("player", new Player());
        return modelAndView;
    }

    @PostMapping("/create-player")
    public ModelAndView createForm(@ModelAttribute("player") Player player){
        playerService.save(player);

        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("player", new Player());
        modelAndView.addObject("message", "Create Success!!!");
        return modelAndView;
    }
}
