package com.codegym.controller;

import com.codegym.model.Team;
import com.codegym.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public ModelAndView showTeams(){
        Iterable<Team> teams = teamService.findAll();

        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("teams", teams);
        return modelAndView;
    }

    @GetMapping("/create-team")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/team/create");
        modelAndView.addObject("team", new Team());
        return modelAndView;
    }

    @PostMapping("/create-team")
    public ModelAndView createTeam(@ModelAttribute("team") Team team){
        teamService.save(team);

        ModelAndView modelAndView = new ModelAndView("/team/create");
        modelAndView.addObject("team", new Team());
        modelAndView.addObject("message", "Create Success!!!");
        return modelAndView;
    }

    @GetMapping("/view-team/{id}")
    public ModelAndView viewTeam(@PathVariable("id") Long id){
        Team team = teamService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/team/view");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @GetMapping("/edit-team/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        Team team = teamService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/team/edit");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("/edit-team")
    public ModelAndView editTeam(@ModelAttribute("team") Team team){
        teamService.save(team);

        ModelAndView modelAndView = new ModelAndView("/team/edit");
        modelAndView.addObject("message", "Update Success!!!");
        return modelAndView;
    }

    @GetMapping("/delete-team/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id){
        Team team = teamService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/team/delete");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("/delete-team")
    public String deleteTeam(@ModelAttribute("team") Team team){
        teamService.delete(team.getId());

        return "redirect:/";
    }
}
