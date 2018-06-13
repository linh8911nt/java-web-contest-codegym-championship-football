package com.codegym.service;

import com.codegym.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeamService {

    Iterable<Team> findAll();

    Team findById(Long id);

    void save(Team team);

    void delete(Long id);
}
