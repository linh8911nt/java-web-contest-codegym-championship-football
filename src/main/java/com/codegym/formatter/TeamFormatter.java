package com.codegym.formatter;

import com.codegym.model.Team;
import com.codegym.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class TeamFormatter implements Formatter<Team> {

    @Autowired
    TeamService teamService;

    public TeamFormatter(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public Team parse(String text, Locale locale) throws ParseException {
        return teamService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Team object, Locale locale) {
        return null;
    }
}
